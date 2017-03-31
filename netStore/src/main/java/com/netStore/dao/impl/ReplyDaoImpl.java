package com.netStore.dao.impl;



import java.util.List;

import org.springframework.stereotype.Repository;
import com.netStore.dao.ReplyDao;
import com.netStore.pojo.Reply;

@Repository("ReplyDao")
public class ReplyDaoImpl extends BaseDaoImpl<Reply> implements ReplyDao<Reply>{

	@Override
	public List<Reply> get_ReplyByCid(long cid) {
		
		return (List<Reply>) this.getHibernateTemplate().find(" from Reply where cid = " + cid +" ");
	}

	@Override
	public List<Reply> get_ReplyByBid(long bid) {
		
		return (List<Reply>) this.getHibernateTemplate().find(" from Reply where bid = " + bid + " order by r_time desc ");
	}

	
	
}
