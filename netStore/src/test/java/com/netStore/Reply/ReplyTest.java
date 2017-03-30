package com.netStore.Reply;

import java.util.Date;

import org.junit.Test;

import com.netStore.dao.ReplyDao;
import com.netStore.pojo.Reply;
import com.netStore.utils.BaseSpring;

public class ReplyTest extends BaseSpring{

	@Test
	public void save_ReplyDaoTest(){
		
		ReplyDao replyDao = (ReplyDao) context.getBean("ReplyDao");
		Reply reply = new Reply();
		reply.setR_content("1");
		reply.setR_praise(0);
		reply.setR_time(new Date());

		
		//replyDao.save(reply);
		
	}
	
}
