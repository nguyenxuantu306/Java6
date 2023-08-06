package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

	@RequestMapping("/order/checkout")
	public String checkout() {
		return "order/checkout";
	}
	
	@RequestMapping("/order/list")
	public String orlist() {
		return "order/list";
	}
	
	@RequestMapping("/order/detail/{id}")
	public String ordetail() {
		return "order/detail";
	}

}
