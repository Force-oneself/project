package pers.quan.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import pers.quan.utils.HibernateUtils;

public class HibernateManyTable {

	/**
	 * 演示hql左连接查询
	 */
	
	@SuppressWarnings({ "unused", "rawtypes" })
	@Test
	public void testSelect12() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// 1 创建query对象
			Query query = session.createQuery("from Customer c left outer join fetch c.setLinkMan");

			List list = query.list();

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
	 *  演示hql内连接查询
	 */
	
	@SuppressWarnings({ "unused", "rawtypes" })
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
			Query query = session.createQuery("from Customer c inner join c.setLinkMan");

			List list = query.list();

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
