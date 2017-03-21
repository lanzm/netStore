package com.netStore.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.netStore.dao.ClassifyDao;
import com.netStore.pojo.Classify;

@Repository("ClassifyDao")
public class ClassifyDaoImpl extends BaseDaoImpl<Classify> implements ClassifyDao<Classify>{

	@Override
	public Classify getByName(String classifyname) {
		
		// 注意 ！！！！！！！！ 
		//   find中的 sql语句 第二个是 类名！ 不是 表名！！ 注意！！
		//     而且 输入的值两边要加上 ''   注意 ！！
		List<Classify> list = (List<Classify>) this.getHibernateTemplate().find("from Classify where classifyname= '" + classifyname +"' ");
		if(list.size() == 0){
			return null;
		}else{
			return list.get(0);
		}
	}

}
