package com.netStore.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.netStore.dao.CommentDao;
import com.netStore.pojo.Comment;

@Repository("CommentDao")
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements CommentDao<Comment>{

	@Override
	public List<Comment> get_commentByBid(long bid) {
		// 按时间降序排列
		return (List<Comment>) this.getHibernateTemplate().find(" from Comment where bid = " + bid + " order by time desc ");
		
	}


	
	
	
}
