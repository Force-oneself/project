package pers.quan.service.impl;

import java.util.List;

import pers.quan.dao.TopicDao;
import pers.quan.dao.impl.TopicDaoImpl;
import pers.quan.entity.Page;
import pers.quan.entity.Topic;
import pers.quan.service.TopicService;

/**
 * @Description 新闻主题service接口实现类
 * @author 何永泉
 * @date 2019年8月20日 下午4:51:04
 *
 */
public class TopicServiceImpl implements TopicService {
	
	private TopicDao topicDao = new TopicDaoImpl();

	@Override
	public List<Topic> findAll() {
		return topicDao.findAll();
	}
	
	@Override
	public List<Topic> getPage(Page<Topic> page) {
		return topicDao.getPage(page);
	}

	@Override
	public int getRows() {
		return topicDao.getRows();
	}

	@Override
	public int delete(int id) {
		return topicDao.delete(id);
	}

}
