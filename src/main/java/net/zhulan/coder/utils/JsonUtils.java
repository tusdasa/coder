package net.zhulan.coder.utils;

import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtils {
	private static Gson gson = new GsonBuilder().create();
	public JsonUtils() {}
	
	public static String ObjectToJson(Object object){
		return (String)gson.toJson(object);
	}
	
	public static <T> T ObjectToJson(String json,Type type){
		//Type typeOfT = new TypeToken<Collection<Foo>>(){}.getType();
		 return gson.fromJson(json,type);
	}
}
