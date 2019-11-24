package pers.quan.service.impl;

import java.util.List;

import pers.quan.dao.UserDao;
import pers.quan.dao.impl.UserDaoImpl;
import pers.quan.model.Page;
import pers.quan.model.User;
import pers.quan.service.UserService;

/**
 *
 * @Discription 
 * @author John丶Woo
 * @date 2019年11月10日 下午5:30:14
 *
 */
public class UserServiceImpl implements UserService {

	public UserDao userdao = new UserDaoImpl();

	public User login(User user) {
		return userdao.login(user);
	}

	@Override
	public int update(User model) {
		return 0;
	}

	@Override
	public int delete(int id) {
		return 0;
	}

	@Override
	public int insert(User model) {
		return 0;
	}

	@Override
	public List<User> getAll() {
		return null;
	}

	@Override
	public User findById(Integer id) {
		return null;
	}

	@Override
	public List<User> getPage(Page<User> page) {
		return null;
	}
}
