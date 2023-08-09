package com.poly.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.bean.Order;
import com.poly.bean.OrderDetail;

public interface OrderDAO extends JpaRepository<Order, Integer> {
	
	@Query("SELECT o FROM Order o WHERE o.account.username =?1")
	List<Order> findByIdAccount(String Id);
}
