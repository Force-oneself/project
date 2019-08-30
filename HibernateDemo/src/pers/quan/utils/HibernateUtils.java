package pers.quan.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate的加载核心文件的初始化工具包
 * 
 * @author Administrator
 *
 */
public class HibernateUtils {

	static Configuration cfg = null;
	static SessionFactory sessionFactory = null;

	// 静态代码块实现
	static {
		// 加载核心配置文件
		cfg = new Configuration();
		cfg.configure();
		sessionFactory = cfg.buildSessionFactory();
	}

	// 提供返回与本地线程帮的SessionFactory的方法
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	// 提供方法返回session
	public static Session getSessionObject() {
		return sessionFactory.openSession();
	}

	// 提供方法getCurrentSession获取Session
	public static Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) {

	}
}
