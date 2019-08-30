package pers.quan.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import pers.quan.uitls.DBUtils;

/**
 *
 * @Description: 通用的dao
 * @author: 何永泉
 * @date:   2019年7月29日 下午7:30:18
 *
 */
public class BaseDao {

	// 初始化参数
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	/**
	 * -----------------------以下对dao层封装的通用操作方法---------------------
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
			conn.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DBUtils.closeAll(conn, ps, null);
		}
		return line;
	}
	
	/**
	 * -------------------以下对实体类的属性名称、属性值、属性类型获取操作----------------
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
	 * @param <T>
	 * @Description 根据属性名获取属性值 
	 * @param fieldName
	 * @param o
	 * @return
	 */
	public <T> Object getFieldValueByName(String fieldName, T t) {
		Object value = null;
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = t.getClass().getMethod(getter, new Class[] {});
			value = method.invoke(t, new Object[] {});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * 
	 * @Description 获取对象的所有属性值，返回一个object集合
	 * @param <T>
	 * @param t
	 * @return
	 */
	public <T> List<Object> getFiledValues(T t) {
		List<Object> valueList = new ArrayList<Object>();
		for (String s : getAttributeNames(t)) {
			valueList.add(getFieldValueByName(s, t));
		}
		return valueList;
	}

	/**
	 * 
	 * @Description 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list 
	 * @param <T>
	 * @param t
	 * @return
	 */
	public <T> List<Map<String, String>> getAttributeInfo(T t) {
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> infoMap = null;
		for (Field field : t.getClass().getDeclaredFields()) {
			infoMap = new HashMap<>();
			infoMap.put("type", field.getType().toString());
			infoMap.put("name", field.getName());
			infoMap.put("value", getFieldValueByName(field.getName(), t).toString());
			list.add(infoMap);
		}
		return list;
	}
}
