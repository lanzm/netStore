package com.mylan.datatest;

import java.util.List;

import org.junit.Test;

import com.mylan.dao.BookDao;
import com.mylan.dao.impl.BookDaoImpl;
import com.mylan.domain.Book;
import com.mylan.service.BookService;
import com.mylan.service.impl.BookServiceImpl;
import com.mylan.utils.Page;

public class PageTest {
	
	@Test
	public void countbookTest(){
		
		BookDao bd = new BookDaoImpl();
		System.out.println(bd.countBook());
		
	}
	@Test
	public void findbookPageDaoTest(){
		
		BookDao bd = new BookDaoImpl();
		List<Book> books = bd.findBookPage(0, 3);
		for (Book book : books) {
			System.out.println(book.getName());
		}
		
	}

	@Test
	public void findbookPageServiceTest(){
		
		BookService bs = new BookServiceImpl();
		Page page = bs.findBookPage("1","3");
		List<Book> list = page.getBooks();
		for (Book book : list) {
			System.out.println(book.getName());
		}
		
		
		
		
	}
	
}
