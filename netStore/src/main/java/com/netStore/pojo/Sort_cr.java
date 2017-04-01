package com.netStore.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 这个类是用来封装 用户第一次评论和回复的类，以便根据需要排序
 * @author L an
 *
 */
public class Sort_cr implements Serializable{

	private long sid;
	private String content;
	private Date time;
	private int praise;  // 评论的赞
	private Users users; // 评论者
	private Book book; // 对应书籍
	private List<Comment> reply; // 
	private int type; // 评论 为0， 回复 为1
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getPraise() {
		return praise;
	}
	public void setPraise(int praise) {
		this.praise = praise;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public List<Comment> getReply() {
		return reply;
	}
	public void setReply(List<Comment> reply) {
		this.reply = reply;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	
	
	
}
