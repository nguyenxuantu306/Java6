package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.poly.bean.Account_roles;


public interface Account_rolesDao extends JpaRepository<Account_roles, Integer> {

//	@Query("SELECT DISTINCT a FROM Account_roles a WHERE a.accounts IN ?1")
//	List<Account_roles> authoritiesOf(List<Account> account);

}
