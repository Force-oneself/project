package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;

public interface CustomerDao extends BaseDao<Customer>{

//	void add(Customer customer);

//	List<Customer> findAll();

//	Customer findOne(int cid);

//	void delete(Customer c);

//	void update(Customer customer);

	int findCount();

	List<Customer> findPage(int begin, int pageSize);

	List<Customer> findCondition(Customer customer);

	List<Customer> findMoreCondition(Customer customer);

	List<Dict> findAllDictLevel();

	List findCountSource();

	List findCountLevel();

}
