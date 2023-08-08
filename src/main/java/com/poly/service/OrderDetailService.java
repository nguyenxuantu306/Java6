package com.poly.service;

import java.util.List;

import com.poly.bean.Account;
import com.poly.bean.OrderDetail;
import com.poly.bean.Top10;

public interface OrderDetailService {

	List<OrderDetail> findAll();

	List<Top10> getTop10();

	OrderDetail findById(String id);

	List<OrderDetail> findByIdOrder(Integer id);


}
