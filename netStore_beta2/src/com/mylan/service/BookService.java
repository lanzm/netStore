package com.mylan.service;

import java.util.List;

import com.mylan.domain.Book;
import com.mylan.utils.Page;

public interface BookService {

	List<Book> getAllBooks();
	
	boolean addbook(Book book);
	/**
	 * 
	 * @param num 用户要看的页面
	 * @return 返回page
	 */
	Page findBookPage(String pagesize,String num);
}
