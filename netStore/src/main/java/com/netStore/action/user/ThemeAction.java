package com.netStore.action.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.netStore.pojo.Book;
import com.netStore.pojo.Classify;
import com.netStore.pojo.Theme;
import com.netStore.pojo.ThemeItem;
import com.netStore.service.BookService;
import com.netStore.service.ClassifyService;
import com.netStore.service.ThemeItemService;
import com.netStore.service.ThemeService;
import com.netStore.service.UsersService;
import com.netStore.utils.RandomUtils;

@Controller
public class ThemeAction {
	
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
	public ThemeService ThemeService;
	//自动注入 
	@Autowired
	public ThemeItemService ThemeItemService;
	
	
	@RequestMapping("/addtheme_af")
	public String addtheme_af(String tcontent, String[] bookname, String[] thcontent, HttpServletRequest request){
		// 新建 主题
		Theme theme = new Theme();
		// 封装 单项书籍推荐
		Set<ThemeItem> itme = new HashSet<ThemeItem>();
		// 循环取出单项
		for(int i = 0; i < bookname.length; i++){
			// 新建单项
			ThemeItem item = new ThemeItem();
			item.setBook(BookService.get_BookByName(bookname[i]));
			item.setThcontent(thcontent[i]);
			// 保存到数据库中
			ThemeItemService.save_ThemeItem(item);
			// 添加到set集合中
			itme.add(item);
		}
	
		// 以下为判断是否登陆操作
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
		theme.setUsers(UsersService.get_usersByName(username));
		theme.setTcontent(tcontent);
		// 把单项加到 主题中
		theme.setThemeitem(itme);
		theme.setLoved(0);
		// 保存到数据库中
		ThemeService.save_Theme(theme);
		
		return "redirect:/theme.action";
	}
	
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/addtheme")
	public String addtheme(Model model){
		
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
		// 分类
		List<Classify> classifys = ClassifyService.list_Classify();
		model.addAttribute("classifies", classifys);
		//所有书籍
		model.addAttribute("books", books);
		return "../../book_store/addtheme";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/theme")
	public String theme(Model model){
		
		List<Theme> themes = ThemeService.list_Theme();
		model.addAttribute("themes", themes);
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
		// 分类
		List<Classify> classifys = ClassifyService.list_Classify();
		model.addAttribute("classifies", classifys);
		
		return "../../book_store/theme";
	}

}
