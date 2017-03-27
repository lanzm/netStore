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
		users.setUsername("1");
		users.setPhone("1");
		
		
		//usersDao.save(users);
		
	}

	
	@Test
	public void get_usersByIdtest(){
		
//		UsersDao usersDao = (UsersDao) context.getBean("UsersDao");
//		Users users = (Users) usersDao.getById(1L);
//		System.out.println(users.getUsername());
		
	}
	
	@Test
	public void get_usersByNametest(){
		
		UsersDao usersDao = (UsersDao) context.getBean("UsersDao");
		Users users = (Users) usersDao.get_UsersByName("a123");
		System.out.println("000000000000000000000000" + users.getUsername());
		
	}

}
