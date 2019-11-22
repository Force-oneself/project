package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.User;

public interface UserDao {

	User loginUser(User user);

	List<User> findAll();

}
