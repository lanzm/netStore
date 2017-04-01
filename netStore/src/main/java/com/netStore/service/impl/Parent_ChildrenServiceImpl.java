package com.netStore.service.impl;

import java.io.Serializable;
import java.util.List;
import com.netStore.dao.Parent_ChildrenDao;
import com.netStore.pojo.Parent_Children;
import com.netStore.service.Parent_ChildrenService;

public class Parent_ChildrenServiceImpl implements Parent_ChildrenService{
	
	
	public Parent_ChildrenDao Parent_ChildrenDao;

	public Parent_ChildrenDao getParent_ChildrenDao() {
		return Parent_ChildrenDao;
	}

	public void setParent_ChildrenDao(Parent_ChildrenDao parent_ChildrenDao) {
		Parent_ChildrenDao = parent_ChildrenDao;
	}

	@Override
	public void save_Parent_Children(Parent_Children parent_Children) {

		Parent_ChildrenDao.save(parent_Children);
		
	}

	@Override
	public void remove_Parent_Children(Serializable id) {

		Parent_ChildrenDao.remove(id);
		
	}

	@Override
	public void update_Parent_Children(Parent_Children parent_Children) {

		Parent_ChildrenDao.update(parent_Children);
		
	}

	@Override
	public Parent_Children get_Parent_ChildrenById(Serializable id) {
		
		return (Parent_Children) Parent_ChildrenDao.getById(id);
	}

	@Override
	public List<Parent_Children> list_Parent_Children() {
		
		return Parent_ChildrenDao.list();
	}

	@Override
	public List<Parent_Children> get_Parent_ChildrenByChildrenId(long children_cid) {
		
		return Parent_ChildrenDao.get_PcBychildren_cid(children_cid);
	}
	

	

}
