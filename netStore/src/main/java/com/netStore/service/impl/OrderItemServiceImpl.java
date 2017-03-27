package com.netStore.service.impl;

import java.io.Serializable;
import java.util.List;
import com.netStore.dao.OrderItemDao;
import com.netStore.pojo.OrderItem;
import com.netStore.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService{
	
	
	public OrderItemDao OrderItemDao;
	public OrderItemDao getOrderItemDao() {
		return OrderItemDao;
	}

	public void setOrderItemDao(OrderItemDao orderItemDao) {
		OrderItemDao = orderItemDao;
	}

	@Override
	public void save_orderItem(OrderItem orderItem) {
		
		this.OrderItemDao.save(orderItem);
		
	}

	@Override
	public void remove_orderItem(Serializable id) {

		this.OrderItemDao.remove(id);
		
	}

	@Override
	public void update_orderItem(OrderItem orderItem) {

		this.OrderItemDao.update(orderItem);
		
	}

	@Override
	public OrderItem get_orderItemById(Serializable id) {
		
		return (OrderItem) this.OrderItemDao.getById(id);
		
	}

	@Override
	public List<OrderItem> list_orderItem() {

		return this.OrderItemDao.list();
		
	}
	
	


}
