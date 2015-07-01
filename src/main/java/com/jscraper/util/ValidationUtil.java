package com.jscraper.util;

public class ValidationUtil {
	
	public static Boolean isNull(Object obj){
		return obj == null;
	}
	
	public static Boolean isNotNull(Object obj){
		return obj != null;
	}
	
	public static Boolean isEmpty(String value){
		if(value == null || value.trim().equalsIgnoreCase("")){
			return true;
		}
		return false;
	}
	
	public static Boolean isNotEmpty(String value){
		if(value == null || value.trim().equalsIgnoreCase("")){
			return false;
		}
		return true;
	}
}
