package com.netStore.dao.impl;




import java.util.List;

import org.springframework.stereotype.Repository;
import com.netStore.dao.Parent_ChildrenDao;
import com.netStore.pojo.Parent_Children;

@Repository("Parent_ChildrenDao")
public class Parent_ChildrenDaoImpl extends BaseDaoImpl<Parent_Children> implements Parent_ChildrenDao<Parent_Children>{

	@Override
	public List<Parent_Children> get_PcBychildren_cid(long cid) {
		
		return (List<Parent_Children>) this.getHibernateTemplate().find(" from Parent_Children where children_cid = " + cid + " ");
	}

	
	
}
