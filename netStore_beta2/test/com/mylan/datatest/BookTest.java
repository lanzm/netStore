package com.mylan.datatest;

import java.util.List;

import org.junit.Test;

import com.mylan.dao.BookDao;
import com.mylan.dao.impl.BookDaoImpl;
import com.mylan.domain.Book;
import com.mylan.domain.Classify;
import com.mylan.service.BookService;
import com.mylan.service.impl.BookServiceImpl;

public class BookTest {

	@Test
	public void addbookTest(){
		
		BookDao bd= new BookDaoImpl();
		Book bk = new Book();
		Classify cf = new Classify();
		cf.setId("7");
		
		bk.setId("2");
		bk.setName("jsp");
		bk.setAuthor("aa");
		bk.setDescription("111");
		bk.setPath("/1/2");
		bk.setFilename("ooo");
		bk.setPrice(100f);
		//bk.setClassify_id(cf);
		bd.addBook(bk);
	}
	
	@Test
	public void listbookServiceTest(){
		
		BookService bs = new BookServiceImpl();
		List<Book> list = bs.getAllBooks();
		for (Book book : list) {
			System.out.println(book.getName());
		}
		
	}
	@Test
	public void listbookDaoTest(){
		
		BookDao bd = new BookDaoImpl();
		List<Book> list = bd.listAllBooks();
		for (Book book : list) {
			System.out.println(book.getName());
		}
		
	}
}
