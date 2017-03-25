package com.netStore.utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.netStore.pojo.Book;

public class RandomUtils {
	
	// 产生随机数
	public static String genGUID(){
		
		return new BigInteger(165, new java.util.Random()).toString(36).toUpperCase();
		
	}
	
	/**
	 *  产生三个随机数
	 * @param books 输入books集合
	 * @return
	 */
	public List<Integer> random(List<Book> books){
		
		List<Integer> randoms = new ArrayList<>();
		
	//-------------随机数向网页推送书籍-----------------//
		// 产生随机数，随机推荐精选书籍
		Random random = new Random();
		int max = books.size();
		// 设置范围 0 ~ 书籍数
		int a = random.nextInt(max)%(max+1);
		boolean flag = true;
		int b = 0;
		int c = 0;
		// 产生三个不同的 随机数
		while(flag){
			b = random.nextInt(max)%(max+1);
			c = random.nextInt(max)%(max+1);
			if(a == b || a == c || b == c){
				flag = true;
			}else{
				flag = false;
			}
		}
		
		randoms.add(a);
		randoms.add(b);
		randoms.add(c);
		return randoms;
	}
	

}
