package com.netStore.utils;

import java.util.List;

import com.netStore.pojo.Book;

public class Page {
	
	private int totalPage; // 总的页数
	private int thisPage; //当前页数
	private int previousPage; // 上一页
	private int nextPage; // 下一页
	private int startIndex; // 每页开始的索引
	private int pageSize ; // 一页显示多少行
	private int totalPagesize; // 总的数据有多少
	private List<Book> books; // 书籍
	
	/**
	 *  把当前页码和总的记录条数传进来
	 * @param thisPage 当前页码
	 * @param totalPagesize 总的记录条数
	 * @param pageSize 一页显示多少行
	 */
	public Page(int pageSize,int thisPage, int totalPagesize){
		this.pageSize = pageSize;
		this.thisPage = thisPage;
		this.totalPagesize = totalPagesize;
		
		//计算总页码
		//总数据和一页显示多少取余，没有余数则正正好，有余数多加一页
		totalPage = totalPagesize % pageSize == 0 ? totalPagesize / pageSize : ( totalPagesize / pageSize + 1 ); 
		//计算开始记录的索引
		startIndex = ( thisPage - 1) * pageSize; //当前页码减一 × 一页显示多少
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getThisPage() {
		return thisPage;
	}
	public void setThisPage(int thisPage) {
		this.thisPage = thisPage;
	}
	public int getPreviousPage() {
		int prePage = thisPage -1 ;
		if(prePage < 1){
			return 1;
		}
		return prePage;
	}
	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}
	public int getNextPage() {
		int nexPage = thisPage +1;
		if(nexPage > totalPage){
			return nexPage = totalPage;
		}
		return nexPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getTotalPagesize() {
		return totalPagesize;
	}
	public void setTotalPagesize(int totalPagesize) {
		this.totalPagesize = totalPagesize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	

	
	
}
