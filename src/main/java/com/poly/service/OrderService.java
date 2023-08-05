package com.poly.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.bean.Order;

public interface OrderService {

	Order create(JsonNode orderData);

	Order findById(String id);

	List<Order> findAll();

}
