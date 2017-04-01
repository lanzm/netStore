package com.netStore.comment;

import java.util.Date;

import org.junit.Test;

import com.netStore.dao.CommentDao;
import com.netStore.pojo.Comment;
import com.netStore.utils.BaseSpring;

public class CommentTest extends BaseSpring{
	
	@Test
	public void saveCommentDaoTest(){
		
		CommentDao commentDao = (CommentDao) context.getBean("CommentDao");
		Comment comment = new Comment();
		comment.setType(0);
		comment.setTime(new Date());
		
		commentDao.save(comment);
		
		
	}

}
