package net.zhulan.coder.service;

import java.util.List;

import net.zhulan.coder.entity.Article;
import net.zhulan.coder.entity.ArticleCategory;
import net.zhulan.coder.entity.Comment;
import net.zhulan.coder.entity.Page;
import net.zhulan.coder.entity.Tags;
import net.zhulan.coder.entity.User;

public interface IArticleService {
	boolean addArticle(Article article);
	boolean delArticle(Long aid);
	boolean updateArticleContent(Article article);
	boolean updateArticleTitle(Article article);
	boolean updateArticleCategory(Article article);
	boolean addComments(Long aid,Comment comment);
	boolean updateArticleTags(Article article);
	Article findArticleById(Long aid);
	List<Article> findAll();
	List<Article> findAll(Page page);
	List<Article> searchArticleByTitle(String key,Page page);
	List<Article> findArticleByCategory(Integer acid,Page page);
	List<Article> findArticleByTags(Integer tid, Page page);
	List<Article> findTitilce(Page page);
	List<Article> findArticleByUser(User user);
	boolean addArticleCategory(String acname);
	boolean delArticleCategory(Integer acid);
	boolean upArticleCategory(ArticleCategory category);
	boolean upArticle(Article article);
	List<ArticleCategory> findAllCategory();
	boolean addTag(String tag);
	boolean upTag(Tags tag);
	List<Tags> findAllTags();
	long count();
	long count(Integer acid);
	long countByKey(String key);
}
