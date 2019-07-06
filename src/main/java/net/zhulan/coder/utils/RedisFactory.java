package net.zhulan.coder.utils;


import java.time.Duration;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class RedisFactory {
	
	private static RedisClient client;
	private static StatefulRedisConnection<String, String> connection;

	public RedisFactory() {}

	public static RedisCommands<String, String> createRedisCommands() {
		client = RedisClient.create(RedisURI.Builder.redis("localhost", 6379).build());
		try {
			connection = client.connect();
			connection.setTimeout(Duration.ofSeconds(30));
		} catch (Exception e) {
			connection.close();
			return null;
		}
		RedisCommands<String, String> commands = connection.sync();
		return commands;
	}
	
	public static void setValue(RedisCommands<String, String> cmd,String key,String value) {
		if(check(cmd)) {
			cmd.set(key, value);
		}
		
	}
	
	public static String getValue(RedisCommands<String, String> cmd,String key) {
		if(check(cmd)) {
			return  cmd.get(key);
		}
		return null;	
	}
	
	
	public static void setKeyTTL(RedisCommands<String, ?> cmd,String key) {
		if(check(cmd)) {
			cmd.expire(key, 600);
		}
		
	}
	
	public static void setDBNumber(RedisCommands<String, ?> cmd, int dbnumber) {
		if(check(cmd)) {
			cmd.select(dbnumber);
		}
		
	}
	public static void quit(RedisCommands<String, ?> cmd) {
		if(check(cmd)) {
			cmd.quit();
		}
		
	}
	public static void delKey(RedisCommands<String, ?> cmd, String key) {
		if(check(cmd)) {
			cmd.del(key);
		}
		
	}
	public static void clearDB(RedisCommands<String, ?> cmd) {
		if(check(cmd)) {
			cmd.flushdb();
		}
		
	}
	public static void clearAll(RedisCommands<String, ?> cmd) {
		if(check(cmd)) {
			cmd.flushall();
		}
	}
	
	private static boolean check(RedisCommands<String, ?> cmd) {
		if(cmd!=null) {
			return true;
		}else {
			return false;
		}
	}

}
