package com.mylan.control;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.mylan.domain.Book;
import com.mylan.domain.Classify;
import com.mylan.service.BookService;
import com.mylan.service.ClassifyService;
import com.mylan.service.impl.BookServiceImpl;
import com.mylan.service.impl.ClassifyServiceImpl;
import com.mylan.utils.IdGenertor;
import com.mylan.utils.Page;

/**
 * Servlet implementation class ManagerControl
 */
@WebServlet("/ManagerControl")
public class ManagerControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ClassifyService classifyService = new ClassifyServiceImpl(); 
	private BookService bookService = new BookServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if("listClassify".equals(op)){
			listClassify(request,response);
		}else if("addClassify".equals(op)){
			addClassify(request,response);
		}else if("listbooks".equals(op)){
			listbooks(request,response);
		}else if("findclassifyonbook".equals(op)){
			listClassifyandshowbooksjsp(request,response);
		}else if("addbooks".equals(op)){
			addbooks(request,response);
		}
		
	}

	
	

	//添加图书
	private void addbooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//判断表单是不是multiparty/form-data类型
		boolean isMultiparty = ServletFileUpload.isMultipartContent(request);
		if(!isMultiparty){
			throw new RuntimeException("the form is not multiparty");
		}

		//解析请求内容
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		List<FileItem> items = new ArrayList<FileItem>();
		try{
			items = sfu.parseRequest(request);
		}catch(Exception e){
			e.printStackTrace();
		}
		Book book = new Book(); // 空对象
		for(FileItem item:items){
			//判断是否 是上传文件还是普通字段
			if(item.isFormField()){
				processFormFiled(item,book);
			}else{
				processUploadFiled(item,book);
			}
		}

		//单独 设置 book 的id 
		book.setId(IdGenertor.genGUID());
		
		
		bookService.addbook(book);
		response.sendRedirect(request.getContextPath()+"/manager/index.jsp");
	}
	
	// 处理普通字段
	private void processFormFiled(FileItem item, Book book) {
		try {
			String fieldName = item.getFieldName();//name
			String fieldValue = item.getString("UTF-8");//jpm
			//BeanUtils.setProperty(book, fieldName, fieldValue);
			if("name".equals(fieldName)){
				book.setName(fieldValue);
			}
			if("author".equals(fieldName)){
				book.setAuthor(fieldValue);
			}
			if("description".equals(fieldName)){
				book.setDescription(fieldValue);
			}
			//单独处理书籍所属的分类
			if("classify".equals(fieldName)){
				Classify c = classifyService.getClassifyByName(fieldValue); 
				book.setClassify_id(c);
			}
			if("price".equals(fieldName)){
				float price = Float.parseFloat(fieldValue);//String 转 float 
				book.setPrice(price);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	//处理 文件上传
	private void processUploadFiled(FileItem item, Book book) {
		//存放路径： 不要放在WEB-INF中
		String storeDirectory = getServletContext().getRealPath("/images");
		File rootDirectory = new File(storeDirectory);
		if(!rootDirectory.exists()){
			rootDirectory.mkdirs();
		}
		//设置 文件名
		String filename = item.getName(); // a.jpg
		if(filename != null){
			filename = IdGenertor.genGUID() + "." + FilenameUtils.getExtension(filename);//LKDSJFLKSFKS.jpg
			book.setFilename(filename);
		}
		//计算子目录
		String path = genChildDirectory(storeDirectory,filename);
		book.setPath(path);
		//文件上传
		try{
			item.write(new File(rootDirectory,path+"/"+filename));
		}catch(Exception e){
			throw new RuntimeException("file faild");
		}
	}
	//计算子目录
	private String genChildDirectory(String storeDirectory, String filename) {
		int hashCode = filename.hashCode();
		int dir1 = hashCode&0xf;
		int dir2 = (hashCode&0xf0)>>4;
		
		//String str = dir1+File.separator+dir2;
		String str = dir1+"/"+dir2;
		
		File file = new File(storeDirectory,str);
		if(!file.exists()){
			file.mkdirs();
		}
		
		return str;
	}

	//查询图书
	private void listbooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		String pagesize = request.getParameter("pagesize");
		
		Page page = bookService.findBookPage(pagesize,num);
		request.setAttribute("page", page);
		page.setUrl("/ManagerControl?op=listbooks");
		request.getRequestDispatcher("/manager/listbook.jsp").forward(request, response);

	}
	
	//展示分类选项
	private void listClassifyandshowbooksjsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//将分类查询出来
		List<Classify> list = classifyService.getAllClassify();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/manager/addbook.jsp").forward(request, response);
		
	}

	//添加分类
	private void addClassify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		Classify classify = new Classify();
		classify.setName(name);
		classify.setDescription(description);
		classify.setId(IdGenertor.genGUID());
		classifyService.addClassify(classify);
		response.sendRedirect(request.getContextPath()+"/manager/index.jsp");
		
	}

	//查询分类
	private void listClassify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Classify> list = classifyService.getAllClassify();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/manager/listClassify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
