package com.netStore.dao;

import java.io.Serializable;
import java.util.List;


public interface BaseDao<T> {
	
	void save(T t);
	void remove(Serializable id);
	void update(T t);
	T getById(Serializable id);
	List<T> list();

}
