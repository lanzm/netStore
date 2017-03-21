package com.netStore.service;

import java.io.Serializable;
import java.util.List;
import com.netStore.pojo.Manager;

public interface ManagerService {
	
	void save_Manager(Manager manager);
	void remove_Manager(Serializable id);
	void update_Manager(Manager manager);
	Manager get_ManagerById(Serializable id);
	List<Manager> list_Manager();

}
