package com.poly.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.bean.OrderDetail;
import com.poly.bean.Report;
import com.poly.bean.Top10;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, String> {

	
	@Query("SELECT new Top10(o.book, sum(o.Quantity)) FROM OrderDetail o GROUP BY o.book ORDER BY sum(o.Quantity) DESC")
	List<Top10> getTop10();

	
	@Query("SELECT new Report(o, sum(o.Price * o.Quantity), sum(o.Quantity)) FROM OrderDetail o" 
	+ " GROUP BY o"
	+ " ORDER BY sum(o.Price *o.Quantity) DESC")
	List<Report> reportTheoLuotMuaHang();



}
