package com.netStore.dao.impl;

import org.springframework.stereotype.Repository;

import com.netStore.dao.OrderItemDao;
import com.netStore.pojo.OrderItem;

@Repository("OrderItemDao")
public class OrderItemDaoImpl extends BaseDaoImpl<OrderItem> implements OrderItemDao<OrderItem>{
	

}
