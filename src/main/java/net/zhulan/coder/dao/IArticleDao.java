package net.zhulan.coder.dao;

import java.util.List;

import net.zhulan.coder.entity.Article;
import net.zhulan.coder.entity.Comment;
import net.zhulan.coder.entity.Page;

public interface IArticleDao extends IBaseDao<Article, Long> {
	List<Article> findAllByPage(Page page);
	List<Article> findAllByPageByKeyWord(String key, Page page);
	List<Article> findAllByPageByUser(Long uid);
	List<Article> findAllByCategory(Integer acid, Page page);
	long count();
	long countByUser(Integer uid);
	List<Article> findAllPageNoContent();
	List<Article> tagFindArticle(Integer tid , Page page);
	List<Article> findAllPageNoContentByPage(Page page);
	List<Article> findAllPageNoContentByPage(String key,Page page);
	long countByKey(String key);
	boolean updateContent(Article article);
	boolean updateTitle(Article article);
	boolean updateCategory(Article article);
	boolean addComments(Long aid,Comment comment);
	boolean updateTags(Article article);
}
