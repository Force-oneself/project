package pers.quan.service;

import java.util.List;

import pers.quan.model.Demo;


/**
 * 
 * @Description service层Demo接口
 * @author 何永泉
 * @date 2019年8月12日 下午8:18:59
 *
 */
public interface DemoService {

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void delete(int id);

	/**
	 * 插入
	 * 
	 * @param demo
	 */
	void insert(Demo demo);

	/**
	 * 查新所有
	 * 
	 * @return
	 */
	List<Demo> getAll();

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	Demo findById(int id);
	
	/**
	 * 分页查询
	 * @Description 
	 * @return
	 */
	List<Demo> getPage(int startIndex, int pageSize);
	
	/**
	 * 
	 * @Description 更新
	 * @param demo
	 * @return
	 */
	int update(Demo demo);
}
