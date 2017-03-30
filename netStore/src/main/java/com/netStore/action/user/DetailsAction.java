package com.netStore.action.user;

import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.netStore.pojo.Book;
import com.netStore.pojo.Classify;
import com.netStore.pojo.Comment;
import com.netStore.pojo.Reply;
import com.netStore.service.BookService;
import com.netStore.service.ClassifyService;
import com.netStore.service.CommentService;
import com.netStore.service.OrderService;
import com.netStore.service.ReplyService;
import com.netStore.service.UsersService;
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
	//自动注入 
	@Autowired
	public OrderService OrderService;
	//自动注入
	@Autowired
	public UsersService UsersService;
	//自动注入
	@Autowired
	public CommentService CommentService;
	//自动注入
	@Autowired
	public ReplyService ReplyService;
	
	// 新建购物车
	Cart cart = new Cart();
	// 把书籍id放到全局
	long bid = 0;
	
	
	@RequestMapping("/reply")
	public String reply(String cid, String uid, String reply){
		// 把id转为 long类型
		long ccid = Long.valueOf(cid);
		long uuid = Long.valueOf(uid);
		
		Reply reply1 = new Reply();
		reply1.setComment(CommentService.get_CommentById(ccid));
		reply1.setR_content(reply);
		reply1.setR_praise(0);
		reply1.setR_time(new Date());
		reply1.setUsers(UsersService.get_usersById(uuid));
		
		ReplyService.save_Reply(reply1);
		
		return "redirect:/details/" + uuid + ".action";
	}
	
	@RequestMapping("/comment")
	public String comment(HttpServletRequest request, String comments){
		String username = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("username")){
				username = cookie.getValue();
			}
		}
		
		// 初始化 评论
		Comment comment = new Comment();
		comment.setContent(comments);
		comment.setPraise(0);
		comment.setUsers(UsersService.get_usersByName(username));
		comment.setBook(BookService.get_BookById(this.bid));
		comment.setTime(new Date());
		// 保存评论
		CommentService.save_Comment(comment);
		
		
		return "redirect:/details/" + UsersService.get_usersByName(username).getUid() + ".action";
	}
	
	
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

	/**
	 * 详情网页必要的数据
	 * @param model
	 * @return返回详情网页
	 */
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
		
		// 把评论送到页面
		List<Comment> comments = CommentService.get_CommentByBid(bid);
		model.addAttribute("comments", comments);
		
		return "../../book_store/details";
	}
	
	
}
