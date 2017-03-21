package com.netStore.dao.impl;

import org.springframework.stereotype.Repository;

import com.netStore.dao.BookDao;
import com.netStore.pojo.Book;

@Repository("BookDao")
public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao<Book>{

	
}
