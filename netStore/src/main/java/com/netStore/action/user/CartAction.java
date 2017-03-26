package com.netStore.action.user;

import java.util.List;
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
import com.netStore.service.BookService;
import com.netStore.service.ClassifyService;
import com.netStore.utils.Cart;
import com.netStore.utils.RandomUtils;

@Controller
public class CartAction {
	
	//自动注入 
	@Autowired
	public BookService BookService;
	//自动注入 
	@Autowired
	public ClassifyService ClassifyService;
	
	Cart cart = new Cart();
	long bid = 0;
	
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
				// 如果cookie中没有 书籍数量 说明 是重新开启浏览器
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
		
		model.addAttribute("cart", cart.getItems());
		model.addAttribute("totalmoney", cart.getTotalmoney());
		model.addAttribute("totalnum", cart.getTotalnum());
		
		
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
	 * @return
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
