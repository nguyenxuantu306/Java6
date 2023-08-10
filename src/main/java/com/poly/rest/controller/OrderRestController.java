package com.poly.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonNode;
import com.poly.bean.Account;
import com.poly.bean.Order;
<<<<<<< HEAD
import com.poly.bean.OrderDetail;
=======
import com.poly.bean.Report;
>>>>>>> origin/Hung_ThongKeTT
import com.poly.service.OrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
	@Autowired
	OrderService orderService;

	@GetMapping
	public List<Order> getAll() {
		return orderService.findAll();
	}

	@PostMapping("/add")
	public Order create(@RequestBody JsonNode orderData) {
		return orderService.create(orderData);
	}
	
<<<<<<< HEAD
	@PutMapping("{id}")
	public Order update(@PathVariable("id") Integer id, @RequestBody Order order) {
		return orderService.update(order);
	}
=======
>>>>>>> origin/Hung_ThongKeTT

}
