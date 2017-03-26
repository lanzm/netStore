package com.netStore.service;

import java.io.Serializable;
import java.util.List;
import com.netStore.pojo.Orders;

public interface OrderService {
	
	void save_order(Orders order);
	void remove_order(Serializable id);
	void update_order(Orders order);
	Orders get_orderById(Serializable id);
	List<Orders> list_order();

}
