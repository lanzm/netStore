package com.netStore.Order;


import org.junit.Test;

import com.netStore.dao.OrderDao;
import com.netStore.pojo.Orders;
import com.netStore.utils.BaseSpring;

public class OrderTest extends BaseSpring{
	
	
	@Test
	public void orderDaoTest(){
		
		OrderDao orderDao = (OrderDao) context.getBean("OrderDao");
		Orders t = new Orders();
		t.setStatus("0");
		t.setMoney(11);
		
		orderDao.save(t);
		
	}

}
