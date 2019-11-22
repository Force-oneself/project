package pers.quan.dao;


/**
 * @Description UserDao接口
 * @author 何永泉
 * @date 2019年8月23日 上午10:01:48
 *
 */
public interface UserDao<T> extends BaseDao<T>{
	
	T login(T t);
}
