package com.netStore.dao;

import java.util.List;

public interface BookDao<T> extends BaseDao<T>{
	
	/**
	 *  数据库记录数
	 * @return 返回记录count
	 */
	public long countBook();
	
	/**
	 * 分页
	 * @param startPage 开始页码
	 * @param pageSize  一页显示多少
	 * @return 返回书籍集合
	 */
	public List<T> pageBook(int startPage, int pageSize);
	/**
	 * 模糊查询
	 * @param vague 关键字
	 * @return 返回book数组
	 */
	public List<T> getBookVague(String vague);
	/**
	 * 书籍是否做促销
	 * @return 返回促销书籍
	 */
	public List<T> getPromotions();

}
