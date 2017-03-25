package com.netStore.action.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.netStore.pojo.Book;
import com.netStore.pojo.Classify;
import com.netStore.service.BookService;
import com.netStore.service.ClassifyService;
import com.netStore.utils.Page;
import com.netStore.utils.RandomUtils;

@Controller
public class SpecialsAction {
	
	//自动注入 
	@Autowired
	public BookService BookService;
	//自动注入 
	@Autowired
	public ClassifyService ClassifyService;
	
	
	int msg = 1;
	
	@RequestMapping("/specials")
	public String specials(Model model){
		
		// 得到 做促销的书籍
		List<Book> booksPromotions = BookService.get_BookPromotions();
		model.addAttribute("bookP", booksPromotions);
		// 分页
		Page page = new Page(4, msg, booksPromotions.size());
		// 把促销书籍存入分页中
		page.setBooks(booksPromotions);
		// 把数据送到网页
		model.addAttribute("page", page);
		// 分类信息
		List<Classify> classifies = ClassifyService.list_Classify();
		model.addAttribute("classifies", classifies);
		// 随机
		RandomUtils randomUtils = new RandomUtils();
		List<Integer> booksp = randomUtils.random(booksPromotions);
		// 产生的促销书籍放到网页
		model.addAttribute("bookPromotions1", booksPromotions.get(booksp.get(0)));
		model.addAttribute("bookPromotions2", booksPromotions.get(booksp.get(1)));
		model.addAttribute("bookPromotions3", booksPromotions.get(booksp.get(2)));
		
		return "../../book_store/specials";
	}

	/**
	 * 分页按钮方法
	 * @param msg 网页传过来的分页数据
	 * @return
	 */
	@RequestMapping("/pageBook1/{msg}")
	public String pageBook1(@PathVariable int msg){
		// 把值赋到全局变量中
		this.msg = msg;
		
		return "redirect:/specials.action";
		
	}
	

}
