package com.netStore.pojo;

import java.io.Serializable;
import java.util.Date;

public class Reply implements Serializable{

	private long rid; // 主键
	private String r_content; // 回复内容
	private int r_praise;  // 回复的赞
	private Date r_time; // 回复时间
	// many2one
	private Book book; // 对应书籍
	// many2one
	private Users users; // 评论者
	// many2one
	private Comment comment; // 一个评论可以有很多回复
	
	public long getRid() {
		return rid;
	}
	public void setRid(long rid) {
		this.rid = rid;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public int getR_praise() {
		return r_praise;
	}
	public void setR_praise(int r_praise) {
		this.r_praise = r_praise;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public Date getR_time() {
		return r_time;
	}
	public void setR_time(Date r_time) {
		this.r_time = r_time;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	
	
	
}
