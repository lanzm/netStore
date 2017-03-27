package com.netStore.dao;

import com.netStore.pojo.Users;

public interface UsersDao<T> extends BaseDao<T>{
	
	/**
	 * 用用户名查询用户
	 * @param username 用户名
	 * @return 返回用户集合
	 */
	Users get_UsersByName(String username);


}
