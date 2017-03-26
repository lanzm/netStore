package com.netStore.action.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.netStore.pojo.Book;
import com.netStore.pojo.Classify;
import com.netStore.pojo.Orders;
import com.netStore.service.BookService;
import com.netStore.service.ClassifyService;
import com.netStore.service.OrderService;
import com.netStore.utils.Cart;
import com.netStore.utils.RandomUtils;

@Controller
public class DetailsAction {
	
	//自动注入 
	@Autowired
	public BookService BookService;
	//自动注入 
	@Autowired
	public ClassifyService ClassifyService;
	@Autowired
	public OrderService OrderService;
	
	Cart cart = new Cart();
	long bid = 0;
	/**
	 * 接收路径传来的id值
	 * @param bid
	 * @return
	 */
	@RequestMapping("/details/{bid}")
	public String details(@PathVariable long bid){
		
		this.bid = bid;
		
		return "redirect:/details_af.action";
	}

	@RequestMapping("/details_af")
	public String details_af(Model model){
		
		// 把书籍传到网页
		Book book = BookService.get_BookById(bid);
		model.addAttribute("book", book);
		
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
		
		return "../../book_store/details";
	}
	
	
}
