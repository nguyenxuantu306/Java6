package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poly.bean.Account;

public interface AccountDAO extends JpaRepository<Account, String> {

//	@Query("SELECT DISTINCT ar.account FROM Account_roles ar WHERE ar.role.id IN (1,2)")
//	List<Account> getAdministrators();
	Account findByUsername(String username);
	
//	@Query("select Distinct o from Accounts o Join Accounts_roles ar ON o.Id = ar.Account_id where ar.Roles_id In (1)")
//	Account findAdmin();
}
