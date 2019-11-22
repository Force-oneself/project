package pers.quan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pers.quan.domain.Account;
import pers.quan.service.AccountService;

/**
 *
 * @Discription AccountController
 * @author John丶Woo
 * @date 2019年9月17日 下午6:43:25
 *
 */
@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/findall")
	public String findAll() {
		List<Account> list = accountService.findAll();
		for (Account account : list) {
			System.out.println(account);
		}
		return "success";
	}
	
	@RequestMapping("/save")
	public String save() {
		Account account = new Account();
		account.setName("小明");
		account.setMoney(123456.0);
		System.out.println(accountService.save(account));
		return "success";
	}
}
