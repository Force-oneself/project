package pers.quan.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import pers.quan.uitls.DBUtils;

/**
 * @Description 
 * @author John、Woo
 * @Date 2019-08-13 17:20
 * 
 */
public class Design {

	// 初始化参数
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	// 设置默认主键字符串
	final static String TABLE_DIY_ID_NAME = "id";
	
	/**
	 * ------------------------以下对dao层封装的通用操作方法-------------------------
	 *  
	 * @Description: 查询的通用方法
	 * @author: 何永泉
	 * @param: @param sql
	 * @param: @param paramsValue
	 * @param: @param clazz
	 * @param: @return      
	 * @return: List<T>      
	 * @throws
	 *
	 */
	public <T> List<T> query(String sql, Object[] paramsValue, Class<T> clazz) {
		try {
			// 返回的集合
			List<T> list = new ArrayList<T>();
			// 对象
			T t = null;

			// 1. 获取连接
			conn = DBUtils.getConnection();
			// 2. 创建stmt对象
			ps = conn.prepareStatement(sql);
			// 3. 获取占位符参数的个数， 并设置每个参数的值
			int count = ps.getParameterMetaData().getParameterCount();
			if (paramsValue != null && paramsValue.length > 0) {
				for (int i = 0; i < count; i++) {
					ps.setObject(i + 1, paramsValue[i]);
				}
			}
			// 4. 执行查询
			rs = ps.executeQuery();
			// 5. 获取结果集元数据
			ResultSetMetaData rsmd = rs.getMetaData();
			// ---> 获取列的个数
			int columnCount = rsmd.getColumnCount();

			// 6. 遍历rs
			while (rs.next()) {
				// 要封装的对象
				t = clazz.newInstance();
				// 7. 遍历每一行的每一列, 封装数据
				for (int i = 0; i < columnCount; i++) {
					// 获取每一列的列名称
					String columnName = rsmd.getColumnName(i + 1);
					// 获取每一列的列名称, 对应的值
					Object value = rs.getObject(columnName);
					// 封装： 设置到t对象的属性中 【BeanUtils组件】
					BeanUtils.copyProperty(t, columnName, value);
				}

				// 把封装完毕的对象，添加到list集合中
				list.add(t);
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DBUtils.closeAll(conn, ps, rs);
		}
	}

	/**
	 * 
	 * @Description: 更新的通用方法
	 * @author: 何永泉
	 * @param: @param sql
	 * @param: @param paramsValue      
	 * @return: void      
	 * @throws
	 *
	 */
	public int update(String sql, Object[] paramsValue) {
		int line = -1;
		try {
			// 获取连接
			conn = DBUtils.getConnection();
			// 设置手动提交事务
			conn.setAutoCommit(false);
			// 创建执行命令的stmt对象
			ps = conn.prepareStatement(sql);
			// 参数元数据： 得到占位符参数的个数
			int count = ps.getParameterMetaData().getParameterCount();

			// 设置占位符参数的值
			if (paramsValue != null && paramsValue.length > 0) {
				// 循环给参数赋值
				for (int i = 0; i < count; i++) {
					ps.setObject(i + 1, paramsValue[i]);
				}
			}
			// 执行更新
			line = ps.executeUpdate();
			// 手动提交事务
			conn.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DBUtils.closeAll(conn, ps, null);
		}
		return line;
	}

	/**
	 * 
	 * @Description 获取属性名集合
	 * @param <T>
	 * @param t
	 * @return
	 */
	public <T> List<String> getAttributeNames(T t) {
		List<String> attrList = new ArrayList<String>();
		
		for (Field field : t.getClass().getDeclaredFields()) {
			attrList.add(field.getName());
		}
		return attrList;
	}

	/**
	 * 
	 * @Description 根据属性名获取属性值 
	 * @param <T>
	 * @param fieldName
	 * @param t
	 * @return
	 */
	public <T> Object getFieldValueByName(String fieldName, T t) {
		Object value = null;
		try {
			// 属性名首字母大写
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			// 拼接getter方法字符串
			String getter = "get" + firstLetter + fieldName.substring(1);
			// 根据字符串获取方法
			Method method = t.getClass().getMethod(getter, new Class[] {});
			// 调用getter方法
			value = method.invoke(t, new Object[] {});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * 
	 * @Description 获取SQL语句预处理的参数，返回一个object集合
	 * @param <T>
	 * @param t
	 * @param idName 数据库表主键对应的实体类中的属性
	 * @return
	 */
	public <T> List<Object> getParamsValues(T t, String idName, boolean bool) {
		List<Object> valueList = new ArrayList<Object>();
		for (String s : getAttributeNames(t)) {
			// 过滤掉主键自动增长的属性
			if (bool && s.equals(idName)) {
				continue;
			}
			valueList.add(getFieldValueByName(s, t));
		}
		return valueList;
	}

	
	
	/**
	 * 
	 * @Description 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list
	 * @param <T>
	 * @param t
	 * @param idName 设置自动增长后过滤id的属性
	 * @param isInsertID 是否需要插入自定义id
	 * @return
	 */
	public <T> List<Map<String, String>> getAttributeInfo(T t, String idName, boolean isInsertID) {
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> infoMap = null;
		for (Field field : t.getClass().getDeclaredFields()) {
			infoMap = new HashMap<>();
			// 当isInsertID为true时，才会进行过滤，默认isInsertID为true
			if (isInsertID && idName.equals(field.getName())) {
				continue;
			}
			// 添加属性的类型
			infoMap.put("type", field.getType().toString());
			// 添加属性的名称
			infoMap.put("name", field.getName());
			// 添加属性的值
			infoMap.put("value", getFieldValueByName(field.getName(), t).toString());
			// 将map添加入list集合中
			list.add(infoMap);
		}
		return list;
	}
	
	/**
	 * ------------------------以下是对SQL语句的加工操作-----------------------------------
	 * 
	 * @Description 自动加工SQL语句,获取insert语句
	 * @param <T>
	 * @param t
	 * @param idName 数据库表主键对应的实体类中的属性
	 * @return
	 * @throws Exception
	 */
	public <T> String getInsertSql(T t, String idName, boolean isInsertID) {
		StringBuilder sqlPrefix = new StringBuilder("insert into ");
		StringBuilder sqlSuffix = new StringBuilder(") values(");
		sqlPrefix.append(t.getClass().toString()
				.substring(t.getClass().toString().lastIndexOf('.') + 1)).append(" (");
		
		for (Iterator<Map<String, String>> iterator 
				= this.getAttributeInfo(t, idName, isInsertID).iterator(); iterator.hasNext();) {
			Map<String, String> map = (Map<String, String>) iterator.next();
			sqlPrefix.append(map.get("name")).append(",");
			sqlSuffix.append("?,");
			
		}
		sqlPrefix.deleteCharAt(sqlPrefix.lastIndexOf(","));
		sqlSuffix.deleteCharAt(sqlSuffix.lastIndexOf(","));
		return sqlPrefix.append(sqlSuffix).append(")").toString();
	}
	
	/**
	 * 
	 * @Description 检查该类是否为null和属性是否未创建
	 * @param <T>
	 * @param t
	 * @return
	 * @throws Exception 
	 */
	public <T> void checkClass(T t) throws RuntimeException {
		if (t == null) {
			throw new RuntimeException("该对象未创建! the Class is null");
		}
		try {
			if (t.getClass().getDeclaredFields().length <= 0) {
				throw new RuntimeException("该对象未定义属性! not found attribute");
			}
		} catch (SecurityException e) {
			throw new RuntimeException("未知安全异常!");
		}
		
		
	}
	
	/**
	 * ------------------------以下是插入数据的操作-----------------------------------
	 * 
	 * @Description 根据实体类自动插入数据(使用idName和isInsertID为默认值)
	 * @param <T>
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public <T> int insert(T t) {
		return this.insert(t, TABLE_DIY_ID_NAME, true);
	}
	
	/**
	 * 
	 * @Description 根据实体类自动插入数据(使用isInsertID为默认值)
	 * @param <T>
	 * @param t
	 * @param idName 自定义主键
	 * @return
	 * @throws Exception
	 */
	public <T> int insert(T t, String idName) {
		return this.insert(t, idName, true);
	}
	
	/**
	 * 
	 * @Description 根据实体类自动插入数据(使用idName为默认值)
	 * @param <T>
	 * @param t
	 * @param bool 是否插入id属性
	 * @return
	 * @throws Exception
	 */
	public <T> int insert(T t, boolean bool) {
		return this.insert(t, TABLE_DIY_ID_NAME, bool);
	}
	
	/**
	 * 
	 * @param <T>
	 * @Description 根据实体类自动插入数据
	 * @param <T>
	 * @param t
	 * @param idName 主键名
	 * @param isInsertID 是否插入id属性
	 * @return
	 * @throws Exception
	 */
	public <T> int insert(T t, String idName, boolean isInsertID) {
		// 检查泛型中是否为null或者未定义属性
		this.checkClass(t);

			// 当用户输入的主键为null和空串时,调用默认主键
		if (idName == null || idName.length() == 0) {
			this.insert(t, isInsertID);
		}
		// 将SQL语句和参数放入执行
	
		return update(this.getInsertSql(t, idName, isInsertID), this.getParamsValues(t, idName, isInsertID).toArray());
		
	}
	
	/**
	 * 
	 * @Description 获取自动加工的查询SQL语句
	 * @param <T>
	 * @param t
	 * @return
	 */
	public <T> String getSelectSql(T t) {
		return "select * from " + t.getClass().toString()
				.substring(t.getClass().toString().lastIndexOf('.') + 1);
	}
	
	/**
	 * 
	 * @Description 查询所有
	 * @param <T>
	 * @param t
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(T t) {
		return (List<T>) this.query(getSelectSql(t), null, t.getClass());
	}
	
	/**
	 * 
	 * @Description 根据id查询
	 * @param <T>
	 * @param clazz
	 * @param id
	 * @return
	 */
	public <T> T findById(Class<T> clazz, int id) {
		List<T> list = null;
		try {
			list = (List<T>) this.query(this.getSelectSql(clazz.newInstance()) + " where id=?", new Object[] { id }, clazz);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return (list != null && list.size() > 0) ? list.get(0) : null;
	}
	
	/**
	 * 
	 * @Description 获取分页
	 * @param <T>
	 * @param clazz
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public <T> List<T> getPage(Class<T> clazz, int startIndex, int pageSize) {
		List<T> list = null;
		try {
			list = (List<T>) this.query(this.getSelectSql(clazz.newInstance()) + " limit ?,?", new Object[] { startIndex, pageSize }, clazz);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 
	 * @Description 获取删除SQL语句
	 * @param <T>
	 * @param t
	 * @return
	 */
	public <T> String getDeleteSql(T t) {
		return "delete from " + t.getClass().toString()
				.substring(t.getClass().toString().lastIndexOf('.') + 1) + " where id=?";
	}
	
	/**
	 * 
	 * @Description 删除
	 * @param <T>
	 * @param clazz
	 * @param id
	 * @return
	 */
	public <T> int delete(Class<T> clazz, int id) {
		int line = 0;
		try {
			line = this.update(this.getDeleteSql(clazz.newInstance()), new Object[] { id });
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return line;
	}
	
	/**
	 * 
	 * @Description 获取更新SQL语句
	 * @param <T>
	 * @param t
	 * @param idName
	 * @return
	 */
	public <T> String getUpdateSql(T t, String idName) {
		StringBuilder sqlPrefix = new StringBuilder("update ");
		StringBuilder sqlSuffix = new StringBuilder(" where ");
		sqlPrefix.append(t.getClass().toString()
				.substring(t.getClass().toString().lastIndexOf('.') + 1)).append(" set ");
		
		for (Iterator<Map<String, String>> iterator 
				= this.getAttributeInfo(t, idName, false).iterator(); iterator.hasNext();) {
			Map<String, String> map = (Map<String, String>) iterator.next();
			if (!idName.equals(map.get("name"))) {
				sqlPrefix.append(map.get("name")).append("=?,");
			} else {
				sqlSuffix.append(map.get("name")+"=?");
			}
		}
		sqlPrefix.deleteCharAt(sqlPrefix.lastIndexOf(","));
		return sqlPrefix.append(sqlSuffix).toString();
	}
	
	/**
	 * 
	 * @Description 更新
	 * @param <T>
	 * @param t
	 * @return
	 */
	public <T> int update(T t, String idName) {
		this.getParamsValues(t, idName, true).add(idName);
		return this.update(this.getUpdateSql(t, idName), this.getParamsValues(t, idName, true).toArray());
	}
	
	/**
	 * 
	 * @Description 采用默认主键
	 * @param <T>
	 * @param t
	 * @return
	 */
	public <T> int update(T t) {
		return this.update(t, TABLE_DIY_ID_NAME);
	}
}
