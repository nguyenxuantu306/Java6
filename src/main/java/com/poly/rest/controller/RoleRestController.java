package com.poly.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.bean.Role;
import com.poly.service.AccountRoleService;
import com.poly.service.RoleService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/roles")
public class RoleRestController {

	@Autowired
	RoleService roleService;
	
	@Autowired
	AccountRoleService accountRoleService;

	@GetMapping
	public List<Role> getAll(@RequestParam("admin") Optional<Boolean> admin) {
		if(admin.orElse(false)) {
			return accountRoleService.findRoleOfAdministrators();
		}
		return accountRoleService.findAll();
	}

}
