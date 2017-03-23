package com.netStore.dao.impl;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.netStore.dao.BookDao;
import com.netStore.pojo.Book;

@Repository("BookDao")
public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao<Book>{

	@Override
	public long countBook() {
		long count = (long) this.getHibernateTemplate().find("select count(*) from Book").listIterator().next();
		return count;
	}

	@Override
	public List<Book> pageBook(final int startPage, final int pageSize) {
		
		return (List<Book>) super.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public List doInHibernate(Session session) throws HibernateException, SQLException {
						Query query = session.createQuery("from Book");
						// 设置 开始 位置
						query.setFirstResult(startPage);
						// 设置 显示几条数据
						query.setMaxResults(pageSize);
						List lists = query.list();
						return lists;
					}
					
		});
	}

	@Override
	public List<Book> getBookVague(String vague) {
		List<Book> books = (List<Book>) this.getHibernateTemplate().find(" from Book where bookname like '%" + vague +"%' or description like '%" + vague +"%' or author like '%" + vague + "%' ");
		//List<Book> books = (List<Book>) this.getHibernateTemplate().find(" from Book where bookname like '%" + vague +"%' ");
		return books;
	}

	@Override
	public List<Book> getPromotions() {
		List<Book> books = (List<Book>) this.getHibernateTemplate().find(" from Book where promotions = true ");
		return books;
	}
	
	

	
	
	
}
