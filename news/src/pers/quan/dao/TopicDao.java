package pers.quan.dao;

import java.util.List;

import pers.quan.entity.Page;
import pers.quan.entity.Topic;

/**
 * @Description 新闻主题dao
 * @author 何永泉
 * @param <T>
 * @date 2019年8月20日 下午4:54:15
 *
 */
public interface TopicDao extends BaseDao<Topic>{

	List<Topic> getPage(Page<Topic> page);
	
	int getRows();
	
}
