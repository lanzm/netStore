package com.netStore.action.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.netStore.pojo.Book;
import com.netStore.pojo.Classify;
import com.netStore.pojo.OrderItem;
import com.netStore.pojo.Orders;
import com.netStore.pojo.Users;
import com.netStore.service.BookService;
import com.netStore.service.ClassifyService;
import com.netStore.service.OrderService;
import com.netStore.service.OrderItemService;
import com.netStore.service.UsersService;
import com.netStore.utils.Cart;
import com.netStore.utils.Cartitems;
import com.netStore.utils.RandomUtils;

@Controller
public class CartAction {
	
	//自动注入 
	@Autowired
	public BookService BookService;
	//自动注入 
	@Autowired
	public ClassifyService ClassifyService;
	@Autowired
	public UsersService UsersService;
	@Autowired
	public OrderService OrderService;
	@Autowired
	public OrderItemService OrderItemService;
	
	// 新建购物车
	Cart cart = new Cart();
	long bid = 0;
	
		
	
	/**
	 * 结账，把订单存入数据库
	 * @param request把cookie取出
	 * @param model把购物车信息送到pay界面
	 * @return返回支付页面
	 */
	@RequestMapping("/pay")
	public String pay(HttpServletRequest request, HttpServletResponse response, Model model){
		
		boolean flag = true;
		String username = null;
		//判断是否登陆
		Cookie[] cookies = request.getCookies();
		if(cookies == null){
			flag = false;
		}else{
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("username")){
					username = cookie.getValue();
					//如果用户是空， 则跳转到登陆页面
					if(username.equals(null) || username.equals("null")){
						flag = true;
					}else{
						flag = false;
					}
					break;
				}
			}
		}
		// 如果没有用户则跳转到登陆页面
		if(flag){
			return "redirect:/myaccount_bf.action";
		}
		
		// 新建订单
		//开始存订单
		Orders orders = new Orders();
		// 查询出现在的用户是谁
		Users user = UsersService.get_usersByName(username);
		// 设置状态
		orders.setStatus("0");
		orders.setTotalmoney(cart.getTotalmoney());
		orders.setTotalnum(String.valueOf(cart.getTotalnum()));
		orders.setUsers(user);
		OrderService.save_order(orders);
		// 把 循环中的信息取出
		List<OrderItem> orderi = new ArrayList<OrderItem>();
		// 遍历 购物车 把单个书籍提取出来，并存到数据库中
		for(Entry<Long, Cartitems> item : cart.getItems().entrySet()){
			// 新建单项
			OrderItem orderItem = new OrderItem();
			orderItem.setBook(item.getValue().getBook());
			orderItem.setMoney(item.getValue().getMoney());
			orderItem.setNum(String.valueOf(item.getValue().getTotalbook()));
			orderItem.setOrders(orders);
			// 把它放到 全局中
			orderi.add(orderItem);
			// 保存单项
			OrderItemService.save_orderItem(orderItem);
		}
		// 把购物车的信息送到 pay界面
		model.addAttribute("orders", orders);
		model.addAttribute("orderr", orderi);
		// 把订单号送到cookie中
		Cookie cookie = new Cookie("orderid", orders.getOid());
		cookie.setMaxAge(-1);
		response.addCookie(cookie);

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
		
		model.addAttribute("cart", cart.getItems());
		model.addAttribute("totalmoney", cart.getTotalmoney());
		model.addAttribute("totalnum", cart.getTotalnum());
		
		
		return "../../book_store/pay";
	}
	
	/**
	 * 购物车页面
	 * @param model 网页数据
	 * @param request 判断是否有cookie
	 * @return 购物车页面
	 */
	@RequestMapping("/cart")
	public String cart(Model model,HttpServletRequest request){
		
		// 判断 是否是重新开启浏览器
		boolean flag = true;
		// 获取 cookie，用cookie来判断
		Cookie[] cookies = request.getCookies();
		if(cookies == null){
			flag = true;
		}else{
			for (Cookie cookie : cookies) {
				// 如果cookie中有 书籍数量 说明 不是重新开启浏览器
				if(cookie.getName().equals("itemsnum")){
					flag = false;
					break;
				}
			}
		}
		// 把服务器中存储的购物项清空
		if(flag){
			cart.getItems().clear();
			cart.setTotalmoney(0);
			cart.setTotalnum(0);
		}
		
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
		// 把购物车信息送到网页
		model.addAttribute("cart", cart.getItems());
		model.addAttribute("totalmoney", cart.getTotalmoney());
		model.addAttribute("totalnum", cart.getTotalnum());
		// 返回购物车页面
		return "../../book_store/cart";
	}
	
	/**
	 *  购物车中删除一行
	 * @param bid 接收id
	 * @return 
	 */
	@RequestMapping("/romcart/{bid}")
	public String romcart(@PathVariable long bid){
		// id查出 book
		Book book = BookService.get_BookById(bid);
		// 把书籍添加到 map 中 以便 在购物车页面中浏览
		cart.romitem(book);
		
		return "redirect:/cart_js.action";
		
	}
	
	/**
	 *  购物车中删除一本书
	 * @param bid 接收id
	 * @return 
	 */
	@RequestMapping("/delcart/{bid}")
	public String delcart(@PathVariable long bid){
		// id查出 book
		Book book = BookService.get_BookById(bid);
		// 把书籍添加到 map 中 以便 在购物车页面中浏览
		cart.delitem(book);
		
		return "redirect:/cart_js.action";
		
	}
	
	/**
	 *  购物车中添加一本书
	 * @param bid 接收id
	 * @return 
	 */
	@RequestMapping("/addcart/{bid}")
	public String addcart(@PathVariable long bid){
		// 把书籍的id值放到 全局变量中
		this.bid = bid;
		// id查出 book
		Book book = BookService.get_BookById(bid);
		// 把书籍添加到 map 中 以便 在购物车页面中浏览
		cart.additem(book);
		
		return "redirect:/cart_js.action";
		
	}
	/**
	 *  把值 存入 cookie
	 * @param response 
	 * @return返回书城页面
	 */
	@RequestMapping("/cart_js")
	public String cart_js(HttpServletResponse response){
		// 把书籍数量转换为string类型
		String num = String.valueOf(cart.getTotalnum());
		// 存到 cookie中
		Cookie cookie = new Cookie("itemsnum", num);
		// 设置仅页面有效，关闭页面后 cookie即消失
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		// 把书籍金额存入cookie
		String money = String.valueOf(cart.getTotalmoney());
		Cookie cookie2 = new Cookie("money", money);
		// 设置仅页面有效，关闭页面后 cookie即消失
		cookie2.setMaxAge(-1);
		response.addCookie(cookie2);
		
		// 总金额
		String totalmoney = String.valueOf( cart.getTotalmoney());
		Cookie cookie3 = new Cookie("totalmoney", totalmoney);
		cookie3.setMaxAge(-1);
		response.addCookie(cookie3);
		
		// 总数量
		String totalnum = String.valueOf(cart.getTotalnum());
		Cookie cookie4 = new Cookie("totalnum", totalnum);
		cookie4.setMaxAge(-1);
		response.addCookie(cookie4);
		
		
		// 返回书城页面
		return "redirect:/cart.action";
	}


}
