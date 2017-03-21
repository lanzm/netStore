package com.netStore.springTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netStore.utils.BaseSpring;

public class SpringTest extends BaseSpring{
		
	@Test
	public void basespring(){
		context.getBean("sessionFactory");
	}

}
