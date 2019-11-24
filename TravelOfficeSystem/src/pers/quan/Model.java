package pers.quan;

import java.util.List;

import pers.quan.model.Page;

/**
 *
 * @Discription 
 * @author John丶Woo
 * @date 2019年11月23日 下午11:43:18
 *
 */
public interface Model<T> extends Level {

	/**
	 * 
	 * @Description 更新
	 * @param t
	 * @return
	 */
	int update(T model);

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
	int insert(T model);

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
	T findById(Integer id);

	/**
	 * 
	 * @Description 分页
	 * @param <T>
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<T> getPage(Page<T> page);
}
