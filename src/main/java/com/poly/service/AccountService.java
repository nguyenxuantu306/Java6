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

	public Account findByEmail(String Email);

	public void createPasswordResetTokenForUser(Account user, String token);

//	public List<Account> getAdministrators();
	
}
