package com.poly.service;

import java.util.List;

import com.poly.bean.Role;

public interface AccountRoleService {
	public List<Role> findAll();
	
	public Role create(AccountRoleService auth);
	
	public void delete(Integer id);
	
	public List<Role> findRoleOfAdministrators();
}
