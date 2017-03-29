package com.netStore.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.netStore.dao.OrderDao;
import com.netStore.pojo.Orders;

@Repository("OrderDao")
public class OrderDaoImpl extends BaseDaoImpl<Orders> implements OrderDao<Orders>{

	@Override
	public List<Orders> get_OrderByUid(long uid) {
		
		return (List<Orders>) this.getHibernateTemplate().find(" from Orders where uid = " + uid + " ");
		
	}
	
	

}
