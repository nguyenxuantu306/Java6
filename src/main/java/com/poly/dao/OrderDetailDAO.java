package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.bean.OrderDetails;

public interface OrderDetailDAO extends JpaRepository<OrderDetails, String> {

}
