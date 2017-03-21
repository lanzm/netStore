package com.netStore.UsersTest;

import java.util.Date;

import org.junit.Test;

import com.netStore.dao.UsersDao;
import com.netStore.pojo.Users;
import com.netStore.utils.BaseSpring;

public class UsersDaoTest extends BaseSpring{
	
	@Test
	public void save_users(){
		
		UsersDao usersDao = (UsersDao) context.getBean("UsersDao");
		Users users = new Users();
		users.setBirthday(new Date());
		users.setPassword("123");
		users.setUsername("123");
		
		//usersDao.save(users);
		
	}

	
	
	@Test
	public void get_usersByIdtest(){
		
		UsersDao usersDao = (UsersDao) context.getBean("UsersDao");
		Users users = (Users) usersDao.getById(1L);
		System.out.println(users.getUsername());
		
	}

}
