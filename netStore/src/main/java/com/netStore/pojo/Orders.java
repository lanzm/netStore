package com.netStore.pojo;

import java.io.Serializable;
import java.util.Set;

public class Orders implements Serializable{

	private String oid;
	private String status; //订单状态   0未付款 1已付款 2已发货
	private float totalmoney;
	private String totalnum;
	// many2one
	private Users users;
	// one2many
	private Set<OrderItem> orderitem;
	
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
	
	public float getTotalmoney() {
		return totalmoney;
	}
	public void setTotalmoney(float totalmoney) {
		this.totalmoney = totalmoney;
	}
	public String getTotalnum() {
		return totalnum;
	}
	public void setTotalnum(String totalnum) {
		this.totalnum = totalnum;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Set<OrderItem> getOrderitem() {
		return orderitem;
	}
	public void setOrderitem(Set<OrderItem> orderitem) {
		this.orderitem = orderitem;
	}
		
	
	
	
}
