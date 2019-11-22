package pers.quan.service;
/**
 *
 * @Discription AccountService interface
 * @author John丶Woo
 * @date 2019年9月17日 下午6:37:02
 *
 */

import java.util.List;

import pers.quan.domain.Account;

public interface AccountService {

	List<Account> findAll();
	
	int save(Account account);
}
