package pers.quan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import pers.quan.dao.UserDao;
import pers.quan.entity.User;
import pers.quan.utils.DBUtils;

/**
 * @Description UserDao接口的实现类
 * @author 何永泉
 * @date 2019年8月23日 上午10:04:54
 *
 */
public class UserDaoImpl implements UserDao<User> {

	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User login(User t) {
		conn = DBUtils.getConnection();
		String sql = "select * from user where userName=? and password=?";
		User user = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, t.getUserName());
			ps.setString(2, t.getPassword());
			rs = ps.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setUserName(rs.getString(1));
				user.setPassword(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(conn, ps, rs);
		}
		return user;
	}

}
