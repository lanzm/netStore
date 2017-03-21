package com.netStore.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.netStore.dao.UsersDao;
import com.netStore.dao.impl.UsersDaoImpl;
import com.netStore.pojo.Users;
import com.netStore.service.UsersService;

public class UsersServiceImpl implements UsersService{
	
	
	public UsersDao userdaoimpl;
	public UsersDao getUserdaoimpl() {
		return userdaoimpl;
	}

	public void setUserdaoimpl(UsersDao userdaoimpl) {
		this.userdaoimpl = userdaoimpl;
	}

	@Override
	public void save_users(Users users) {
		
		userdaoimpl.save(users);
		
	}

	@Override
	public void remove_users(Serializable id) {

		userdaoimpl.remove(id);
		
	}

	@Override
	public void update_users(Users users) {

		userdaoimpl.update(users);
		
	}

	@Override
	public Users get_usersById(Serializable id) {
		
		return (Users) userdaoimpl.getById(id);
	
	}

	@Override
	public List<Users> list_users() {
		
		return userdaoimpl.list();
		
	}

}
