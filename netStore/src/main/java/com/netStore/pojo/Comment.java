package com.netStore.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Comment implements Serializable{

	private long cid; // 主键
	private int type;  // 评论类型   评论为 0  回复为 1
	private String content; // 评论内容
	private Date time; // 评论时间
	private int praise;  // 评论的赞
	// many2one
	private Users users; // 评论者
	// many2one
	private Book book; // 对应书籍

	
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public int getPraise() {
		return praise;
	}
	public void setPraise(int praise) {
		this.praise = praise;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

	
	
}
