package pers.quan.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import pers.quan.entity.Customer;
import pers.quan.utils.HibernateUtils;

/**
 *  QBC演示
 * @author Administrator
 *
 */
public class HibernateQBC {
	/**
	 *  演示离线查询
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

			// 1 创建对象
			// Criteria criteria = session.createCriteria(Customer.class);
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);

			// 2 最终执行时候才需要到session
			Criteria criteria = detachedCriteria.getExecutableCriteria(session);

			List<Customer> list = criteria.list();

			for (Customer customer : list) {
				System.out.println(customer.getCid() + "::" + customer.getCustName());
			}

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
	 *  演示统计查询
	 */
	
	@Test
	public void testSelect5() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// 1 创建对象
			Criteria criteria = session.createCriteria(Customer.class);

			// 2 设置操作
			criteria.setProjection(Projections.rowCount());

			// 3 调用方法得到结果
			Object obj = criteria.uniqueResult();

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
	 *  演示分页查询
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

			// 1 创建对象
			Criteria criteria = session.createCriteria(Customer.class);

			// 2 设置分页数据
			// 2.1 设置开始位置
			criteria.setFirstResult(0);
			// 2.2 每页显示记录数
			criteria.setMaxResults(3);

			// 3 调用方法得到结果
			List<Customer> list = criteria.list();

			for (Customer customer : list) {
				System.out.println(customer.getCid() + "::" + customer.getCustName());
			}
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
	 *  演示排序查询
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

			// 1 创建对象
			Criteria criteria = session.createCriteria(Customer.class);

			// 2 设置对哪个属性进行排序，设置排序规则
			criteria.addOrder(Order.desc("cid"));

			// 3 调用方法得到结果
			List<Customer> list = criteria.list();

			for (Customer customer : list) {
				System.out.println(customer.getCid() + "::" + customer.getCustName());
			}
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

			// 1 创建对象
			Criteria criteria = session.createCriteria(Customer.class);

			// 2 使用Criteria对象里面的方法设置条件值
			// 首先使用add方法，表示设置条件值
			// 在add方法里面使用类的方法实现条件设置
			// 类似于 cid=?
			// criteria.add(Restrictions.eq("cid", 1));
			// criteria.add(Restrictions.eq("custName", "百度"));

			criteria.add(Restrictions.like("custName", "%百%"));

			// 3 调用方法得到结果
			List<Customer> list = criteria.list();

			for (Customer customer : list) {
				System.out.println(customer.getCid() + "::" + customer.getCustName());
			}
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

			// 1 创建对象
			Criteria criteria = session.createCriteria(Customer.class);
			// 2 调用方法得到结果
			List<Customer> list = criteria.list();

			for (Customer customer : list) {
				System.out.println(customer.getCid() + "::" + customer.getCustName());
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
