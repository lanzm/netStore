package com.netStore.action.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.netStore.pojo.Book;
import com.netStore.pojo.Classify;
import com.netStore.service.BookService;
import com.netStore.service.ClassifyService;

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
	
	
	@RequestMapping("/welcome")
	public String wellchosen(Model model) throws Exception {
		// 查出所有书籍
		List<Book> books = BookService.list_Book();
		// 书籍集合产生随机数
		List<Integer> list = random(books);
		// 把精选数据随机抽取送到网页
		model.addAttribute("book1", books.get(list.get(0)));
		model.addAttribute("book2", books.get(list.get(1)));
		
	//-------------计算时间差，判断是否是新书-----------------//
		List<Book> newbooks = new ArrayList<>();
		for(int i = 0; i < books.size() ; i ++ ){
			
			//格式化时间格式
			SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//获取当前时间
			Date nowTime=new Date();
			//格式化现在时间
			String tmf= matter1.format(nowTime);
			// 格式化数据库中的时间
			String sqltime = matter1.format(books.get(i).getAddtime());
			Date now=matter1.parse(tmf);
			Date end=matter1.parse(sqltime);
			//计算时间差
			long cha=(now.getTime()-end.getTime())/ (1000 * 60 * 60 * 24);
			// 时间差20天,则为新书
			if(cha <= 100){
				// 把他放到一个集合中
				newbooks.add(books.get(i));
			}
		}
		// 新书集合产生随机数
		List<Integer> newbookList = random(newbooks);
		// 产生的新书随机送到网页
		model.addAttribute("newbook1", books.get(newbookList.get(0)));
		model.addAttribute("newbook2", books.get(newbookList.get(1)));
		model.addAttribute("newbook3", books.get(newbookList.get(2)));
		// 得到 做促销的书籍
		List<Book> booksPromotions = BookService.get_BookPromotions();
		// 产生三个随机数
		List<Integer> booksp = random(booksPromotions);
		// 产生的促销书籍放到网页
		model.addAttribute("bookPromotions1", books.get(booksp.get(0)));
		model.addAttribute("bookPromotions2", books.get(booksp.get(1)));
		model.addAttribute("bookPromotions3", books.get(booksp.get(2)));
		// 分类传到网页
		List<Classify> classifies = ClassifyService.list_Classify();
		model.addAttribute("classifies", classifies);
		
		return "../../book_store/index";
		
	}
	/**
	 *  产生两个随机数
	 * @param books 输入books集合
	 * @return
	 */
	public List<Integer> random(List<Book> books){
		
		List<Integer> randoms = new ArrayList<>();
		
	//-------------随机数向网页推送书籍-----------------//
		// 产生随机数，随机推荐精选书籍
		Random random = new Random();
		int max = books.size();
		// 设置范围 0 ~ 书籍数
		int a = random.nextInt(max)%(max+1);
		boolean flag = true;
		int b = 0;
		int c = 0;
		// 产生三个不同的 随机数
		while(flag){
			b = random.nextInt(max)%(max+1);
			c = random.nextInt(max)%(max+1);
			if(a == b || a == c || b == c){
				flag = true;
			}else{
				flag = false;
			}
		}
		
		randoms.add(a);
		randoms.add(b);
		randoms.add(c);
		return randoms;
	}
	
}
