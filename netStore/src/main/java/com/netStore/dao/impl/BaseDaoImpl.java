package com.netStore.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.netStore.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {
	
	public Class classt;	
	
	public HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public BaseDaoImpl(){
		
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		this.classt = (Class)type.getActualTypeArguments()[0];//<T>
		System.out.println(type.getRawType());
	}
	

	@Override
	public void save(T t) {
		
		this.hibernateTemplate.save(t);
		
	}

	@Override
	public void remove(Serializable id) {
		
		T t = getById(id);
		this.hibernateTemplate.delete(t);
		
	}

	@Override
	public void update(T t) {
		
		this.hibernateTemplate.update(t);
		
	}

	@Override
	public T getById(Serializable id) {
		
		return (T) this.hibernateTemplate.get(classt, id);
		
	}

	@Override
	public List<T> list() {
		
		return (List<T>) this.hibernateTemplate.find("from " + this.classt.getName());
	}

}
