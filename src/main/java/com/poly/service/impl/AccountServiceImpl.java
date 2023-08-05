package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.bean.Account;
import com.poly.dao.AccountDAO;
import com.poly.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDAO adao;

	@Override
	public List<Account> findAll() {
		return adao.findAll();
	}

	@Override
	public Account findById(String id) {
		return adao.findById(id).get();
	}

	@Override
	public Account create(Account account) {
		return adao.save(account);
	}

	@Override
	public Account update(Account account) {
		return adao.save(account);
	}

	@Override
	public void delete(String id) {
		adao.deleteById(id);

	}


	@Override
	public List<Account> getAdministrators() {
		return adao.getAdministrators();
	}

}
