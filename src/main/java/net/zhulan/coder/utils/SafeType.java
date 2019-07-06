package net.zhulan.coder.utils;

public class SafeType {
	
	public static int toInt(String s) {
		int a=1;
		try {
			a = Integer.valueOf(s);
			return a;
		}catch (Exception e) {
			return a;
		}
	}
	
	public static Integer toInteger(String s) {
		int a=1;
		try {
			a = Integer.valueOf(s);
			return a;
		}catch (Exception e) {
			return a;
		}
	}
	
	public static Long toLong(String s) {
		Long a=0L;
		try {
			a = Long.valueOf(s);
			return a;
		}catch (Exception e) {
			return a;
		}
	}
	
	public static String toIntString(int s) {
		String a="1";
		try {
			a = String.valueOf(s);
			return a;
		}catch (Exception e) {
			return a;
		}
	}

}
