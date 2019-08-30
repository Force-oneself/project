package pers.quan.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import pers.quan.entity.User;
import pers.quan.utils.HibernateUtils;

/**
 * Hibernate的CURD操作
 * 
 * @author Administrator
 *
 */

public class HibernateDemo {

	/**
	 * 添加数据
	 */

	@Test
	public void add() {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			// 添加功能
			User user = new User();
			user.setName("李丽");
			user.setPassword("1314520");
			user.setAddress("中国");
			// 调用session的方法实现添加
			session.save(user);
			// 第六步 提交事务
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 第七步 关闭资源
			session.close();
			sessionFactory.close();
		}
	}

	/**
	 * 保存或者更新数据
	 */

	@Test
	public void saveOrUpdate() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();

			// User user = new User();
			// user.setUid(1);
			// user.setUsername("mary");
			// user.setPassword("250");
			// user.setAddress("越南");
			//
			// session.save(user);

			// 把uid=1的记录username修改
			// User user = new User();
			// user.setUid(1);
			// user.setUsername("tom");
			//
			// session.update(user);

			// 1 添加操作
			// User user = new User();
			// user.setUsername("jack");
			// user.setPassword("520");
			// user.setAddress("朝鲜");

			User user = new User();
			// user.setUid(6);
			user.setName("rose");
			user.setPassword("1314");
			user.setAddress("阿尔巴尼亚");
			//
			// User user = session.get(User.class, 7);
			// user.setUsername("lilei");
			//
			// //实体类对象状态是持久态，做修改
			session.saveOrUpdate(user);

			// 第六步 提交事务
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 第七步 关闭资源
			session.close();
			sessionFactory.close();
		}
	}

	/**
	 * 删除数据
	 */

	@Test
	public void delete() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();

			// 第一种 根据id查询对象
			User user = session.get(User.class, 2);

			// 第二种
			// User user = new User();
			// user.setUid(3);
			session.delete(user);

			// 第六步 提交事务
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 第七步 关闭资源
			session.close();
			sessionFactory.close();
		}
	}

	/**
	 * 更新数据
	 */

	@Test
	public void update() {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			// 4 修改操作
			// 修改uid=2记录username值
			// 4.1 根据id查询
			User user = session.get(User.class, 3);
			// 4.2 向返回的user对象里面设置修改之后的值
			user.setName("张三");
			// 4.3 调用session的方法update修改
			// 执行过程：到user对象里面找到uid值，根据uid进行修改
			session.update(user);
			// 第六步 提交事务
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 第七步 关闭资源
			session.close();
			sessionFactory.close();
		}
	}

	/**
	 * 获取数据
	 */

	@Test
	public void get() {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			// 根据id查询
			// 调用session里面的get方法
			// 第一个参数：实体类的class
			// 第二个参数：id值
			User user = session.get(User.class, 1);

			System.out.println(user.getName());
			// 第六步 提交事务
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 第七步 关闭资源
			session.close();
			sessionFactory.close();
		}
	}
}
