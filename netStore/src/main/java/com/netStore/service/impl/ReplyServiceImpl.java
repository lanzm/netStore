package com.netStore.service.impl;

import java.io.Serializable;
import java.util.List;
import com.netStore.dao.ReplyDao;
import com.netStore.pojo.Reply;
import com.netStore.service.ReplyService;

public class ReplyServiceImpl implements ReplyService{
	
	
	public ReplyDao ReplyDao;

	public ReplyDao getReplyDao() {
		return ReplyDao;
	}

	public void setReplyDao(ReplyDao replyDao) {
		ReplyDao = replyDao;
	}

	@Override
	public void save_Reply(Reply reply) {

		this.ReplyDao.save(reply);
		
	}

	@Override
	public void remove_Reply(Serializable id) {

		this.ReplyDao.remove(id);
		
	}

	@Override
	public void update_Reply(Reply reply) {


		this.ReplyDao.update(reply);
		
	}

	@Override
	public Reply get_ReplyById(Serializable id) {
		
		return (Reply) this.ReplyDao.getById(id);
	}

	@Override
	public List<Reply> list_Reply() {
		
		return this.ReplyDao.list();
	}

	@Override
	public List<Reply> get_ReplyByCid(long cid) {
		
		return this.ReplyDao.get_ReplyByCid(cid);
	}

	@Override
	public List<Reply> get_ReplyByBid(long bid) {
		
		return this.ReplyDao.get_ReplyByBid(bid);
	}
	
	


}
