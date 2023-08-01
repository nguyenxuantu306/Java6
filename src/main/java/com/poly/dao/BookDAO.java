package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.poly.bean.Book;

public interface BookDAO extends JpaRepository<Book, String> {
	
}
