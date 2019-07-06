package net.zhulan.coder.utils;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

public class CacheUtils {
	
	private static CacheManager cacheManager;
	
	private static Cache<String, Object> myCache;
	
	public CacheUtils() {}
	
	public static Cache<String, Object> createCache() {
	cacheManager = CacheManagerBuilder.newCacheManagerBuilder() 
				    .withCache("preConfigured",
				    CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, Object.class, ResourcePoolsBuilder.heap(10))) 
				    .build(); 
	cacheManager.init();
	myCache = cacheManager.createCache("articleCache", CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, Object.class, ResourcePoolsBuilder.heap(1000)));
	
	return myCache;
	}
	

}
