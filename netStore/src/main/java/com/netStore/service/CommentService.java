package com.netStore.service;

import java.io.Serializable;
import java.util.List;
import com.netStore.pojo.Comment;

public interface CommentService {
	
	void save_Comment(Comment comment);
	void remove_Comment(Serializable id);
	void update_Comment(Comment comment);
	Comment get_CommentById(Serializable id);
	List<Comment> list_Comment();
	/**
	 * bid查评论
	 * @param id
	 * @return返回评论集合
	 */
	List<Comment> get_CommentByBid(long bid);

}
