package com.netStore.dao.impl;

import org.springframework.stereotype.Repository;
import com.netStore.dao.UsersDao;
import com.netStore.pojo.Users;

@Repository("UsersDao")
public class UsersDaoImpl extends BaseDaoImpl<Users> implements UsersDao<Users>{

}
