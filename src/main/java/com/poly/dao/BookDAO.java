package com.poly.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.poly.bean.Book;
import com.poly.bean.Report;

public interface BookDAO extends JpaRepository<Book, String> {

	@Query("SELECT p FROM Book p WHERE p.genres.id=?1")
	Page<Book> findByCategoryId(String cid, Pageable pageable);

	@Query("SELECT p FROM Book p WHERE p.Name like ?1")
	Page<Book> findProductByKeyword(String keyword, Pageable pageable);

	@Query("SELECT o FROM Book o WHERE o.genres.Genres like ?1")
	Page<Book> findCategoryByKeyword(String keyword, Pageable pageable);

	
//	@Query("SELECT new Report(o.book, sum(o.Price * o.Stock_quantity), sum(o.Stock_quantity)) FROM OrderDetails o"
//			+ " GROUP BY o.book" + " ORDER BY sum(o.Price * o.Stock_quantity) DESC")
//	List<Report> reportTheoProduct();
//	

}
