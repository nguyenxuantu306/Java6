package com.poly.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.bean.Discount;
import com.poly.bean.Order;

public interface DiscountService {

	List<Discount> findAll();

}
