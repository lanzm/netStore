package com.netStore.dao;

import java.util.List;

public interface OrderDao<T> extends BaseDao<T>{
	
	/**
	 * 根据用户id查询订单
	 * @param uid用户id
	 * @return订单集合
	 */
	public List<T> get_OrderByUid(long uid);
	
	
}
