package pers.quan.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import pers.quan.manytomany.User;
import pers.quan.manytomany.Role;
import pers.quan.utils.HibernateUtils;

/**
 * Hibernate维护多对多关系建立的第三张表
 * 
 * @author Administrator
 *
 */
public class HibernateManyToMany {

	/**
	 *  使表失去另一张表中的联系
	 */
	
	@Test
	public void loseRelation() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// 让某个用户没有有某个角色
			User user = session.get(User.class, 2);
			Role role = session.get(Role.class, 3);
			//2 从用户里面把角色去掉
			user.getSetRole().remove(role);
			
			tx.commit();

		}catch(Exception e) {
			tx.rollback();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	/**
	 * 	使表拥有另一张表的联系
	 */
	
	@Test
	public void getRelation() {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			//�õ�sessionFactory
			sessionFactory = HibernateUtils.getSessionFactory();
			//�õ�session
			session = sessionFactory.openSession();
			//��������
			tx = session.beginTransaction();
			
			// 让某个用户有某个角色
			// 让lucy有经纪人角色
			// 1 查询lucy和经纪人
			User lucy = session.get(User.class, 1);
			Role role = session.get(Role.class, 1);
			
			//2 把角色放到用户的set集合里面
			lucy.getSetRole().add(role);
			
			tx.commit();

		}catch(Exception e) {
			tx.rollback();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	/**
	 * 演示多对多修级联保存
	 */
	
	@Test
	public void testDelete() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			User user = session.get(User.class, 1);
			session.delete(user);
			tx.commit();

		}catch(Exception e) {
			tx.rollback();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	/**
	 *  演示多对多修级联保存
	 */
	
	@Test
	public void testSave() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			//添加两个用户，为每个用户添加两个角色
			//1 创建对象
			User user1 = new User();
			user1.setUser_name("lucy");
			user1.setUser_password("123");
			
			User user2 = new User();
			user2.setUser_name("mary");
			user2.setUser_password("456");
			
			Role r1 = new Role();
			r1.setRole_name("总经理");
			r1.setRole_memo("总经理");
			
			Role r2 = new Role();
			r2.setRole_name("秘书");
			r2.setRole_memo("秘书");
			
			Role r3 = new Role();
			r3.setRole_name("保安");
			r3.setRole_memo("保安");
			
			//2 建立关系，把角色放到用户里面
			// user1 -- r1/r2
			user1.getSetRole().add(r1);
			user1.getSetRole().add(r2);
			
			// user2 -- r2/r3
			user2.getSetRole().add(r2);
			user2.getSetRole().add(r3);
			
			//3 保存用户
			session.save(user1);
			session.save(user2);
			
			tx.commit();

		}catch(Exception e) {
			tx.rollback();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
}
