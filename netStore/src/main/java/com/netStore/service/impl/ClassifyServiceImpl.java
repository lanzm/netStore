package com.netStore.service.impl;

import java.io.Serializable;
import java.util.List;

import com.netStore.dao.ClassifyDao;
import com.netStore.dao.ManagerDao;
import com.netStore.pojo.Classify;
import com.netStore.pojo.Manager;
import com.netStore.service.ClassifyService;
import com.netStore.service.ManagerService;

public class ClassifyServiceImpl implements ClassifyService{
	
	
	public ClassifyDao classifyDao;
	public ClassifyDao getClassifyDao() {
		return classifyDao;
	}

	public void setClassifyDao(ClassifyDao classifyDao) {
		this.classifyDao = classifyDao;
	}

	@Override
	public void save_Classify(Classify classify) {
		
		classifyDao.save(classify);
		
	}

	@Override
	public void remove_Classify(Serializable id) {
		
		classifyDao.remove(id);
		
	}

	@Override
	public void update_Classify(Classify classify) {
		
		classifyDao.update(classify);
		
	}

	@Override
	public Classify get_ClassifyById(Serializable id) {
		
		return (Classify) classifyDao.getById(id);
	}

	@Override
	public List<Classify> list_Classify() {
		
		return classifyDao.list();
	}

	@Override
	public Classify get_ClassifyByName(String classifyname) {
		
		return classifyDao.getByName(classifyname);
	}
	
	
}
