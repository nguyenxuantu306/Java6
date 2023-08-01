package com.poly.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.bean.Wishlist;



@Controller
public class SecurityController {

	@RequestMapping("/security/login/form")
	public String loginForm(Model model ) {
		model.addAttribute("message","Vui lòng đăng nhập!");
		return "security/login";
	}
	
	@RequestMapping("/security/login/success")
	public String loginSuccess(Model model ) {
		model.addAttribute("message","Đăng nhập thành công!");
		return "security/login";
	}
	
	@RequestMapping("/security/login/error")
	public String loginError(Model model ) {
		model.addAttribute("message","Sai thông tin đăng nhập!");
		return "security/login";
	}
	
	@RequestMapping("/security/unauthoried")
	public String unauthoried(Model model ) {
		model.addAttribute("message","Không có quyền truy xuất!");
		return "security/login";
	}
	
	@RequestMapping("/security/logoff/success")
	public String logoffSuccess(Model model ) {
		model.addAttribute("message","Bạn đã đăng xuất!");
		return "security/login";
	}
	
	@GetMapping("/index/login")
	public String login(Model model) {
		return "/security/login";
	}

	@GetMapping("/index/register")
	public String register(Model model) {
		return "/security/register";
	}

	@GetMapping("/index/forgot")
	public String forgot(Model model) {
		return "/security/forgotpassword";
	}



	

}
