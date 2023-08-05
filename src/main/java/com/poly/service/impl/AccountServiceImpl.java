package com.poly.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.poly.bean.Account;
import com.poly.bean.Role;
import com.poly.dao.AccountDAO;
import com.poly.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {

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
	public Account findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	//find by usser
	public AccountServiceImpl(AccountDAO accountdao) {
		this.adao = accountdao;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Account account = adao.findByUsername(username);
		if (account == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }else {
        	return User.builder().username(account.getUsername())
                    .password(account.getPassword())
                    .roles(account.getAccountroles().stream().map(er -> er.getRole().getName()).collect(Collectors.toList()).toArray(new String [0])).build();
        }
		
	}

	
	 private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
	        Collection<? extends GrantedAuthority> mapRoles = roles.stream()
	                .map(role -> new SimpleGrantedAuthority(role.getName()))
	                .collect(Collectors.toList());
	        return mapRoles;
	    }
//	@Override
//	public List<Account> getAdministrators() {
//		return adao.getAdministrators();
//	}

}
