package com.mylan.datatest;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.mylan.dao.ClassifyDao;
import com.mylan.dao.impl.ClassifyDaoImpl;
import com.mylan.domain.Classify;
import com.mylan.service.ClassifyService;
import com.mylan.service.impl.ClassifyServiceImpl;
import com.mylan.utils.DBCPUtils;

public class Test {
	
	private QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
	
	@org.junit.Test
	public void DBCPUtilsTest(){
		
		try {
			qr.update("insert into classify(id,name,description) values(1,'小米','看')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@org.junit.Test
	public void classifydaoimplfindAllTest(){
		ClassifyDao cd = new ClassifyDaoImpl();
		List<Classify> list = cd.listAllClassify();
		for (Classify classify : list) {
			System.out.println(classify.getName());
		}
		
	}
	@org.junit.Test
	public void classifydaoimplAddclassifyTest(){
		ClassifyDao cd = new ClassifyDaoImpl();
		Classify cf = new Classify();
		cf.setId("2");
		cf.setName("魅族");
		cf.setDescription("正在用");
		System.out.println(cd.addClassify(cf));
		
		
	}
	@org.junit.Test
	public void classifyserviceimplfindAllClassifyTest(){
		ClassifyService cs = new ClassifyServiceImpl();
		List<Classify> list = cs.getAllClassify();
		for (Classify classify : list) {
			System.out.println(classify.getName());
		}
		
		
	}

	@org.junit.Test
	public void classifyserviceimpladdClassifyTest(){
		ClassifyService cs = new ClassifyServiceImpl();
		Classify classify = new Classify();
		classify.setId("5");
		classify.setName("华为");
		classify.setDescription("很耐用");
		System.out.println(cs.addClassify(classify));
		
		
	}

}
