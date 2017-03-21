package com.netStore.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseSpring {
	
	public static ApplicationContext context;
	static{
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
	}

}
