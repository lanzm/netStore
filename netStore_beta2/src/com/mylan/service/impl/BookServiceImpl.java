package com.mylan.service.impl;

import java.util.List;

import com.mylan.dao.BookDao;
import com.mylan.dao.impl.BookDaoImpl;
import com.mylan.domain.Book;
import com.mylan.service.BookService;
import com.mylan.utils.Page;

public class BookServiceImpl implements BookService{

	private BookDao bd = new BookDaoImpl();
	
	@Override
	public List<Book> getAllBooks() {
		return bd.listAllBooks();
	}

	@Override
	public boolean addbook(Book book) {
		return bd.addBook(book);
	}

	@Override
	public Page findBookPage(String pagesize,String num) {
		int thisPage = 1;
		int pages = 5;
		if(num != null && !"".equals(num)){
			thisPage = Integer.parseInt(num);
		}
		if(pagesize != null && !"".equals(pagesize)){
			pages = Integer.parseInt(pagesize);
		}
		int totalPagesize = bd.countBook();
		Page page = new Page(thisPage, totalPagesize);
		page.setPagesize(pages);
		List<Book> books = bd.findBookPage(page.getStartIndex(), page.getPagesize());
		page.setBooks(books);
		return page;
	}
	
	

}
