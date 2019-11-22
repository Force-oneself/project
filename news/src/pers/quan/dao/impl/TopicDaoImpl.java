package pers.quan.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pers.quan.dao.TopicDao;
import pers.quan.entity.Page;
import pers.quan.entity.Topic;
import pers.quan.utils.DBUtils;

/**
 * @Description 新闻主题dao接口实现类
 * @author 何永泉
 * @date 2019年8月20日 下午4:54:50
 *
 */
public class TopicDaoImpl implements TopicDao {

	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	@Override
	public List<Topic> findAll() {
		conn = DBUtils.getConnection();
		String sql = "select * from topic";
		List<Topic> list = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list = new ArrayList<Topic>();
			while(rs.next()) {
				Topic topic = new Topic();
				topic.setId(rs.getInt(1));
				topic.setTopicName(rs.getString(2));
				topic.setCreateDate(rs.getDate(3));
				topic.setFlag(rs.getBoolean(4));
				list.add(topic);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(conn, ps, rs);
		}
		return list;
	}

	@Override
	public int add(Topic t) {
		conn = DBUtils.getConnection();
		String sql = "insert into topic (topicName,createDate,flag) values (?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, t.getTopicName());
			ps.setDate(2, new Date(t.getCreateDate().getTime()));
			ps.setBoolean(3, t.isFlag());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			DBUtils.closeAll(conn, ps, null);
		}
	}

	@Override
	public int update(Topic t) {
		conn = DBUtils.getConnection();
		String sql = "update topic set topicName=?,createDate=?,flag=? where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, t.getTopicName());
			ps.setDate(2, new Date(t.getCreateDate().getTime()));
			ps.setBoolean(3, t.isFlag());
			ps.setInt(4, t.getId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			DBUtils.closeAll(conn, ps, null);
		}
	}

	@Override
	public int delete(Integer id) {
		conn = DBUtils.getConnection();
		String sql = "delete from topic where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public List<Topic> getPage(Page<Topic> page) {
		conn = DBUtils.getConnection();
		String sql = "select * from topic limit ?,?";
		List<Topic> list = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, page.getStartIndex());
			ps.setInt(2, page.getPageSize());
			rs = ps.executeQuery();
			list = new ArrayList<Topic>();
			while(rs.next()) {
				Topic topic = new Topic();
				topic.setId(rs.getInt(1));
				topic.setTopicName(rs.getString(2));
				topic.setCreateDate(rs.getDate(3));
				topic.setFlag(rs.getBoolean(4));
				list.add(topic);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(conn, ps, rs);
		}
		return list;
	}

	@Override
	public int getRows() {
		conn = DBUtils.getConnection();
		String sql = "select count(1) from topic";
		int rows = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				rows = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}

}
