package com.mylan.utils;

import java.util.List;

public class Page {

	private List books;
	
	private int totalPage; //总页数
	private int thisPage; //当前页数
	private int previousPage; //上一页
	private int nextPage;  //下一页
	private int startIndex; //每页开始的索引是多少
	private int pagesize = 5; //一页显示多少
	private int totalPagesize ; //总的数据有多少
	private String url; //查询分页的地址
	
	
	public Page(int thisPage,int totalPagesize){
		this.thisPage = thisPage;
		this.totalPagesize = totalPagesize;
		
		//计算总页码
		//总数据和一页显示多少取余，没有余数则正正好，有余数多加一页
		totalPage = totalPagesize%pagesize==0?totalPagesize/pagesize:(totalPagesize/pagesize+1); 
		//计算开始记录的索引
		startIndex = (thisPage-1)*pagesize; //当前页码减一 × 一页显示多少
	}
	
	public Page(int pagesize,int thisPage,int totalPagesize){
		this.pagesize = pagesize;
		this.thisPage = thisPage;
		this.totalPagesize = totalPagesize;
		
		//计算总页码
		//总数据和一页显示多少取余，没有余数则正正好，有余数多加一页
		totalPage = totalPagesize%pagesize==0?totalPagesize/pagesize:(totalPagesize/pagesize+1); 
		//计算开始记录的索引
		startIndex = (thisPage-1)*pagesize; //当前页码减一 × 一页显示多少
	}
	
	public List getBooks() {
		return books;
	}


	public void setBooks(List books) {
		this.books = books;
	}


	

	public int getStartIndex() {
		return startIndex;
	}



	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
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
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotalPagesize() {
		return totalPagesize;
	}
	public void setTotalPagesize(int totalPagesize) {
		this.totalPagesize = totalPagesize;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
