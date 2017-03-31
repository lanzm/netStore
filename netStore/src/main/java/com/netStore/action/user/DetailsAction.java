package com.netStore.action.user;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

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
import com.netStore.pojo.Sort_cr;
import com.netStore.service.BookService;
import com.netStore.service.ClassifyService;
import com.netStore.service.CommentService;
import com.netStore.service.OrderService;
import com.netStore.service.ReplyService;
import com.netStore.service.UsersService;
import com.netStore.utils.Cart;
import com.netStore.utils.RandomUtils;

import edu.emory.mathcs.backport.java.util.Collections;

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
	
	
	@RequestMapping("/praise")
	public String praise(String cid, String praise){
		
		long id = Long.valueOf(cid);
		int pra = Integer.valueOf(praise);
		
		
		return "redirect:/details/" + bid + ".action";
	}
	
	/**
	 * 回复评论
	 * @param cid得到主评论的id
	 * @param uid得到主评论的用户的id
	 * @param reply得到回复内容
	 * @return返回详情页
	 */
	@RequestMapping("/reply")
	public String reply(String cid, String uid, String reply, String type){
		// 把id转为 long类型
		long ccid = Long.valueOf(cid);
		long uuid = Long.valueOf(uid);
		if(type == "0"){
			
		}
		
		Reply reply1 = new Reply();
		reply1.setComment(CommentService.get_CommentById(ccid));
		reply1.setR_content(reply);
		reply1.setR_praise(0);
		reply1.setR_time(new Date());
		reply1.setUsers(UsersService.get_usersById(uuid));
		reply1.setBook(BookService.get_BookById(bid));
		Set<Reply> replyset = new HashSet<Reply>();
		replyset.add(reply1);
		
		ReplyService.save_Reply(reply1);
		
		return "redirect:/details/" + bid + ".action";
	}
	
	
	/**
	 * 第一次评论，存到comment数据库中
	 * @param request得到用户名
	 * @param comments得到评论内容
	 * @return返回详情页
	 */
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
		
		
		return "redirect:/details/" + bid + ".action";
	}
	
	
	/**
	 * 接收路径传来的id值，把他放到全局变量中
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
		// 查出书籍有关的评论
		List<Comment> comments = CommentService.get_CommentByBid(bid);
		model.addAttribute("comments", comments);
		// 把回复送到页面,查出书籍有关的回复
		List<Reply> replys = ReplyService.get_ReplyByBid(bid);
		model.addAttribute("replys", replys);
		
		// 新建一个数组，用来存放 查询出来的 评论和回复
		List<Sort_cr> sort_time = new ArrayList<Sort_cr>();
		List<Sort_cr> sort_pra = new ArrayList<Sort_cr>();
		// 放入 评论
		for (Comment comment : comments) {
			
			Sort_cr sort_cr = new Sort_cr();
			sort_cr.setSid(comment.getCid());
			sort_cr.setBook(comment.getBook());
			sort_cr.setContent(comment.getContent());
			sort_cr.setPraise(comment.getPraise());
			sort_cr.setReply(comment.getReply());
			sort_cr.setUsers(comment.getUsers());
			sort_cr.setType("0");
			sort_cr.setTime(comment.getTime());
			
			sort_time.add(sort_cr);
			sort_pra.add(sort_cr);
		}
		// 放入 回复
		for (Reply reply : replys) {
			
			Sort_cr sor = new Sort_cr();
			sor.setBook(reply.getBook());
			sor.setSid(reply.getRid());
			sor.setContent(reply.getR_content());
			sor.setTime(reply.getR_time());
			sor.setType("1");
			sor.setPraise(reply.getR_praise());
			sor.setComment(reply.getComment());
			sor.setUsers(reply.getUsers());
			
			sort_time.add(sor);
			sort_pra.add(sor);
		}
		// 按赞降序来排序
		Collections.sort(sort_pra, new Comparator<Sort_cr>() {

			@Override
			public int compare(Sort_cr o1, Sort_cr o2) {
				
				return o1.getPraise() - o2.getPraise();
				
			}
			
		});
		// 按时间降序排列
		Collections.sort(sort_time, new Comparator<Sort_cr>() {

			@Override
			public int compare(Sort_cr o1, Sort_cr o2) {
				if(o1.getTime().before(o2.getTime())){
					return 1;
				}else{
					return -1;
				}
			}
		});
		// 把排序好的 数组送到页面
		model.addAttribute("sort_time", sort_time);
		
		
		
		return "../../book_store/details";
	}
	
	
}
