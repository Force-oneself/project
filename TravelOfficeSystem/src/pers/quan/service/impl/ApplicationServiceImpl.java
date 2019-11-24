package pers.quan.service.impl;

import java.util.List;

import pers.quan.dao.ApplicationDao;
import pers.quan.dao.impl.ApplicationDaoImpl;
import pers.quan.model.Application;
import pers.quan.model.Page;
import pers.quan.service.ApplicationService;

/**
 *
 * @Discription 
 * @author John丶Woo
 * @date 2019年11月23日 下午11:21:14
 *
 */
public class ApplicationServiceImpl implements ApplicationService {

	private ApplicationDao applicationDao = new ApplicationDaoImpl();

	@Override
	public int update(Application t) {
		return applicationDao.update(t);
	}

	@Override
	public int delete(int id) {
		return applicationDao.delete(id);
	}

	@Override
	public int insert(Application t) {
		return applicationDao.insert(t);
	}

	@Override
	public List<Application> getAll() {
		return applicationDao.getAll();
	}

	@Override
	public Application findById(Integer id) {
		return applicationDao.findById(id);
	}

	@Override
	public List<Application> getPage(Page<Application> page) {
		return applicationDao.getPage(page);
	}

}
