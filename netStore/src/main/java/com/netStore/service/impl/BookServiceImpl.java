package com.netStore.service.impl;

import java.io.Serializable;
import java.util.List;
import com.netStore.dao.BookDao;
import com.netStore.pojo.Book;
import com.netStore.service.BookService;

public class BookServiceImpl implements BookService{
	
	
	public BookDao bookDao;
	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public void save_Book(Book book) {
		
		bookDao.save(book);
		
	}

	@Override
	public void remove_Book(Serializable id) {
		
		bookDao.remove(id);
		
	}

	@Override
	public void update_Book(Book book) {
		
		bookDao.update(book);
		
	}

	@Override
	public Book get_BookById(Serializable id) {
		
		return (Book) bookDao.getById(id);
		
	}

	@Override
	public List<Book> list_Book() {
		
		return bookDao.list();
		
	}



}
