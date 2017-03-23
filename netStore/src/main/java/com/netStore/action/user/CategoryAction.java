package com.netStore.action.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netStore.pojo.Book;
import com.netStore.service.BookService;
import com.netStore.service.ClassifyService;
import com.netStore.utils.Page;

@Controller
public class CategoryAction {
	
	//自动注入 
	@Autowired
	public BookService BookService;
	//自动注入 
	@Autowired
	public ClassifyService ClassifyService;
	
	
	int msg = 1;
	@RequestMapping("/category")
	public String category(Model model){
		// 用户页面
		Page page = BookService.pageBook(3, msg);
		// 得到查询出来的 书籍
		List<Book> lists = page.getBooks();
		model.addAttribute("page", page);
		model.addAttribute("books", lists);
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
