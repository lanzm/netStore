package com.mylan.dao;

import java.util.List;

import com.mylan.domain.Book;

public interface BookDao {

	List<Book> listAllBooks();
	
	boolean addBook(Book book);
	/**
	 * 
	 * @return 返回书的数量
	 */
	int countBook();
	/**
	 * 
	 * @param startPage 页面开始的id
	 * @param pagesize  一页显示多少
	 * @return
	 */
	List<Book> findBookPage(int startPage,int pagesize);
}
