package com.netStore.utils;

import java.math.BigInteger;

public class Random {
	
	// 产生随机数
	public static String genGUID(){
		
		return new BigInteger(165, new java.util.Random()).toString(36).toUpperCase();
		
	}
	

}
