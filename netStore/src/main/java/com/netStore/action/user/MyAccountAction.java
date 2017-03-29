package com.netStore.action.user;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.netStore.pojo.Book;
import com.netStore.pojo.Classify;
import com.netStore.pojo.Users;
import com.netStore.service.BookService;
import com.netStore.service.ClassifyService;
import com.netStore.service.UsersService;
import com.netStore.utils.RandomUtils;

@Controller
public class MyAccountAction {
	
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
	 * 将一些页面信息提前传到网页
	 * @param model
	 * @return
	 */
	@RequestMapping("/myaccount_bf")
	public String myaccount_bf(Model model){
		
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
		
		
		return "../../book_store/myaccount";
	}
	
	/**
	 * 登陆
	 * @param username 输入的用户名
	 * @param password 输入的密码
	 * @param terms 是否勾选记住
	 * @param model 返回提示信息
	 * @param response 记录cookie
	 * @return 
	 */
	@RequestMapping("/myaccount")
	public String myaccount(String username,String password,String terms,Model model,HttpServletResponse response){
		//标识符
		boolean flag = false;
		// 如果 输入为空时
		if(username == null || password == null){
			flag = false;
		}else if(username == "" || password == ""){
			flag = false;
		}else{
			// 不为空时，遍历查询是否正确
			List<Users> list = UsersService.list_users();
			for (Users users : list) {
				// 相同时
				if(users.getUsername().equals(username) && users.getPassword().equals(password)){
					flag = true;
					//如果有勾选 记住
					if(terms != null){
						Cookie cookie = new Cookie("username", username);
						// 记录三天
						cookie.setMaxAge(60*60*24*3);
						response.addCookie(cookie);
					// 没有勾选
					}else{
						Cookie cookie = new Cookie("username", username);
						// 浏览器关闭 cookie就消失
						cookie.setMaxAge(-1);
						response.addCookie(cookie);
					}
				}else{
					flag = false;
				}
			}
			
		}
		// 判断
		if(flag){
			model.addAttribute("msg", "");
			return "redirect:/cart.action";
		}else{
			model.addAttribute("msg", "用户名或密码错误");
			return "../../book_store/myaccount";
		}
		
	}

}
