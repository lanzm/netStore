package com.mylan.dao;

import java.util.List;

import com.mylan.domain.Classify;

public interface ClassifyDao {
	/**
	 * ���г����еķ���
	 */
	List<Classify> listAllClassify();

	/**
	 * ��ӷ���
	 */
	Classify findClassifyByName(String classifyName);
	
	boolean addClassify(Classify classify);
	
	boolean updateClassify(String classifyID);
	
	boolean delClassify(String classifyID);
}
