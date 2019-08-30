package pers.quan.dao.impl;

import java.util.List;

import pers.quan.dao.BaseDao;
import pers.quan.dao.DemoDao;
import pers.quan.model.Demo;

/**
 * 
 * @Description 演示dao层实现类
 * @author 何永泉
 * @param <T>
 * @date 2019年8月12日 下午4:23:18
 *
 */
public class DemoDaoImpl extends BaseDao implements DemoDao<Demo> {

	public int update(Demo demo) {
		String sql = "update demo set name=?,password=? where id=?";
		Object[] paramsValue = { demo.getName(), demo.getPassword(), demo.getId() };
		return super.update(sql, paramsValue);
	}

	public int delete(int id) {
		String sql = "delete from demo where id=?";
		Object[] paramsValue = { id };
		return super.update(sql, paramsValue);
	}

	public int insert(Demo demo) {
		String sql = "insert into demo (name,password) values (?,?)";
		Object[] paramsValue = { demo.getName(), demo.getPassword() };
		return super.update(sql, paramsValue);
	}

	public List<Demo> getAll() {
		String sql = "select * from demo";
		return super.query(sql, null, Demo.class);
	}

	public Demo findById(int id) {
		String sql = "select * from demo where id=?";
		List<Demo> list = super.query(sql, new Object[] { id }, Demo.class);
		return (list != null && list.size() > 0) ? list.get(0) : null;
	}

	public List<Demo> getPage(int startIndex, int pageSize) {
		String sql = "select * from demo limit ?,?";
		return super.query(sql, new Object[] { startIndex, pageSize }, Demo.class);
	}

}
