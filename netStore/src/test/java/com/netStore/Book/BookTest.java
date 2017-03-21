package com.netStore.Book;

import java.util.List;

import org.junit.Test;

import com.netStore.dao.BookDao;
import com.netStore.pojo.Book;
import com.netStore.utils.BaseSpring;

public class BookTest extends BaseSpring{

	@Test
	public void listBookTest(){
		
		BookDao bookDao = (BookDao) context.getBean("BookDao");
		List<Book> lists = bookDao.list();
		for (Book book : lists) {
			System.out.println(book.getBookname());
		}
		
	}
	
	@Test
	public void addBookTest(){
		
		BookDao bookDao = (BookDao) context.getBean("BookDao");
		Book book = new Book();
		book.setBid(6);
		book.setBookname("aa");
		bookDao.save(book);
		
	}
	
}
