package pers.quan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pers.quan.dao.AccountDao;
import pers.quan.domain.Account;
import pers.quan.service.AccountService;

/**
 *
 * @Discription implement AccountService interface
 * @author John丶Woo
 * @date 2019年9月17日 下午6:39:14
 *
 */
@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public List<Account> findAll() {
		return accountDao.findAll();
	}

	@Override
	public int save(Account account) {
		return accountDao.save(account);
	}

}
