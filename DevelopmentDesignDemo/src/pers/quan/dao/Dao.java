package pers.quan.dao;

import java.util.List;

/**
 * @Description 通用model的dao层接口
 * @author 何永泉
 * @param <T>
 * @date 2019年8月12日 下午8:29:47
 *
 */
public interface Dao<T> {

	/**
	 * 
	 * @Description 更新
	 * @param t
	 * @return
	 */
	int update(T t);
	
	/**
	 * 
	 * @Description 删除
	 * @param id
	 * @return
	 */
	int delete(int id);

	/**
	 * 
	 * @Description 插入
	 * @param t
	 * @return
	 */
	int insert(T t);

	/**
	 * 
	 * @Description 查询所有
	 * @param <T>
	 * @return
	 */
	List<T> getAll();

	/**
	 * 
	 * @Description 根据ID查询
	 * @param <T>
	 * @param id
	 * @return
	 */
	T findById(int id);
	
	/**
	 * 
	 * @Description 分页
	 * @param <T>
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<T> getPage(int startIndex, int pageSize);
	
}
