package cn.itcast.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class pClass;
	//构造方法
	public BaseDaoImpl() {
		//第一步 得到当前运行类Class
		Class clazz = this.getClass();
//		System.out.println("****************"+clazz);
		
		//第二步 得到运行类的 父类的参数化类型 BaseDaoImpl<Customer>
		// Type getGenericSuperclass()  
		Type type = clazz.getGenericSuperclass();
		// 使用Type子接口 ParameterizedType
		ParameterizedType ptype = (ParameterizedType) type;
//		System.out.println("***********"+ptype);
		
		//第三步 得到实际类型参数<Customer>里面Customer
		//Type[] getActualTypeArguments() 
		Type[] types = ptype.getActualTypeArguments();
		//Type接口实现类Class
		Class tclass = (Class) types[0];
//		System.out.println("*****"+pclass);
		this.pClass = tclass;
	}
	
	//根据id查询
	@SuppressWarnings("all")
	public T findOne(int id) {
		//不能写 T.class
		return (T) this.getHibernateTemplate().get(pClass, id);
	}

	//查询所有
	@SuppressWarnings("all")
	public List<T> findAll() {
		//使用Class里面getSimpleName() 得到类名称
		return (List<T>) this.getHibernateTemplate().find("from "+pClass.getSimpleName());
	}
	
	//添加
	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}
	
	//修改
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	//删除
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

}
