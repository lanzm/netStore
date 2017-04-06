package com.netStore.pojo;

import java.io.Serializable;
import java.util.Set;

public class Theme implements Serializable{
	// 主题
	private long tid;
	private String tcontent;// 主题内容
	private int loved; // 主题的喜爱度
	// many2one
	private Users users; // 发表主题的人是谁
	// one2many
	private Set<ThemeItem> themeitem; // 主题下的各种书籍描述
	public long getTid() {
		return tid;
	}
	public void setTid(long tid) {
		this.tid = tid;
	}
	public String getTcontent() {
		return tcontent;
	}
	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}
	public int getLoved() {
		return loved;
	}
	public void setLoved(int loved) {
		this.loved = loved;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Set<ThemeItem> getThemeitem() {
		return themeitem;
	}
	public void setThemeitem(Set<ThemeItem> themeitem) {
		this.themeitem = themeitem;
	}

	
	
}
