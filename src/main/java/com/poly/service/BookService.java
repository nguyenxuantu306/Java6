package com.poly.service;

import java.util.List;

import com.poly.bean.Book;

public interface BookService {

	List<Book> findAll();

	Book findById(String id);

	Book create(Book book);

	Book update(Book book);

	void delete(String id);

	List<Book> findByCategoryId(String cid);

	

}
