package com.netStore.UsersTest;

import org.junit.Test;

import com.netStore.service.UsersService;
import com.netStore.utils.BaseSpring;

public class UsersServiceTest extends BaseSpring{
	
	@Test
	public void users_getById(){
		
		UsersService impl = (UsersService) context.getBean("UsersService");
		System.out.println("222222222222222222222222222222     " + impl.get_usersById(1L).getUsername());
		
	}

}
