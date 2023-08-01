package com.poly.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.poly.bean.Book;
import com.poly.service.BookService;




@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	@RequestMapping("/product/shop_list")
	public String shop_list(Model model) {
		List<Book> list = bookService.findAll();
		model.addAttribute("items", list);
		return "product/shop_list";
	}
	
	@RequestMapping("/product/blog")
	public String blog(Model model) {
		List<Book> list = bookService.findAll();
		model.addAttribute("items", list);
		return "product/blog";
	}
	
	@RequestMapping("/product/portfolio")
	public String portfolio(Model model) {
		List<Book> list = bookService.findAll();
		model.addAttribute("items", list);
		return "product/portfolio";
	}
	
	@RequestMapping("/product/contact")
	public String shop_list3(Model model) {
		List<Book> list = bookService.findAll();
		model.addAttribute("items", list);
		return "product/contact";
	}
	
	
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model , @PathVariable("id") String id) {
		Book item = bookService.findById(id);
		model.addAttribute("item",item);
		return "product/detail";
	}
	
}
