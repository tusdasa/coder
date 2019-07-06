package net.zhulan.coder.dao;

import java.util.List;

import net.zhulan.coder.entity.Address;
import net.zhulan.coder.entity.Article;
import net.zhulan.coder.entity.ArticleCategory;
import net.zhulan.coder.entity.Page;

public interface ICacheDao {
	void addArticleCache(List<Article> articles, Page page);
	List<Article> getArticleCache(Page page);
	void addAddressCache(List<Address> addresses);
	List<Address> getAddressCache();
	void addCactgoryCache(List<ArticleCategory> categories);
	List<ArticleCategory> getCategory();
	void clearCache();
}
