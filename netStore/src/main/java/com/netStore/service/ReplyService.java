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
	

}
