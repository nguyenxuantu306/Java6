package com.poly.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.bean.Order;

public interface OrderDAO extends JpaRepository<Order, Integer> {
	
	@Query("SELECT o FROM Order o WHERE o.account.id =?1")
	List<Order> findByIdAccount(String id);

}
