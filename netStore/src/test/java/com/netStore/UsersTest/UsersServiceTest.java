package com.netStore.UsersTest;

import org.junit.Test;

import com.netStore.service.impl.UsersServiceImpl;
import com.netStore.utils.BaseSpring;

public class UsersServiceTest extends BaseSpring{
	
	@Test
	public void users_getById(){
		
		UsersServiceImpl impl = (UsersServiceImpl) context.getBean("UsersService");
		System.out.println(impl.get_usersById(1L).getUsername());
		
	}

}
