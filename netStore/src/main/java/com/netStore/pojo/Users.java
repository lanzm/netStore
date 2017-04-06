package com.netStore.pojo;

import java.io.Serializable;
import java.util.Set;

public class Users implements Serializable{
	
	private long uid;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String company;
	private String address;
	// one2many
	private Set<Orders> orders; // 用户订单
	// one2many
	private Set<Comment> comment; // 书籍详情的评论
	// one2many
	private Set<Theme> theme; // 用户发表的主题
	
	public Set<Theme> getTheme() {
		return theme;
	}
	public void setTheme(Set<Theme> theme) {
		this.theme = theme;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	public Set<Comment> getComment() {
		return comment;
	}
	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}
	
	
	

}
