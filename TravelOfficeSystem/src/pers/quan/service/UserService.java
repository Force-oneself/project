package pers.quan.service;

import pers.quan.model.User;

/**
 *
 * @Discription 
 * @author John丶Woo
 * @date 2019年11月10日 下午5:29:57
 *
 */
public interface UserService extends Service<User> {

	User login(User user);
}
