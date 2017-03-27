package com.netStore.action.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netStore.pojo.Book;
import com.netStore.pojo.Classify;
import com.netStore.pojo.Users;
import com.netStore.service.BookService;
import com.netStore.service.ClassifyService;
import com.netStore.service.UsersService;
import com.netStore.utils.RandomUtils;

@Controller
public class RegisterAction {
	
	//自动注入 
	@Autowired
	public BookService BookService;
	//自动注入 
	@Autowired
	public ClassifyService ClassifyService;
	//自动注入 
	@Autowired
	public UsersService UsersService;
	
	/**
	 * 异步数据传送，表单验证
	 * @return返回用户信息
	 */
	@RequestMapping("/register_js")
	public @ResponseBody List register_js(){
		// js请求 返回 用户信息
		return UsersService.list_users();
	}
	/**
	 * 注册页面之前向页面送数据
	 * @param model
	 * @return注册页面
	 */
	@RequestMapping("/register_bf")
	public String register_bf(Model model){
		
		// 把分类传到页面
		List<Classify> classifys = ClassifyService.list_Classify();
		model.addAttribute("classifies", classifys);
		
		// 得到 做促销的书籍
		List<Book> booksPromotions = BookService.get_BookPromotions();
		// 随机
		RandomUtils randomUtils = new RandomUtils();
		List<Integer> booksp = randomUtils.random(booksPromotions);
		// 产生的促销书籍放到网页
		model.addAttribute("bookPromotions1", booksPromotions.get(booksp.get(0)));
		model.addAttribute("bookPromotions2", booksPromotions.get(booksp.get(1)));
		model.addAttribute("bookPromotions3", booksPromotions.get(booksp.get(2)));
		
		return "../../book_store/register";
	}

	/**
	 * 注册用户
	 * @param users 
	 * @return返回登陆页面
	 */
	@RequestMapping("/register")
	public String register(Users users){
		
		UsersService.save_users(users);
		
		return "../../book_store/myaccount";
	}

	

	
}
