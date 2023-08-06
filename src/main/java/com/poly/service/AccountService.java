package com.poly.service;

import java.util.List;

import com.poly.bean.Account;

public interface AccountService {

	public List<Account> findAll();

	public Account findById(String id);

	public Account create(Account account);

	public Account update(Account account);

	public void delete(String id);

//	public List<Account> getAdministrators();

	public Account  findByUsername(String username);

}
