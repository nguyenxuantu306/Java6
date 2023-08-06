package com.poly.service;

import java.util.List;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

import com.poly.bean.Account;

public interface AccountService {

	public List<Account> findAll();

	public Account findById(String id);

	public Account create(Account account);

	public Account update(Account account);

	public void delete(String id);
	
	public Account  findByUsername(String username);



	

//	public List<Account> getAdministrators();
	
}
