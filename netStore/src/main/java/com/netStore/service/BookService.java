package com.netStore.service;

import java.io.Serializable;
import java.util.List;

import com.netStore.pojo.Book;
import com.netStore.pojo.Manager;
import com.netStore.utils.Page;

public interface BookService {
	
	void save_Book(Book book);
	void remove_Book(Serializable id);
	void update_Book(Book book);
	Book get_BookById(Serializable id);
	List<Book> list_Book();
	/**
	 *  分页方法
	 * @param pageSize 一页显示多少行
	 * @param num	用户点击的页数
	 * @return 页面持久层
	 */
	Page pageBook(int pageSize,int num);
	/**
	 * 模糊查询
	 * @param vague 关键字
	 * @return 返回书籍集合
	 */
	List<Book> get_BookByVague(String vague);
	/**
	 * 是否促销
	 * @return 返回书籍集合
	 */
	List<Book> get_BookPromotions();
	/**
	 * 分类查询书籍
	 * @param cid 分类id
	 * @return 书籍集合
	 */
	List<Book> get_BookByClassify(long cid);
	
	/**
	 * 通过书籍名称查询得到书籍
	 * @param bookname书籍名称
	 * @return返回书籍
	 */
	Book get_BookByName(String bookname);

}
