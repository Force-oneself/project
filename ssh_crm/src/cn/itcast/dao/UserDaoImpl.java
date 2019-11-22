package cn.itcast.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

//	private HibernateTemplate hibernateTemplate;
//	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
//		this.hibernateTemplate = hibernateTemplate;
//	}
	
	//登录的方法
	@SuppressWarnings("all")
	public User loginUser(User user) {
		//调用方法得到hibernateTemplate对象
//		HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
		//登录的查询操作
		//根据用户名和密码查询
		List<User> list = (List<User>) this.getHibernateTemplate().
				find("from User where username=? and password=?", user.getUsername(),user.getPassword());
		//返回user对象
		//如果查询之后，没有结果 ，list里面没有值，根据get(下标)获取不到值，出现下标越界异常
		//判断
		if(list != null && list.size()!=0) {
			User u = list.get(0);
			return u;
		}
		return null;
	}

	//查询所有用户
	public List<User> findAll() {
		return (List<User>) this.getHibernateTemplate().find("from User");
	}


	
}
