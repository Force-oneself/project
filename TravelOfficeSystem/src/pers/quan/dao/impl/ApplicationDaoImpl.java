package pers.quan.dao.impl;

import java.util.List;

import pers.quan.dao.ApplicationDao;
import pers.quan.dao.BaseDao;
import pers.quan.model.Application;
import pers.quan.model.Page;

/**
 *
 * @Discription 申请表dao实现类
 * @author John丶Woo
 * @date 2019年11月23日 下午11:15:39
 *
 */
public class ApplicationDaoImpl implements ApplicationDao {

	@Override
	public int update(Application t) {
		return 0;
	}

	@Override
	public int delete(int id) {
		return 0;
	}

	@Override
	public int insert(Application t) {
		return 0;
	}

	@Override
	public List<Application> getAll() {
		return null;
	}

	@Override
	public Application findById(Integer id) {
		return null;
	}

	@Override
	public List<Application> getPage(Page<Application> page) {
		String sql = "select * from application limit ?,?";
		return BaseDao.query(sql, new Object[] { page.getStartIndex(), page.getPageSize() }, Application.class);
	}

}
