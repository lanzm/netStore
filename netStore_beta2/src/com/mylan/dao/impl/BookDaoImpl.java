package com.mylan.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mylan.dao.BookDao;
import com.mylan.domain.Book;
import com.mylan.domain.Classify;
import com.mylan.utils.DBCPUtils;

public class BookDaoImpl implements BookDao{

	private QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
	
	@Override
	public List<Book> listAllBooks() {
		
		try {
			List<Book> books = qr.query("select id,name,author,price,path,filename,description from book", new BeanListHandler<Book>(Book.class));
			for (Book book : books) {
				Classify cf = qr.query("select * from classify where id=(select classify_id from book where id=?)", new BeanHandler<Classify>(Classify.class),book.getId());
				book.setClassify_id(cf);
			}
			return books;
		} catch (SQLException e) {
			System.out.println("书籍查询出错");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addBook(Book book) {
		try {
			qr.update("insert into book(id,name,author,price,path,filename,description,classify_id) values(?,?,?,?,?,?,?,?)", book.getId(),book.getName(),book.getAuthor(),book.getPrice(),book.getPath(),book.getFilename(),book.getDescription(),book.getClassify_id().getId());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int countBook() {
		try {
			Object obj = qr.query("select count(id) from book", new ScalarHandler(1));
			Long num = (long)obj;
			return num.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Book> findBookPage(int startPage, int pagesize) {
		List<Book> books;
		try {
			books = qr.query("select id,name,author,price,path,filename,description from book limit ?,?", new BeanListHandler<Book>(Book.class),startPage,pagesize);
			for (Book book : books) {
				Classify cf = qr.query("select * from classify where id=(select classify_id from book where id=?)", new BeanHandler<Classify>(Classify.class),book.getId());
				book.setClassify_id(cf);
			}
			return books;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

}
