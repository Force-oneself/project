package pers.quan.dao;

import java.util.List;

/**
 * @Description 
 * @author 何永泉
 * @date 2019年8月20日 下午5:00:04
 *
 */
public interface BaseDao<T> {
	
	List<T> findAll();
	
//	List<T> getPage();
	
	int add(T t);
	
	int update(T t);
	
	int delete(Integer t);
}
