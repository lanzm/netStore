package com.netStore.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Book implements Serializable{
	
	private long bid;  // 书籍主键
	private String bookname; // 书籍名字
	private String author; // 作者
	private float price; // 价格
	private String filename;//更改后的唯一文件名
	private String description; // 书籍描述
	private Date addtime;  // 书籍加入时间
	private boolean promotions; // 书籍是否做促销
	// many2one
	private Classify classify; // 书籍分类
	//one2many
	private Set<Comment> comment; // 书籍评论
	// one2many
	private Set<Reply> reply; // 书籍回复
	
	public Classify getClassify() {
		return classify;
	}
	public void setClassify(Classify classify) {
		this.classify = classify;
	}
	
	public long getBid() {
		return bid;
	}
	public void setBid(long bid) {
		this.bid = bid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public boolean isPromotions() {
		return promotions;
	}
	public void setPromotions(boolean promotions) {
		this.promotions = promotions;
	}
	public Set<Comment> getComment() {
		return comment;
	}
	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}
	public Set<Reply> getReply() {
		return reply;
	}
	public void setReply(Set<Reply> reply) {
		this.reply = reply;
	}
	
	

	
	
	

}
