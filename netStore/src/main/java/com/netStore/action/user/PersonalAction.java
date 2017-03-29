package com.netStore.action.user;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.netStore.service.BookService;
import com.netStore.service.ClassifyService;
import com.netStore.service.OrderService;
import com.netStore.service.UsersService;
import com.netStore.utils.RandomUtils;
import com.netStore.pojo.Book;
import com.netStore.pojo.Classify;
import com.netStore.pojo.Orders;
import com.netStore.pojo.Users;

@Controller
public class PersonalAction {
	
	//自动注入 
	@Autowired
	public BookService BookService;
	//自动注入 
	@Autowired
	public ClassifyService ClassifyService;
	//自动注入 
	@Autowired
	public UsersService UsersService;
	//自动注入 
	@Autowired
	public OrderService OrderService;
	
	// 从cookie中取出的用户名
	String username = null;
	String oid = null;
	
	
	@RequestMapping("/personal_del/{oid}")
	public String personal_del(@PathVariable String oid){
		
		OrderService.remove_order(oid);
		
		return "redirect:/personal.action";
		
	}
	
	
	/**
	 * 确定订单
	 * @param model向网页传订单数据
	 * @param response存cookie
	 * @return返回pay页面
	 */
	@RequestMapping("/personal_sure")
	public String personal_sure(Model model, HttpServletResponse response){
		if(oid == null){
			// 如果 没有正确接收到 oid值
		}else{
			Orders orders = OrderService.get_orderById(oid);
			model.addAttribute("orders", orders);
			model.addAttribute("orderr", orders.getOrderitem());
			
			// 把订单号送到cookie中
			Cookie cookie = new Cookie("orderid", orders.getOid());
			cookie.setMaxAge(-1);
			response.addCookie(cookie);
			// 把总金额送到cookie中
			Cookie cookie2 = new Cookie("totalmoney", String.valueOf(orders.getTotalmoney()));
			cookie2.setMaxAge(-1);
			response.addCookie(cookie2);
		}
		
		return "../../book_store/pay";
	}
	
	/**
	 * 从网页接收id值
	 * @param oid订单id
	 * @return返回确认订单方法
	 */
	@RequestMapping("/personal_orders/{oid}")
	public String personal_orders(@PathVariable String oid){

		this.oid = oid;
		
		return "redirect:/personal_sure.action";
		
	}
	
	/**
	 * 修改用户信息
	 * @param users表单传来的用户信息
	 * @return返回个人中心
	 */
	@RequestMapping("/personal_af")
	public String personal_af(Users users){
		
		UsersService.remove_users(users.getUid());
		UsersService.save_users(users);
		
		return "redirect:/personal.action";
	}
	
	/**
	 * 用户修改
	 * @param model把值传到网页
	 * @return返回update页面
	 */
	@RequestMapping("/personal_update")
	public String personal_update(Model model){
		
		if(username == null){
			return "redirect:/myaccount_bf.action";
		}else{
			
			Users users = UsersService.get_usersByName(username);
			model.addAttribute("users", users);
			
		}
		
		return "../../book_store/update";
		
	}
	
	/**
	 * 用户个人中心界面
	 * @param request取出cookie，
	 * @param response
	 * @param model把页面信息送到网页
	 * @return返回个人中心页面
	 */
	@RequestMapping("/personal")
	public String pay_js(HttpServletRequest request, HttpServletResponse response, Model model){
		
		boolean flag = false;
		// 接受 返回报文，判断是否支付成功
		Enumeration<?> temp = request.getParameterNames();
		if (null != temp) {
			while (temp.hasMoreElements()) {
				String en = (String) temp.nextElement();
				// 返回信息
				if(en.equals("respMsg")){
					// 如果为成功
					if(request.getParameter(en).equals("success")){
						// 把标识符置为 真
						flag = true;
						// 跳出 循环
						break;
					}
				}
			}
		}
		
		String orderid = null;
		//清空用户名以外的cookie
		Cookie[] cookie = request.getCookies();
		if(cookie.length > 0){
			for (Cookie cookie2 : cookie) {
				// 取出订单id
				if(cookie2.getName().equals("orderid")){
					orderid = cookie2.getValue();
				}
				// 除了用户名
				if(!cookie2.getName().equals("username")){
					Cookie cookie3 = new Cookie(cookie2.getValue(), null);
					cookie3.setMaxAge(0);
					response.addCookie(cookie3);
				}else{
					username = cookie2.getValue();
				}
			}
		}else{
			return "redirect:/myaccount_bf.action";
		}
		// 如果没有用户名,则跳转到登陆页面
		if(username == null){
			return "redirect:/myaccount_bf.action";
		}
		// 如果报文返回成功，则更新状态，为已付款
		if(flag){
			// 将 订单的状态置为  已付款状态
			Orders orders = OrderService.get_orderById(orderid);
			orders.setStatus("1");
			OrderService.update_order(orders);
			
		}
		// 把用户 信息送到 页面
		model.addAttribute("users", UsersService.get_usersByName(username));
		// 把订单 信息送到页面
		List<Orders> orders = OrderService.get_orderByUid(UsersService.get_usersByName(username).getUid());
		// 全部订单,送到网页
		model.addAttribute("ordersAll", orders);
		
		// 创建一个集合，放未付款的订单
		List<Orders> orders_0 = new ArrayList<Orders>();
		for (Orders orders2 : orders) {
			if(orders2.getStatus().equals("0")){
				orders_0.add(orders2);
			}
		}
		// 未付款订单送到网页
		model.addAttribute("orders", orders_0);
		
		
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
		
		
		
		return "../../book_store/personal";
		
	}

}
