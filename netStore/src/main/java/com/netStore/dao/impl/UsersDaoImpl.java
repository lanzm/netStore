package com.netStore.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.netStore.dao.UsersDao;
import com.netStore.pojo.Classify;
import com.netStore.pojo.Users;

@Repository("UsersDao")
public class UsersDaoImpl extends BaseDaoImpl<Users> implements UsersDao<Users>{

	@Override
	public Users get_UsersByName(String username) {
		
		
		List<Users> list = (List<Users>) this.getHibernateTemplate().find(" from Users where username= '" + username +"' ");
		if(list.size() == 0){
			return null;
		}else{
			return list.get(0);
		}
		
	}

}
