package pers.quan.dao;
/**
 *
 * @Discription AccountDao interface
 * @author John丶Woo
 * @date 2019年9月17日 下午6:41:19
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import pers.quan.domain.Account;

@Repository
public interface AccountDao {

	@Select("select * from account")
	List<Account> findAll();
	
	@Insert("insert into account(name,money) values(#{name},#{money})")
	int save(Account account);
}
