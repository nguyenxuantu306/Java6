package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poly.bean.Account;

public interface AccountDAO extends JpaRepository<Account, String> {

	Account findByUsername(String username);

//	@Query("SELECT DISTINCT ar.account FROM Account_roles ar WHERE ar.role.id IN (1,2)")
//	List<Account> getAdministrators();

	
}
