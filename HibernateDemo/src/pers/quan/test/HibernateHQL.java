package pers.quan.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import pers.quan.entity.Customer;
import pers.quan.utils.HibernateUtils;

/**
 * HQL演示
 * 
 * @author Administrator
 *
 */
public class HibernateHQL {
	
	/**
	 *  演示聚集函数使用
	 */
	
	@Test
	public void testSelect7() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// 1 创建query对象
			Query query = session.createQuery("select count(*) from Customer");

			// 2 调用方法得到结果
			// query对象里面有方法，直接返回对象形式
			Object obj = query.uniqueResult();

			// 返回int类型
			// int count = (int) obj;

			// 首先把object变成long类型，再变成int类型
			Long lobj = (Long) obj;
			int count = lobj.intValue();
			System.out.println(count);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	/**
	 *  演示投影查询
	 */
	
	@SuppressWarnings("unchecked")
	@Test
	public void testSelect6() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// 1 创建query对象
			Query query = session.createQuery("select custName from Customer");

			// 2 调用方法得到结果
			List<Object> list = query.list();

			for (Object object : list) {
				System.out.println(object);
			}

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	/**
	 *  演示分页查询
	 */
	
	@SuppressWarnings("unchecked")
	@Test
	public void testSelect5() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// 1 创建query对象
			// 写查询所有的语句
			Query query = session.createQuery("from Customer");

			// 2 设置分页数据
			// 2.1 设置开始位置
			query.setFirstResult(0);
			// 2.2 设置每页记录数
			query.setMaxResults(3);

			// 3 调用方法得到结果
			List<Customer> list = query.list();

			for (Customer customer : list) {
				System.out.println(customer.getCid() + "::" + customer.getCustName());
			}

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	/**
	 *  演示排序查询
	 */
	
	@SuppressWarnings("unchecked")
	@Test
	public void testSelect4() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// 1 创建query对象
			Query query = session.createQuery("from Customer order by cid desc");

			// 2 调用方法得到结果
			List<Customer> list = query.list();

			for (Customer customer : list) {
				System.out.println(customer.getCid() + "::" + customer.getCustName());
			}

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	/**
	 *  演示条件查询-模糊查询
	 */
	
	@SuppressWarnings("unchecked")
	@Test
	public void testSelect3() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// 1 创建query对象
			Query query = session.createQuery("from Customer c where c.custName like ?");

			// 2 设置？的值
			// %浪%
			query.setParameter(0, "%浪%");

			// 3 调用方法得到结果
			List<Customer> list = query.list();

			for (Customer customer : list) {
				System.out.println(customer.getCid() + "::" + customer.getCustName());
			}

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	/**
	 *  演示条件查询
	 */
	
	@SuppressWarnings("unchecked")
	@Test
	public void testSelect2() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// 1 创建query对象
			// SELECT * FROM t_customer WHERE cid=? AND custName=?
			Query query = session.createQuery("from Customer c where c.cid=? and c.custName=?");

			// 2 设置条件值
			// 向？里面设置值
			// setParameter方法两个参数
			// 第一个参数：int类型是？位置，？位置从0开始
			// 第二个参数：具体参数值
			// 设置第一个？值
			query.setParameter(0, 1);
			// 设置第二个？值
			query.setParameter(1, "百度");

			// 3 调用方法得到结果
			List<Customer> list = query.list();

			for (Customer customer : list) {
				System.out.println(customer.getCid() + "::" + customer.getCustName());
			}

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	/**
	 *  演示查询所有
	 */
	
	@SuppressWarnings("unchecked")
	@Test
	public void testSelect1() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// 1 创建query对象
			Query query = session.createQuery("from Customer");
			// 2 调用方法得到结果
			List<Customer> list = query.list();

			for (Customer customer : list) {
				System.out.println(customer.getCid() + "::" + customer.getCustName());
			}

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
