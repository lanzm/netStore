package com.netStore.action.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.netStore.pojo.Book;
import com.netStore.pojo.Classify;
import com.netStore.service.BookService;
import com.netStore.service.ClassifyService;
import com.netStore.utils.NewBooks;
import com.netStore.utils.RandomUtils;

@Controller
public class IndexAction {
	
	//自动注入 
	@Autowired
	public BookService BookService;
	//自动注入 
	@Autowired
	public ClassifyService ClassifyService;
	
	
//	@Scheduled(cron = "0/10 * *  * * ? ")
//	public void wellchosen_time(){
//		
//         System.out.println("*********A任务每10秒执行一次进入测试"); 
//        
//         List<Book> books = BookService.list_Book();
//         System.out.println(books.get(0).getBookname());
//         wellchosenBooks.add(books.get(0));
//         wellchosenBooks.add(books.get(1));
//		 i ++;
//		 if(books.size() == i){
//			 i = 0;
//		 }
//		 System.out.println("i = " + i);
//		 System.out.println(wellchosenBooks.get(0).getBookname());
//	}
	
	/**
	 * 欢迎界面，
	 * @param model
	 * @return返回第一页
	 * @throws Exception
	 */
	@RequestMapping("/welcome")
	public String wellchosen(Model model) throws Exception {
		// 查出所有书籍
		List<Book> books = BookService.list_Book();
		// 书籍集合产生随机数
		RandomUtils randomUtils = new RandomUtils();
		List<Integer> list = randomUtils.random(books);
		// 把精选数据随机抽取送到网页
		model.addAttribute("book1", books.get(list.get(0)));
		model.addAttribute("book2", books.get(list.get(1)));
		// 调用 新书产生方法
		NewBooks newBooks = new NewBooks();
		List<Book> newbooks = newBooks.get_newBook(books);
		// 新书集合产生随机数
		List<Integer> newbookList = randomUtils.random(newbooks);
		// 产生的新书随机送到网页
		model.addAttribute("newbook1", books.get(newbookList.get(0)));
		model.addAttribute("newbook2", books.get(newbookList.get(1)));
		model.addAttribute("newbook3", books.get(newbookList.get(2)));
		// 得到 做促销的书籍
		List<Book> booksPromotions = BookService.get_BookPromotions();
		// 产生三个随机数
		List<Integer> booksp = randomUtils.random(booksPromotions);
		// 产生的促销书籍放到网页
		model.addAttribute("bookPromotions1", booksPromotions.get(booksp.get(0)));
		model.addAttribute("bookPromotions2", booksPromotions.get(booksp.get(1)));
		model.addAttribute("bookPromotions3", booksPromotions.get(booksp.get(2)));
		// 分类传到网页
		List<Classify> classifies = ClassifyService.list_Classify();
		model.addAttribute("classifies", classifies);
		
		return "../../book_store/index";
		
	}

	

}
