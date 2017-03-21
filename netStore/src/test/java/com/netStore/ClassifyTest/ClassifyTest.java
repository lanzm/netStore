package com.netStore.ClassifyTest;

import org.junit.Test;

import com.netStore.dao.ClassifyDao;
import com.netStore.pojo.Classify;
import com.netStore.utils.BaseSpring;

public class ClassifyTest extends BaseSpring{

	@Test
	public void classifyDaoSaveTest(){
		
//		ClassifyDao classifyDao = (ClassifyDao) context.getBean("ClassifyDao");
//		Classify classify = new Classify();
//		classify.setClassifyname("213");
//		classify.setDescription("123");
//		classifyDao.save(classify);
		
	}
	
	@Test
	public void classifyGetByNameTest(){
		
		ClassifyDao classifyDao = (ClassifyDao) context.getBean("ClassifyDao");
		Classify classify = classifyDao.getByName("jsp");
		System.out.println("byname的 " + classify.getCid());
	}
	
	@Test
	public void classifyDaoListTest(){
		
		ClassifyDao classifyDao = (ClassifyDao) context.getBean("ClassifyDao");
		System.out.println(classifyDao.list().isEmpty());
		
	}

}
