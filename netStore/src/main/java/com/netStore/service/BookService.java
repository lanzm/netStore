package com.netStore.service;

import java.io.Serializable;
import java.util.List;

import com.netStore.pojo.Book;
import com.netStore.pojo.Manager;

public interface BookService {
	
	void save_Book(Book book);
	void remove_Book(Serializable id);
	void update_Book(Book book);
	Book get_BookById(Serializable id);
	List<Book> list_Book();

}
