package com.mylan.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mylan.dao.ClassifyDao;
import com.mylan.domain.Classify;
import com.mylan.utils.DBCPUtils;

public class ClassifyDaoImpl implements ClassifyDao{
	
	private QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());

	@Override
	public List<Classify> listAllClassify() {
		
		try {
			return qr.query("select * from classify",new BeanListHandler<Classify>(Classify.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean addClassify(Classify classify) {
		
		try {
			qr.update("insert into classify(id,name,description) values(?,?,?)", classify.getId(),classify.getName(),classify.getDescription());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	@Override
	public boolean updateClassify(String classifyID) {
		return true;
	}
	@Override
	public boolean delClassify(String classifyID) {
		return true;
		
	}
	@Override
	public Classify findClassifyByName(String classifyName) {
		try {
			return qr.query("select * from classify where name=?", new BeanHandler<Classify>(Classify.class), classifyName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
