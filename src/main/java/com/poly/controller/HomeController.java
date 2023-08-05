package com.poly.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.bean.Account;
import com.poly.bean.Account_roles;
import com.poly.bean.Book;
import com.poly.bean.Wishlist;
import com.poly.dao.AccountDAO;
import com.poly.dao.BookDAO;
import com.poly.dao.WishlistDAO;

@Controller
public class HomeController {
	@Autowired
	private final BookDAO booksdao;
	
	@Autowired
	AccountDAO acdao;

	@Autowired
	private final WishlistDAO wishlistsdao;

	public HomeController(BookDAO booksdao, WishlistDAO wishlistsdao) {
		this.booksdao = booksdao;
		this.wishlistsdao = wishlistsdao;
	}

	@GetMapping("/home/index")
	public String Home(Model model) {
		List<Book> books = booksdao.findAll();
		
		 // Lấy thông tin người dùng đã xác thực từ SecurityContextHolder
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Kiểm tra nếu người dùng đã xác thực
        if (authentication.isAuthenticated()) {
            // Lấy tên người dùng
            String username = authentication.getName();

            // Lấy các quyền (roles) của người dùng
            String roles = authentication.getAuthorities().toString();

            // Trả về thông tin tài khoản trong phản hồi
            System.out.println("Xin chào, " + username + "! Bạn có các quyền: " + roles);
        } else {
        	System.out.println("Xin chào! Bạn chưa đăng nhập.");
        }
        String username = authentication.getName();
        Account ac = acdao.findByUsername(username);
        System.out.println(ac.getUsername());
        System.out.println(ac.getAddress());
        System.out.println(ac.getFullname());
        System.out.println(ac.getPassword());
        System.out.println(ac.getPhone());
        System.out.println(ac.getPhoto());
        System.out.println("*************************************************************************?///////////////////////");
    System.out.println(ac.getAccountroles().stream().map(er -> er.getRole().getName()).collect(Collectors.toList())); 
		model.addAttribute("books", books);
		return "user/index";
	}
	

	

	@GetMapping("/index/product-detail/{productId}")
	public String getProductDetail(@PathVariable String productId, Model model) {
		Book books = booksdao.findById(productId).orElse(null);
		if (books == null) {
			return "redirect:/index";
		}
		model.addAttribute("productDetails", books);
		return "product/product_detail";
	}



	@GetMapping("/index/wishlist")
	public String getAllWishlist(Model model) {
		List<Wishlist> wishlists = wishlistsdao.findAll();
		model.addAttribute("wishlists", wishlists);
		return "user/wishlist";
	}


	

	@RequestMapping({"/admin","/admin/home/index"})
	public String admin() {
		return "redirect:/assets/admin/index.html";
	}
	
}
