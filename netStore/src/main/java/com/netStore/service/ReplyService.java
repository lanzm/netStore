package com.netStore.service;

import java.io.Serializable;
import java.util.List;
import com.netStore.pojo.Reply;

public interface ReplyService {
	
	void save_Reply(Reply reply);
	void remove_Reply(Serializable id);
	void update_Reply(Reply reply);
	Reply get_ReplyById(Serializable id);
	List<Reply> list_Reply();
	
	/**
	 * 通过cid查询回复评论集合
	 * @param cid
	 * @return返回回复评论集合
	 */
	List<Reply> get_ReplyByCid(long cid);

	/**
	 * 通过bid查询回复评论集合
	 * @param bid
	 * @return返回回复评论集合
	 */
	List<Reply> get_ReplyByBid(long bid);
}
