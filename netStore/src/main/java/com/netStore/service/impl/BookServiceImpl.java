package com.netStore.service.impl;

import java.io.Serializable;
import java.util.List;
import com.netStore.dao.BookDao;
import com.netStore.pojo.Book;
import com.netStore.service.BookService;
import com.netStore.utils.Page;

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

	@Override
	public Page pageBook(int pageSize, int num) {
		// 总的书籍记录有多少条
		int totalPagesize = (int) bookDao.countBook();
		System.out.println(totalPagesize);
		// 把当前页码和总的记录条数传进来
		Page page = new Page(pageSize , num , totalPagesize);
		// 把查询出来的书籍存到page持久
		List<Book> list =bookDao.pageBook(page.getStartIndex(), pageSize);
		page.setBooks(list);
		return page;
	}

	@Override
	public List<Book> get_BookByVague(String vague) {
		
		return bookDao.getBookVague(vague);
		
	}

	



}
