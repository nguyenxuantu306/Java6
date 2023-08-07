package com.poly.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.bean.Order;

public interface OrderService {

	Order create(JsonNode orderData);
	List<Order> findAll();

	List<Order> findByIdAccount(String username);



	Order findById(Integer id);
	
	

}
