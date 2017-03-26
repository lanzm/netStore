package com.netStore.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.netStore.dao.OrderDao;
import com.netStore.dao.UsersDao;
import com.netStore.dao.impl.UsersDaoImpl;
import com.netStore.pojo.Orders;
import com.netStore.pojo.Users;
import com.netStore.service.OrderService;
import com.netStore.service.UsersService;

public class OrderServiceImpl implements OrderService{
	
	
	public OrderDao OrderDao;
	public OrderDao getOrderDao() {
		return OrderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		OrderDao = orderDao;
	}

	@Override
	public void save_order(Orders order) {
		
		OrderDao.save(order);
		
	}

	@Override
	public void remove_order(Serializable id) {

		OrderDao.remove(id);
		
	}

	@Override
	public void update_order(Orders order) {

		OrderDao.update(order);
		
	}

	@Override
	public Orders get_orderById(Serializable id) {
		// TODO Auto-generated method stub
		return (Orders) OrderDao.getById(id);
	}

	@Override
	public List<Orders> list_order() {
		// TODO Auto-generated method stub
		return OrderDao.list();
	}


}
