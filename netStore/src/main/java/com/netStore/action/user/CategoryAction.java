package com.netStore.action.user;

import java.util.List;
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
public class CategoryAction {
	
	//自动注入 
	@Autowired
	public BookService BookService;
	//自动注入 
	@Autowired
	public ClassifyService ClassifyService;
	// 分页按钮的值，默认为第一页
	int msg = 1;
	
	/**
	 * 书城页面所需要的必要数据
	 * @param model
	 * @return返回书城网页
	 */
	@RequestMapping("/category")
	public String category(Model model){
		// 用户页面
		Page page = BookService.pageBook(12, msg);
		// 得到查询出来的 书籍
		List<Book> lists = page.getBooks();
		// 把数据送到网页
		model.addAttribute("page", page);
		model.addAttribute("books", lists);
		// 分类信息
		List<Classify> classifies = ClassifyService.list_Classify();
		model.addAttribute("classifies", classifies);
		
		//得到所有的书
		List<Book> books = BookService.list_Book();
		// 得到 做促销的书籍
		List<Book> booksPromotions = BookService.get_BookPromotions();
		// 产生三个随机数
		RandomUtils randomUtils = new RandomUtils();
		List<Integer> booksp = randomUtils.random(booksPromotions);
		// 产生的促销书籍放到网页
		model.addAttribute("bookPromotions1", booksPromotions.get(booksp.get(0)));
		model.addAttribute("bookPromotions2", booksPromotions.get(booksp.get(1)));
		model.addAttribute("bookPromotions3", booksPromotions.get(booksp.get(2)));
		
		return "../../book_store/category";
	}

	/**
	 * 分页按钮方法
	 * @param msg 网页传过来的分页数据
	 * @return
	 */
	@RequestMapping("/pageBook/{msg}")
	public String pageBook(@PathVariable int msg){
		// 把值赋到全局变量中
		this.msg = msg;
		
		return "redirect:/category.action";
		
	}
	
}
