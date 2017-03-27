package com.netStore.pojo;

import java.io.Serializable;
import java.util.Set;

public class OrderItem implements Serializable{

	
	private long oiid;
	private String num; // 书的数量
	private float money;// 书的单计
	// many2one
	private Book book;
	// many2one
	private Orders orders;
	
	public long getOiid() {
		return oiid;
	}
	public void setOiid(long oiid) {
		this.oiid = oiid;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	

	
	
}
