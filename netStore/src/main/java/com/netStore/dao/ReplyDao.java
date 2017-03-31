package com.netStore.dao;

import java.util.List;

import com.netStore.pojo.Reply;

public interface ReplyDao<T> extends BaseDao<T>{
	
	/**
	 * 通过cid查回复评论
	 * @param cid
	 * @return返回回复集合
	 */
	List<Reply> get_ReplyByCid(long cid);
	
	/**
	 * 通过bid查回复评论
	 * @param bid
	 * @return返回回复集合
	 */
	List<Reply> get_ReplyByBid(long bid);
	
}
