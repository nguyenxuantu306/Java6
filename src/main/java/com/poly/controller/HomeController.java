package com.poly.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {


	@RequestMapping({"/","/home/index"})
	public String Home(Model model) {
		return "redirect:/product/shop_list";
	}


	@RequestMapping({ "/admin", "/admin/home/index" })
	public String admin() {
		return "redirect:/assets/admin/index.html";
	}

}
