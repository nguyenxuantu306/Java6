package com.poly.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.bean.Order;

public interface OrderDAO extends JpaRepository<Order, String> {

	/*
	 * @Query("SELECT o FROM Order o WHERE o.account.username =?1") List<Order>
	 * findByUsername(String username);
	 */

}
