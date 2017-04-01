package com.netStore.dao;

import java.util.List;

import com.netStore.pojo.Parent_Children;

public interface Parent_ChildrenDao<T> extends BaseDao<T>{

	/**
	 * 通过childrenid查出 对于的parent
	 * @param cid
	 * @return返回集合
	 */
	public List<Parent_Children> get_PcBychildren_cid(long cid);
		
}
