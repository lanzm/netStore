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
public class ClassifyBookAction {
	
	//自动注入 
	@Autowired
	public BookService BookService;
	//自动注入 
	@Autowired
	public ClassifyService ClassifyService;
	
	
	int msg = 1;
	String classifyname;
	List<Book> books = new ArrayList<Book>();
	
	@RequestMapping("/classify/{cid}")
	public String classify(@PathVariable long cid,Model model){
		
		books = BookService.get_BookByClassify(cid);
		classifyname = ClassifyService.get_ClassifyById(cid).getClassifyname();
		
		return "redirect:/classify_af.action";
	}
	
	@RequestMapping("/classify_af")
	public String classify_af(Model model){

		// 新建分页
		Page page = new Page(12, msg, books.size());
		// 把 分类书籍存入
		page.setBooks(books);
		// 把数据送到网页
		model.addAttribute("page", page);
		// 把 分类书籍送到网页
		model.addAttribute("books", books);
		// 分类名称
		model.addAttribute("classifyname", classifyname);
		
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
		
		return "../../book_store/classify";
	}

	/**
	 * 分页按钮方法
	 * @param msg 网页传过来的分页数据
	 * @return
	 */
	@RequestMapping("/pageBook2/{msg}")
	public String pageBook(@PathVariable int msg){
		// 把值赋到全局变量中
		this.msg = msg;
		
		return "redirect:/classify_af.action";
		
	}
	
}
