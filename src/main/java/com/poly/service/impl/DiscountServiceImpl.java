package com.poly.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.bean.Book;
import com.poly.bean.Discount;
import com.poly.bean.Order;
import com.poly.bean.OrderDetails;
import com.poly.dao.BookDAO;
import com.poly.dao.DiscountDAO;
import com.poly.dao.OrderDAO;
import com.poly.dao.OrderDetailDAO;
import com.poly.service.BookService;
import com.poly.service.DiscountService;
import com.poly.service.OrderService;

@Service
public class DiscountServiceImpl implements DiscountService{
	@Autowired
	DiscountDAO dao;

	@Override
	public List<Discount> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
}
