package com.netStore.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.netStore.pojo.Book;

public class Cart implements Serializable{
	// map<书籍的id， 单项书籍信息>
	private Map<Long, Cartitems> items = new HashMap<Long, Cartitems>();
	private float totalmoney; // 总金额
	private int totalnum; // 总金额
	
	public Map<Long, Cartitems> getItems() {
		return items;
	}
	public void setItems(Map<Long, Cartitems> items) {
		this.items = items;
	}
	public float getTotalmoney() {
		// 初始化 金额
		totalmoney = 0;
		// 遍历 单项中的金额
		for (Map.Entry<Long, Cartitems> item : items.entrySet()) {
			totalmoney += item.getValue().getMoney();
		}
		return totalmoney;
	}
	public void setTotalmoney(float totalmoney) {
		this.totalmoney = totalmoney;
	}
	public int getTotalnum() {
		totalnum = 0;
		for(Map.Entry<Long , Cartitems> item : items.entrySet()){
			totalnum += item.getValue().getTotalbook();
		}
		return totalnum;
	}
	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}
	
	// 删除一整行
	public void romitem(Book book){
		
		items.remove(book.getBid());
		
	}
	
	// 删一本书
	public void delitem(Book book){
		// 取出 书籍
		Cartitems cartitems = items.get(book.getBid());
		// 当书籍数量为1 时 ，
		if(cartitems.getTotalbook() == 1){
			cartitems.setTotalbook(1);
		}else{
			cartitems.setTotalbook(cartitems.getTotalbook() - 1);
		}
		
	}
	// 加一本书
	public void additem(Book book){
		// 如果已经存在在购物车中
		if(items.containsKey(book.getBid())){
			// 取出其单项
			Cartitems cartitems = items.get(book.getBid());
			// 数量加一
			cartitems.setTotalbook(cartitems.getTotalbook() + 1);
			
		}else{
			// 新建一个 单项
			Cartitems item = new Cartitems(book);
			// 数量为一
			item.setTotalbook(1);
			// 放到 map数组中
			items.put(book.getBid(), item);
			
		}
		
	}
	

}
