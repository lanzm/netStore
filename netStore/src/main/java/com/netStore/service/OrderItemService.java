package com.netStore.service;

import java.io.Serializable;
import java.util.List;

import com.netStore.pojo.OrderItem;
import com.netStore.pojo.Orders;

public interface OrderItemService {
	
	void save_orderItem(OrderItem orderItem);
	void remove_orderItem(Serializable id);
	void update_orderItem(OrderItem orderItem);
	OrderItem get_orderItemById(Serializable id);
	List<OrderItem> list_orderItem();

}
