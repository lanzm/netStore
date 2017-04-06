package com.netStore.pojo;

import java.io.Serializable;

public class ThemeItem implements Serializable{

	private long thid; // 主题下的单项书籍
	// many2one
	private Book book; // 书籍 
	private String thcontent; // 书籍描述内容 
	// many2one
	private Theme theme; // 归在什么主题下 
	
	public long getThid() {
		return thid;
	}
	public void setThid(long thid) {
		this.thid = thid;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getThcontent() {
		return thcontent;
	}
	public void setThcontent(String thcontent) {
		this.thcontent = thcontent;
	}
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	
	
	
}
