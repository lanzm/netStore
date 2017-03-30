package com.netStore.service.impl;

import java.io.Serializable;
import java.util.List;

import com.netStore.dao.CommentDao;
import com.netStore.pojo.Comment;
import com.netStore.service.CommentService;

public class CommentServiceImpl implements CommentService{
	
	
	public CommentDao CommentDao;
	public CommentDao getCommentDao() {
		return CommentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		CommentDao = commentDao;
	}

	@Override
	public void save_Comment(Comment comment) {

		CommentDao.save(comment);
		
	}

	@Override
	public void remove_Comment(Serializable id) {

		CommentDao.remove(id);
		
	}

	@Override
	public void update_Comment(Comment comment) {

		CommentDao.update(comment);
		
	}

	@Override
	public Comment get_CommentById(Serializable id) {
		
		return (Comment) CommentDao.getById(id);
	}

	@Override
	public List<Comment> list_Comment() {
		
		return CommentDao.list();
	}

	@Override
	public List<Comment> get_CommentByBid(long bid) {
		
		return CommentDao.get_commentByBid(bid);
	}
	

	



}
