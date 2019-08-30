package pers.quan.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import pers.quan.entity.User;
import pers.quan.utils.HibernateUtils;

/**
 * Hibernate查询数据的几种方法
 * 
 * @author Administrator
 *
 */
public class HibernateQueryData {

	/**
	 * 使用SQLQuery对象
	 */

	@SuppressWarnings("unchecked")
	@Test
	public void testSQLQuery() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			// 开启事务
			tx = session.beginTransaction();

			// 1 创建对象
			// 参数普通sql语句
			SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");

			// 返回的list中每部分是对象形式
			sqlQuery.addEntity(User.class);

			// 调用sqlQuery里面的方法
			List<User> list = sqlQuery.list();

			for (User user : list) {
				System.out.println(user.getName());
			}

			// 调用sqlQuery里面的方法
			// 返回list集合，默认里面每部分数组结构
			// List<Object[]> list = sqlQuery.list();
			// for (Object[] objects : list) {
			// System.out.println(Arrays.toString(objects));
			// }

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
	 * 使用criteria对象
	 */

	@SuppressWarnings("unchecked")
	@Test
	public void testCriteria() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			// 开启事务
			tx = session.beginTransaction();

			// 1 创建criteria对象
			// 方法里面参数是实体类class
			Criteria criteria = session.createCriteria(User.class);
			// 2 调用方法得到结果
			List<User> list = criteria.list();

			for (User user : list) {
				System.out.println(user.getName());
			}
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
	 * 使用query对象
	 */

	@SuppressWarnings("unchecked")
	@Test
	public void testQuery() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			// 开启事务
			tx = session.beginTransaction();

			// 1 创建Query对象
			// 方法里面写hql语句
			Query query = session.createQuery("from User");

			// 2 调用query对象里面的方法得到结果
			List<User> list = query.list();

			// 遍历list集合四种： 普通for、增强for、迭代器、list迭代器
			// 遍历set集合两种：增强for、迭代器
			// 遍历map集合两种：得到所有key，根据key得到value； 得到key-value关系
			for (User user : list) {
				System.out.println(user.getName());
			}

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
