package com.netStore.dao;

import java.util.List;

import com.netStore.pojo.Comment;

public interface CommentDao<T> extends BaseDao<T>{
	/**
	 * 书籍id查评论
	 * @param bid书籍id
	 * @return返回评论集合
	 */
	public List<Comment> get_commentByBid(long bid);
	
}
