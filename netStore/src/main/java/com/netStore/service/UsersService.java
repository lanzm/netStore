package com.netStore.service;

import java.io.Serializable;
import java.util.List;

import com.netStore.pojo.Users;

public interface UsersService {
	
	void save_users(Users users);
	void remove_users(Serializable id);
	void update_users(Users users);
	Users get_usersById(Serializable id);
	List<Users> list_users();
	Users get_usersByName(String username);

}
