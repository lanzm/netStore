package com.netStore.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Orders implements Serializable{

	private String oid;
	private String status; //订单状态   0未付款 1已付款 2已发货
	private float money;
	private Users users;
	private Set<Book> book;
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Set<Book> getBook() {
		return book;
	}
	public void setBook(Set<Book> book) {
		this.book = book;
	}
	
	
	
	
}
