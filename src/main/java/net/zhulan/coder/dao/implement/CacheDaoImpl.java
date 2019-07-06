package net.zhulan.coder.dao.implement;

import java.util.List;

import com.google.gson.reflect.TypeToken;

import io.lettuce.core.api.sync.RedisCommands;
import net.zhulan.coder.dao.ICacheDao;
import net.zhulan.coder.entity.Address;
import net.zhulan.coder.entity.Article;
import net.zhulan.coder.entity.ArticleCategory;
import net.zhulan.coder.entity.Page;
import net.zhulan.coder.utils.JsonUtils;
import net.zhulan.coder.utils.RedisFactory;

public class CacheDaoImpl implements ICacheDao {

	private RedisCommands<String, String> commands = RedisFactory.createRedisCommands();
	
	private final String ADDRESS_KEY="address";
	private final String CATEGORY_KEY="category";
	
	public CacheDaoImpl() {}

	@Override
	public void addArticleCache(List<Article> articles, Page page) {
		
		String key = "art"+page.getPageNum()+page.getPageSize();
		
		if(articles!=null) {
			RedisFactory.setValue(commands, key, JsonUtils.ObjectToJson(articles));
		}
		
		
	}

	@Override
	public List<Article> getArticleCache(Page page) {
		
		String key = "art"+page.getPageNum()+page.getPageSize();
		
		if(RedisFactory.getValue(commands, key)!=null) {
			return JsonUtils.ObjectToJson(RedisFactory.getValue(commands, key), new TypeToken<List<Article>>(){}.getType());
		}else {
			return null;
		}
		
	}

	@Override
	public void clearCache() {
		RedisFactory.clearAll(commands);
	}

	@Override
	public void addAddressCache(List<Address> addresses) {
		
		if(addresses!=null) {
			RedisFactory.setValue(commands, ADDRESS_KEY, JsonUtils.ObjectToJson(addresses));
		}
	}

	@Override
	public List<Address> getAddressCache() {

		if(RedisFactory.getValue(commands, ADDRESS_KEY)!=null) {
			return JsonUtils.ObjectToJson(RedisFactory.getValue(commands, ADDRESS_KEY), new TypeToken<List<Address>>(){}.getType());
		}else {
			return null;
		}
	}

	@Override
	public void addCactgoryCache(List<ArticleCategory> categories) {
		
		if(categories!=null) {
			RedisFactory.setValue(commands, CATEGORY_KEY,  JsonUtils.ObjectToJson(categories));
		}
		
	}

	@Override
	public List<ArticleCategory> getCategory() {
		if(RedisFactory.getValue(commands, CATEGORY_KEY)!=null) {
			return JsonUtils.ObjectToJson(RedisFactory.getValue(commands, CATEGORY_KEY), new TypeToken<List<ArticleCategory>>(){}.getType());
		}else {
			return null;
		}
	}

}
