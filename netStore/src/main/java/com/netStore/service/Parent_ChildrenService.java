package com.netStore.service;

import java.io.Serializable;
import java.util.List;

import com.netStore.pojo.Parent_Children;

public interface Parent_ChildrenService {
	
	void save_Parent_Children(Parent_Children parent_Children);
	void remove_Parent_Children(Serializable id);
	void update_Parent_Children(Parent_Children parent_Children);
	Parent_Children get_Parent_ChildrenById(Serializable id);
	List<Parent_Children> list_Parent_Children();
	
	/**
	 * 根据 子id查出所有的评论
	 * @param children_cid
	 * @return
	 */
	List<Parent_Children> get_Parent_ChildrenByChildrenId(long children_cid);

}
