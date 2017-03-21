package com.netStore.dao;

import com.netStore.pojo.Classify;

public interface ClassifyDao<T> extends BaseDao<T>{
	
	public Classify getByName(String classifyname);

}
