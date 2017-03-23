package com.mylan.service;

import java.util.List;

import com.mylan.domain.Classify;

public interface ClassifyService {

	List<Classify> getAllClassify();
	
	boolean addClassify(Classify classify);
	
	Classify getClassifyByName(String classifyName);
}
