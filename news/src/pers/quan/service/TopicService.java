package pers.quan.service;

import java.util.List;

import pers.quan.entity.Page;
import pers.quan.entity.Topic;

/**
 * @Description 新闻主题service接口
 * @author 何永泉
 * @date 2019年8月20日 下午4:50:40
 *
 */
public interface TopicService {

	List<Topic> findAll();
	
	List<Topic> getPage(Page<Topic> page);
	
	int getRows();
	
	int delete(int id);
}
