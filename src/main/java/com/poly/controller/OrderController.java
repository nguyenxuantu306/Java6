package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

	@RequestMapping("/order/checkout")
	public String checkout() {
		return "order/checkout";
	}
	
	
}
