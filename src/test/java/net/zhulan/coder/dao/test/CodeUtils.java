package net.zhulan.coder.dao.test;

import java.util.Random;
import java.util.UUID;

public class CodeUtils {

	public CodeUtils() {
	}
	
	public static String getRandom() {
		Random random = new Random();
		String fourRandom= String.valueOf(random.nextInt(1000000));
		 int randLength = fourRandom.length();
	        if(randLength<4){
	          for(int i=1; i<=4-randLength; i++)
	              fourRandom = "0" + fourRandom;
	      }
	        return fourRandom;
	    }
	public static int getRandomInt() {
		Random random = new Random();
	    return random.nextInt(100);
	    }
	
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase().substring(0,10);
		return uuid;
	}
	
	public static String getCode() {
		Random random = new Random();
		String fourRandom= String.valueOf(random.nextInt(9999));
		 int randLength = fourRandom.length();
	        if(randLength<4){
	          for(int i=1; i<=4-randLength; i++)
	              fourRandom = "0" + fourRandom;
	      }
	        return fourRandom;
	    }

}
