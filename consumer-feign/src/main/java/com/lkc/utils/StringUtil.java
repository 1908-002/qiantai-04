package com.lkc.utils;


public class StringUtil {
	
	/*
	  *     判断字符串为空
	 */
	public static boolean isEmpty(String str) {
		if(str == null || "".equals(str) || str.length() == 0)
			return true; 
		return false;
	}
	
	/*
	 *  判断字符串不为空
	 */
	public static boolean isNotEmpty(String str) {
		if(!isEmpty(str))
			return true;
		return false;
	}

}
