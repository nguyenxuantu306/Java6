package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.bean.Book;

public interface BookDAO extends JpaRepository<Book, String> {
	
	@Query("SELECT p FROM Book p WHERE p.genres.id=?1")
	List<Book> findByCategoryId(String cid);
	
}
