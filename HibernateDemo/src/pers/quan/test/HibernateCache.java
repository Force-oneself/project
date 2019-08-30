package pers.quan.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import pers.quan.entity.User;
import pers.quan.utils.HibernateUtils;

/**
 * Hibernate的一级缓存
 * 
 * @author Administrator
 *
 */
public class HibernateCache {

	/**
	 * 一级缓存特性
	 */
	@Test
	public void cachePeculiarity() {
		Session session = null;
		Transaction tx = null;
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			// 与本地线程绑定的session
			session = HibernateUtils.getSessionObject();
			// 开启事务
			tx = session.beginTransaction();

			// 1 根据id查询
			User user = session.get(User.class, 1);

			// 2 设置返回对象值
			user.setName("hanmeimei");

			// 3 调用方法实现
			session.update(user);
			// 提交事务
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// 回滚事务
			tx.rollback();
		} finally {
			// 关闭操作
			session.close();
			sessionFactory.close();
		}
	}

	/**
	 * 验证一级缓存存在
	 */

	@Test
	public void verifyCache() {

		Session session = null;
		Transaction tx = null;
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			// 与本地线程绑定的session
			session = HibernateUtils.getSessionObject();
			// 开启事务
			tx = session.beginTransaction();

			// 1 根据uid=6查询
			// 执行第一个get方法是否查询数据库，是否发送sql语句
			User user1 = session.get(User.class, 1);
			System.out.println(user1.getName());

			// 2 在 根据uid=6查询
			// 执行第二个get方法是否查询数据库，是否发送sql语句
			User user2 = session.get(User.class, 1);
			System.out.println(user2.getName());

			// 3 调用方法实现
			// session.update(user);
			// 提交事务
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// 回滚事务
			tx.rollback();
		} finally {
			// 关闭操作
			session.close();
			sessionFactory.close();
		}
	}

}
