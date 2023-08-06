package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.bean.Book;
import com.poly.bean.Wishlist;
import com.poly.dao.BookDAO;
import com.poly.dao.WishlistDAO;

@Controller
public class HomeController {
	@Autowired
	private final BookDAO booksdao;

	@Autowired
	private final WishlistDAO wishlistsdao;

	public HomeController(BookDAO booksdao, WishlistDAO wishlistsdao) {
		this.booksdao = booksdao;
		this.wishlistsdao = wishlistsdao;
	}

	@GetMapping("/home/index")
	public String Home(Model model) {
		List<Book> books = booksdao.findAll();
		model.addAttribute("books", books);
		return "user/index";
	}

	@GetMapping("/index/profile")
	public String profile(Model model) {
		return "user/profile";
	}
//	@GetMapping("/index/wishlist")
//	public String wishlist(Model model) {
//		return "user/wishlist";
//	}

	@GetMapping("/index/product-detail/{productId}")
	public String getProductDetail(@PathVariable String productId, Model model) {
		// Fetch the specific product based on the given productId
		Book books = booksdao.findById(productId).orElse(null);
		if (books == null) {
			// Handle the case when the product is not found (optional)
			return "redirect:/index"; // Redirect to the home page or an error page
		}

		// Add the product to the model to be displayed in the modal box or product
		// detail page
		model.addAttribute("productDetails", books);
		return "product/product_detail"; // Replace with the actual Thymeleaf template for the modal content
	}

//	@GetMapping("/index/login")
//	public String login(Model model) {
//		return "/user/login";
//	}
//
//	@GetMapping("/index/register")
//	public String register(Model model) {
//		return "/user/register";
//	}
//
//	@GetMapping("/index/forgot")
//	public String forgot(Model model) {
//		return "/user/forgotpassword";
//	}

	@GetMapping("/index/wishlist")
	public String getAllWishlist(Model model) {
		List<Wishlist> wishlist = wishlistsdao.findAll();
		model.addAttribute("wishlist", wishlist);
		return "user/wishlist";
	}

	@RequestMapping({ "/admin", "/admin/home/index" })
	public String admin() {
		return "redirect:/assets/admin/index.html";
	}

}
