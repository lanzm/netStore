package com.netStore.dao.impl;

import org.springframework.stereotype.Repository;

import com.netStore.dao.OrderDao;
import com.netStore.pojo.Orders;

@Repository("OrderDao")
public class OrderDaoImpl extends BaseDaoImpl<Orders> implements OrderDao<Orders>{
	

}
