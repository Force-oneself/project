package cn.itcast.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	//添加客户功能
//	public void add(Customer customer) {
//		this.getHibernateTemplate().save(customer);
//	}

	//客户列表功能
//	@SuppressWarnings("all")
//	public List<Customer> findAll() {
//		return (List<Customer>) this.getHibernateTemplate().find("from Customer");
//	}

	//根据id查询
//	public Customer findOne(int cid) {
//		return this.getHibernateTemplate().get(Customer.class, cid);
//	}

	//删除功能
//	public void delete(Customer c) {
//		this.getHibernateTemplate().delete(c);
//	}

	//修改功能
//	public void update(Customer customer) {
//		this.getHibernateTemplate().update(customer);
//	}

	//查询记录数
	@SuppressWarnings("all")
	public int findCount() {
		//调用hibernateTemplate里面的find方法实现
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Customer");
		//从list中把值得到
		if(list != null && list.size()!=0) {
			Object obj = list.get(0);
			//变成int类型
			Long lobj = (Long) obj;
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

	//分页查询操作
	public List<Customer> findPage(int begin, int pageSize) {
		//第一种 使用hibernate底层代码实现（了解）
		//得到sessionFactory
//		SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
		//得到session对象
//		Session session = sessionFactory.getCurrentSession();
		//设置分页信息
//		Query query = session.createQuery("from Customer");
//		query.setFirstResult(begin);
//		query.setMaxResults(pageSize);
//		List<Customer> list = query.list();
		
		//第二种 使用离线对象和hibernateTemplate的方法实现
		//1 创建离线对象，设置对哪个实体类进行操作
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		
//		criteria.setProjection(Projections.rowCount());
		
		//调用hibernateTemplate的方法实现
//		第一个参数是离线对象
//		第二个参数是开始位置
//		第三个参数是每页记录数
		List<Customer> list = 
				(List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	//条件查询
	@SuppressWarnings("all")
	public List<Customer> findCondition(Customer customer) {
		//第一种方式： 
//		SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
		//得到session对象
//		Session session = sessionFactory.getCurrentSession();
//		Query query = session.createQuery("from Customer where custName like ?");
//		query.setParameter(0, "%"+customer.getCustName()+"%");
//		List<Customer> list = query.list();
		
		//第二种方式 ： 调用hibernateTemplate的find方法实现
//		List<Customer> list = (List<Customer>) this.getHibernateTemplate().
//			find("from Customer where custName like ?", "%"+customer.getCustName()+"%");
		//拼接hql语句实现
		
		
		//第三种方式
		// 1 创建离线对象，设置对哪个实体类进行操作
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		// 2 设置对实体类哪个属性
		criteria.add(Restrictions.like("custName", "%"+customer.getCustName()+"%"));
		
		// 3 调用hibernateTemplate里面的方法得到list集合
		List<Customer> list = 
				(List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

	//多条件组合查询
//	@SuppressWarnings("all")
//	public List<Customer> findMoreCondition(Customer customer) {
//		//使用hibernate模板里面find方法实现
//		//拼接hql语句
//		String hql = "from Customer where 1=1 ";
//		//创建list集合，如果值不为空，把值设置到list里面
//		List<Object> p = new ArrayList<Object>();
//		//判断条件值是否为空，如果不为空拼接hql语句
//		if(customer.getCustName()!=null && !"".equals(customer.getCustName())) {
//			//拼接hql
//			hql += " and custName=?";
//			//把值设置到list里面
//			p.add(customer.getCustName());
//		}
//		if(customer.getCustLevel()!=null && !"".equals(customer.getCustLevel())) {
//			hql += " and custLevel=?";
//			p.add(customer.getCustLevel());
//		}
//		if(customer.getCustSource()!=null && !"".equals(customer.getCustSource())) {
//			hql += " and custSource=?";
//			p.add(customer.getCustSource());
//		}
////		System.out.println("hql: "+hql);
////		System.out.println("list: "+p);
//		return (List<Customer>) this.getHibernateTemplate().find(hql, p.toArray());
//	}

	//使用离线对象方式实现多条件组合查询
	@SuppressWarnings("all")
	public List<Customer> findMoreCondition(Customer customer) {
		
		//创建离线对象，指定对哪个实体类进行操作
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//判断条件值是否为空
		if(customer.getCustName()!=null && !"".equals(customer.getCustName())) {
			//设置对属性，设置值
			criteria.add(Restrictions.eq("custName", customer.getCustName()));
		}
//		if(customer.getCustLevel()!=null && !"".equals(customer.getCustLevel())) {
//			criteria.add(Restrictions.eq("custLevel", customer.getCustLevel()));
//		}
		if(customer.getCustSource()!=null && !"".equals(customer.getCustSource())) {
			criteria.add(Restrictions.eq("custSource", customer.getCustSource()));
		}
		
		return (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
	}

	//查询所有级别
	@SuppressWarnings("all")
	public List<Dict> findAllDictLevel() {
		
		return (List<Dict>) this.getHibernateTemplate().find("from Dict");
	}

	//客户来源统计
	public List findCountSource() {
		// 因为写复杂语句，建议直接调用底层sql实现
		// SQLQuery对象
		//1 得到session对象
//		this.getHibernateTemplate().getSessionFactory();
		Session session = this.getSessionFactory().getCurrentSession();
		//2 创建SQLQuery对象
		SQLQuery sqlQuery = session.createSQLQuery("SELECT COUNT(*) AS num,custSource FROM t_customer GROUP BY custSource");
		
		//放到实体类对象里面，没有对应的实体类
//		sqlQuery.addEntity(实体类class);
		
		/*
		 * 因为返回值有两个字段，一个字段是id，一个是名称，
		 * 所以把返回数据转换map结构
		 * */
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		
		//调用方法得到结果
		//返回list，默认每部分是数组形式
		List list = sqlQuery.list();
		
		return list;
	}

	//根据客户级别统计
	public List findCountLevel() {
		//获取session对象
		Session session = this.getSessionFactory().getCurrentSession();
		//创建SQLQuery对象
		SQLQuery sqlQuery = session.createSQLQuery("SELECT c.num,d.dname FROM (SELECT COUNT(*) AS num,custLevel FROM t_customer GROUP BY custLevel) c , t_dict d WHERE c.custLevel=d.did");
		//得到结果
		//转换map结构
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		List list = sqlQuery.list();
		return list;
	}
}









