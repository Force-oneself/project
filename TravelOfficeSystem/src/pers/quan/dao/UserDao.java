package pers.quan.dao;

import pers.quan.model.User;

/**
 *
 * @Discription user dao
 * @author John丶Woo
 * @date 2019年11月10日 下午4:47:14
 *
 */
public interface UserDao extends Dao<User> {

	User login(User user);
}
