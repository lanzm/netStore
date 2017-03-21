package com.netStore.dao.impl;

import org.springframework.stereotype.Repository;

import com.netStore.dao.ManagerDao;
import com.netStore.pojo.Manager;

@Repository("ManagerDao")
public class ManagerDaoImpl extends BaseDaoImpl<Manager> implements ManagerDao<Manager>{

	
}
