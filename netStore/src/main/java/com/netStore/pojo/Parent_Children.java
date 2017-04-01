package com.netStore.pojo;

import java.io.Serializable;

public class Parent_Children implements Serializable{

	private long pid;
	private long parent_cid;
	private long children_cid;
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public long getParent_cid() {
		return parent_cid;
	}
	public void setParent_cid(long parent_cid) {
		this.parent_cid = parent_cid;
	}
	public long getChildren_cid() {
		return children_cid;
	}
	public void setChildren_cid(long children_cid) {
		this.children_cid = children_cid;
	}
	
	
}
