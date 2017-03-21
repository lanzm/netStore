package com.netStore.service.impl;

import java.io.Serializable;
import java.util.List;
import com.netStore.dao.ManagerDao;
import com.netStore.pojo.Manager;
import com.netStore.service.ManagerService;

public class ManagerServiceImpl implements ManagerService{
	
	
	public ManagerDao managerDao;
	public ManagerDao getManagerDao() {
		return managerDao;
	}

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	@Override
	public void save_Manager(Manager manager) {
		
		managerDao.save(manager);
		
	}

	@Override
	public void remove_Manager(Serializable id) {

		managerDao.remove(id);
		
	}

	@Override
	public void update_Manager(Manager manager) {
		
		managerDao.update(manager);
		
	}

	@Override
	public Manager get_ManagerById(Serializable id) {

		return (Manager) managerDao.getById(id);
		
	}

	@Override
	public List<Manager> list_Manager() {
		
		return managerDao.list();
		
	}

	

}
