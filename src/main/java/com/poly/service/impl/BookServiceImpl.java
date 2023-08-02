package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.bean.Book;
import com.poly.dao.BookDAO;
import com.poly.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	BookDAO dao;
	
	public List<Book> findAll() {
		return dao.findAll();
	}

	@Override
	public Book findById(String id) {		
		return dao.findById(id).get();
	}

	@Override
	public Book create(Book book) {		
		return dao.save(book);
	}

	@Override
	public Book update(Book book) {
		return dao.save(book);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public List<Book> findByCategoryId(String cid) {
		
		return dao.findByCategoryId(cid);
	}

}
