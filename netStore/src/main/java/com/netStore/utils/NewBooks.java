package com.netStore.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.netStore.pojo.Book;

public class NewBooks {
	
	/**
	 * 计算时间差，判断是否是新书
	 * @param books 传入书籍集合
	 * @return 返回新书集合
	 * @throws Exception
	 */
	public List<Book> get_newBook(List<Book> books) throws Exception{
		
		//------------------------------//
		List<Book> newbooks = new ArrayList<>();
		for(int i = 0; i < books.size() ; i ++ ){
			
			//格式化时间格式
			SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//获取当前时间
			Date nowTime=new Date();
			//格式化现在时间
			String tmf= matter1.format(nowTime);
			// 格式化数据库中的时间
			String sqltime = matter1.format(books.get(i).getAddtime());
			Date now=matter1.parse(tmf);
			Date end=matter1.parse(sqltime);
			//计算时间差
			long cha=(now.getTime()-end.getTime())/ (1000 * 60 * 60 * 24);
			// 时间差20天,则为新书
			if(cha <= 100){
				// 把他放到一个集合中
				newbooks.add(books.get(i));
			}
		}
		return newbooks;
		
	}

}
