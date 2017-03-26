package com.mylan.service.impl;

import java.util.List;

import com.mylan.dao.ClassifyDao;
import com.mylan.dao.impl.ClassifyDaoImpl;
import com.mylan.domain.Classify;
import com.mylan.service.ClassifyService;

public class ClassifyServiceImpl implements ClassifyService{

	
	private ClassifyDao cd = new ClassifyDaoImpl();

	@Override
	public List<Classify> getAllClassify() {
		return cd.listAllClassify();
	}

	@Override
	public boolean addClassify(Classify classify) {
		
		return cd.addClassify(classify);
	}

	@Override
	public Classify getClassifyByName(String classifyName) {
		return cd.findClassifyByName(classifyName);
	}
	
	

	
}
