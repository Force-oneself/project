package pers.quan.dao.impl;

import java.util.List;

import pers.quan.dao.BaseDao;
import pers.quan.dao.UserDao;
import pers.quan.model.Page;
import pers.quan.model.User;

/**
 *
 * @Discription 
 * @author John丶Woo
 * @date 2019年11月23日 下午7:22:06
 *
 */
public class UserDaoImpl implements UserDao {

	@Override
	public int update(User t) {
		return 0;
	}

	@Override
	public int delete(int id) {
		return 0;
	}

	@Override
	public int insert(User t) {
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
		String sql = "select * from user limit ?,?";
		return BaseDao.query(sql, new Object[] { page.getStartIndex(), page.getPageSize() }, User.class);
	}

	public User login(User user) {
		String sql = "select * from user where name=? and password=?";
		Object[] paramsValue = { user.getName(), user.getPassword() };
		List<User> list = BaseDao.query(sql, paramsValue, User.class);
		return (list != null && list.size() > 0) ? list.get(0) : null;
	}

}
