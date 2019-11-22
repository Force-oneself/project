package pers.quan.service.impl;

import pers.quan.dao.UserDao;
import pers.quan.dao.impl.UserDaoImpl;
import pers.quan.entity.User;
import pers.quan.service.UserService;

/**
 * @Description 
 * @author 何永泉
 * @date 2019年8月23日 上午10:13:45
 *
 */
public class UserServiceImpl implements UserService{

	private UserDao<User> userDao = new UserDaoImpl();
	
	public User login(User user) {
		return userDao.login(user);
	}

}
