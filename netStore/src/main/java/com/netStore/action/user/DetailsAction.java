package com.netStore.action.user;

import java.util.ArrayList;
import java.util.Comparator;
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
import com.netStore.pojo.Parent_Children;
import com.netStore.pojo.Sort_cr;
import com.netStore.service.BookService;
import com.netStore.service.ClassifyService;
import com.netStore.service.CommentService;
import com.netStore.service.OrderService;
import com.netStore.service.Parent_ChildrenService;
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
	public Parent_ChildrenService Parent_ChildrenService;
	
	// 新建购物车
	Cart cart = new Cart();
	// 把书籍id放到全局
	long bid = 0;
	
	/**
	 * 点赞
	 * @param cid
	 * @param praise
	 * @return
	 */
	@RequestMapping("/praise")
	public String praise(String cid, String praise){
		
		long id = Long.valueOf(cid);
		int pra = Integer.valueOf(praise);
		Comment comment = CommentService.get_CommentById(cid);
		comment.setPraise(pra);
		CommentService.save_Comment(comment);
		
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
	public String reply(String sid, String uid, String reply){
		// 把id转为 long类型
		long ssid = Long.valueOf(sid);
		long uuid = Long.valueOf(uid);
		// 新建评论，
		Comment comment = new Comment();
		comment.setBook(BookService.get_BookById(bid));
		comment.setContent(reply);
		comment.setPraise(0);
		comment.setTime(new Date());
		// 评论类型是 回复
		comment.setType(1);
		comment.setUsers(UsersService.get_usersById(uuid));
		// 把评论放入数据库中
		CommentService.save_Comment(comment);
		// 和 父类评论建立关联
		Parent_Children parent_Children = new Parent_Children();
		parent_Children.setParent_cid(ssid);
		parent_Children.setChildren_cid(comment.getCid());
		
		Parent_ChildrenService.save_Parent_Children(parent_Children);		
		
		
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
		comment.setType(0);
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
		//model.addAttribute("comments", comments);
		// 这个集合的作用是把数据都封装到里面，以便网页的查询
		List<Sort_cr> lists = new ArrayList<Sort_cr>();
		for (Comment comment : comments) {
			// 当评论是 回复时
			if(comment.getType() == 1){
				// 根据自己的 id 查出所有的 父类
				List<Parent_Children> pclists = Parent_ChildrenService.get_Parent_ChildrenByChildrenId(comment.getCid());
				// 先把自己 放到 sort中
				// 新建一个 排序集合
				Sort_cr soc = new Sort_cr();
				soc.setSid(comment.getCid());
				soc.setBook(comment.getBook());
				soc.setContent(comment.getContent());
				soc.setPraise(comment.getPraise());
				soc.setTime(comment.getTime());
				soc.setUsers(comment.getUsers());
				soc.setType(comment.getType());
				// 新建一个数组用来放 父子评论查询出来的 评论
				List<Comment> reply = new ArrayList<>();
				// 遍历父子评论取出所以关联数据
				for (Parent_Children parent_Children : pclists) {
					// pc数据库中 存的 pcid就是 comment的id
					reply.add(CommentService.get_CommentById(parent_Children.getParent_cid()));
				}
				// 把集合放到 soc中
				soc.setReply(reply);
				// 最后把所有数据放到 总集合中，以便网页查出来
				lists.add(soc);
			}
			if(comment.getType() == 0){
				// 新建一个 排序集合
				Sort_cr soc = new Sort_cr();
				soc.setSid(comment.getCid());
				soc.setBook(comment.getBook());
				soc.setContent(comment.getContent());
				soc.setPraise(comment.getPraise());
				soc.setTime(comment.getTime());
				soc.setUsers(comment.getUsers());
				soc.setType(comment.getType());
				// 如果为主评论的话，则没有回复，所以直接加入总集合中
				lists.add(soc);
			}
			
		}
		// 根据时间降序排序
		Collections.sort(lists,new Comparator<Sort_cr>() {

			@Override
			public int compare(Sort_cr o1, Sort_cr o2) {
				if(o1.getTime().before(o2.getTime())){
					return 1;
				}else{
					return -1;
				}
			}
		});
		// 把 时间排序送到网页
		model.addAttribute("lists_time", lists);
		
		
		return "../../book_store/details";
	}
	
	
}
