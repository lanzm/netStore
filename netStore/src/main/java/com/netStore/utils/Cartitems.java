package com.netStore.utils;

import java.io.Serializable;

import com.netStore.pojo.Book;

// 单项订单
public class Cartitems implements Serializable{
	
	private Book book; 
	private int totalbook; // 单项订单书籍总数
	private float money; //  单项订单书籍金额
	public Cartitems(Book book){
		this.book = book;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	public int getTotalbook() {
		return totalbook;
	}
	public void setTotalbook(int totalbook) {
		this.totalbook = totalbook;
	}
	public float getMoney() {
		// 金额等于 书籍的单价乘 数量
		return book.getPrice()*totalbook;
	}

	
	

}
