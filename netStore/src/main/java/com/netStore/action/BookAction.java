package com.netStore.action;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.netStore.pojo.Book;
import com.netStore.pojo.Classify;
import com.netStore.service.BookService;
import com.netStore.service.ClassifyService;
import com.netStore.utils.Page;
import com.netStore.utils.Random;

@Controller
@RequestMapping("/manager")
public class BookAction {
	//自动注入 
	@Autowired
	public BookService BookService;

	@Autowired
	public ClassifyService ClassifyService;
	
	//用户输入页码的初始值
	int msg = 1;
	List<Book> books = null;
	/**
	 * 查询图书
	 * @param model
	 * @return
	 */
	@RequestMapping("/listBook")
	public String listBook(Model model){
		// 用户页面
		Page page = BookService.pageBook(3, msg);
		// 得到查询出来的 书籍
		List<Book> lists = page.getBooks();
		// 当 搜索的书籍为空时
		if(this.books != null){
			page.setBooks(books);
			page.setTotalPage(1);
			model.addAttribute("lists", books);
			this.books = null;
			// 传到网页
			model.addAttribute("page", page);
		}else{
			model.addAttribute("lists", lists);
			model.addAttribute("page", page);
		}
		return "book";
	}
	
	/**
	 *  关键字搜索方法
	 * @param vague 网页传入的关键字
	 * @return 返回listbook页面
	 * @throws Exception 抛出空异常
	 */
	@RequestMapping("/vagueBook")
	public String vagueBook(String vague) throws Exception{
		// 乱码解决方法
		String vag = new String(vague.getBytes("iso-8859-1"), "UTF-8");
		// 把传入的值 查询出 book集合
		List<Book> lists = BookService.get_BookByVague(vag);
		if(!vag.isEmpty()){
			// 放到全局变量中
			this.books = lists;
		}
		return "redirect:/manager/listBook.action";
		
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
		
		return "redirect:/manager/listBook.action";
		
	}
	
	/**
	 * 删除图书
	 * @return
	 */
	@RequestMapping("/removeBook/{bid}")
	public String removeBook(@PathVariable long bid){
		
		System.out.println(bid);
		//BookService.remove_Book(bid);
		
		return "book";
		
	}
	
	/**
	 * 更新书籍前 先查出选择修改的书籍
	 * @param bid 从网页端传来的id值
	 * @param model 向页面传值
	 * @return
	 */
	@RequestMapping("/updateBook_bf/{bid}")
	public String updateBook_bf(@PathVariable long bid,Model model){
		// bid 为页面传来的选中id值
		Book book = BookService.get_BookById(bid);
		List<Classify> lists = ClassifyService.list_Classify();
		model.addAttribute("book", book);
		model.addAttribute("classifys", lists);
		
		return "updatebook";
		
	}
	
	/**
	 * 更新书籍
	 * @param classifyn 特地接收分类数据
	 * @param book 对应的书籍数据
	 * @return
	 */
	@RequestMapping("/updateBook")
	public String updateBook(String classifyn,Book book){
		System.out.println(classifyn);
		System.out.println(book.getBookname());
		System.out.println(book.getDescription());
		//BookService.update_Book(book);
		return "redirect:/manager/listBook.action";
		
	}
	/**
	 * 添加书籍前先查出分类，将分类信息传到网页
	 * @param model
	 * @return 添加书籍页面
	 */
	@RequestMapping("/addBook_bf")
	public String addBook_bf(Model model){
		
		List<Classify> lists = ClassifyService.list_Classify();
		model.addAttribute("classifys", lists);
		
		return "addbook";
		
	}
	
	/**
	 *  添加书籍
	 * @param book 接收书籍
	 * @param request 接收图片
	 * @param classifyn 特别接收分类
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addBook")
	public String addBook(Book book,HttpServletRequest request,String classifyn) throws Exception{
		MultipartHttpServletRequest servletRequest = (MultipartHttpServletRequest) request;
		// 得到 图片对象
		MultipartFile image = servletRequest.getFile("image");
		// 图片存储路径
		String realPath = "G:/For Jee/eclipse/Program/netStore/src/main/webapp/book_store/images/myimages";
		File savePath = new File(realPath);
		// 如果存储路径不存在
		if(!savePath.exists()){
			savePath.mkdirs();
		}
		// 图片名称
		String filename = image.getOriginalFilename();
		Random random = new Random();
		String photo = random.genGUID();
		if(filename != null){
			filename = photo + "." + FilenameUtils.getExtension(filename);
		}
		// 图片 数据流
		InputStream ins = image.getInputStream();
		// 保存图片名字
		book.setFilename(filename);
		//获取 从选择中的分类
		Classify classify = ClassifyService.get_ClassifyByName(classifyn);
		book.setClassify(classify);
		// 把现在的时间 存入数据库
		book.setAddtime(new Date());
		// 将book存入数据库
		BookService.save_Book(book);
		// 存储 图片
		saveimage(ins,filename,savePath.toString());
		
		return "redirect:/manager/listBook.action";
		
	}
	/**
	 *  图片存储方法
	 * @param ins 图片数据流
	 * @param filename 图片名称
	 * @param path 图片存储路径
	 * @throws IOException
	 */
	private void saveimage(InputStream ins, String filename, String path) throws IOException{
		
		FileOutputStream fs=new FileOutputStream( path + "/"+ filename);
        byte[] buffer =new byte[1024*1024];
        int bytesum = 0;
        int byteread = 0;
        while ((byteread=ins.read(buffer))!=-1)
        {
            bytesum+=byteread;
            fs.write(buffer,0,byteread);
            fs.flush();
        }
        // 把流关掉
        fs.close();
        ins.close();
		
	}
	

}
