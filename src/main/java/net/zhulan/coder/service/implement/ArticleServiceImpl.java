package net.zhulan.coder.service.implement;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zhulan.coder.dao.IArticleCategoryDao;
import net.zhulan.coder.dao.IArticleDao;
import net.zhulan.coder.dao.ICacheDao;
import net.zhulan.coder.dao.ITagsDao;
import net.zhulan.coder.entity.Article;
import net.zhulan.coder.entity.ArticleCategory;
import net.zhulan.coder.entity.Comment;
import net.zhulan.coder.entity.Page;
import net.zhulan.coder.entity.Tags;
import net.zhulan.coder.entity.User;
import net.zhulan.coder.service.IArticleService;

@Service("articleService")
public class ArticleServiceImpl implements IArticleService {
	
	@Autowired
	private IArticleDao articleDao; 
	@Autowired
	private IArticleCategoryDao articleCategoryDao;
	@Autowired
	private ITagsDao tagsDao;
	@Autowired
	private ICacheDao cacheDao;
	
	public ArticleServiceImpl() {}

	@Override
	public boolean addArticle(Article article) {
		article.setDate(new Date());
		cacheDao.clearCache();
		return articleDao.addModel(article);
	}

	@Override
	public boolean delArticle(Long aid) {
		cacheDao.clearCache();
		return articleDao.deleteByPrimaryKey(aid);
	}

	@Override
	public Article findArticleById(Long aid) {
		
		return articleDao.selectByPrimaryKey(aid);
	}

	
	@Override
	public List<Article> findAll(Page page) {
		
		List<Article> article = cacheDao.getArticleCache(page);
		
		if(article!=null) {
			return article;
		}else {
			article = articleDao.findAllByPage(page);
			cacheDao.addArticleCache(article, page);
			return article;
		}
		
	}

	@Override
	public List<Article> searchArticleByTitle(String key, Page page) {
		
		return articleDao.findAllPageNoContentByPage(key, page);
	}

	@Override
	public List<Article> findArticleByCategory(Integer acid,Page page) {
		
		return articleDao.findAllByCategory(acid, page);
	}

	@Override
	public List<Article> findArticleByTags(Integer tid, Page page) {
		
		return articleDao.tagFindArticle(tid, page);
	}

	@Override
	public List<Article> findTitilce(Page page) {
		
		return articleDao.findAllPageNoContentByPage(page);
	}

	@Override
	public boolean updateArticleContent(Article article) {
		cacheDao.clearCache();
		return articleDao.updateContent(article);
	}

	@Override
	public boolean updateArticleTitle(Article article) {
		cacheDao.clearCache();
		return articleDao.updateTitle(article);
	}

	@Override
	public boolean updateArticleCategory(Article article) {
		cacheDao.clearCache();
		return articleDao.updateCategory(article);
	}

	@Override
	public boolean addComments(Long aid,Comment comment) {
		cacheDao.clearCache();
		return articleDao.addComments(aid, comment);
	}

	@Override
	public boolean updateArticleTags(Article article) {
		cacheDao.clearCache();
		return articleDao.updateTags(article);
	}

	@Override
	public boolean addArticleCategory(String acname) {
		cacheDao.clearCache();
		return articleCategoryDao.addModel(new ArticleCategory(0, acname));
	}

	@Override
	public boolean delArticleCategory(Integer acid) {
		cacheDao.clearCache();
		return articleCategoryDao.deleteByPrimaryKey(acid);
	}

	@Override
	public boolean upArticleCategory(ArticleCategory category) {
		cacheDao.clearCache();
		if(articleCategoryDao.updateByPrimaryKey(category)>0) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public List<ArticleCategory> findAllCategory() {
		List<ArticleCategory> categories = cacheDao.getCategory();
		if(categories!=null) {
			return categories;
		}else {
			categories = articleCategoryDao.findAll();
			cacheDao.addCactgoryCache(categories);
			return categories;
		}
		
	}

	@Override
	public boolean addTag(String tag) {
		return tagsDao.addModel(new Tags(tag));
	}

	@Override
	public List<Tags> findAllTags() {
		return tagsDao.findAll();
	}

	@Override
	public long count() {
		return articleDao.count();
	}

	@Override
	public long count(Integer acid) {
		return articleCategoryDao.countByCategory(acid);
	}

	@Override
	public List<Article> findAll() {
		return articleDao.findAll();
	}

	@Override
	public long countByKey(String key) {
		return articleDao.countByKey(key);
	}

	@Override
	public boolean upTag(Tags tag) {
		cacheDao.clearCache();
		int result = tagsDao.updateByPrimaryKey(tag);
		if(result>0) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean upArticle(Article article) {
		cacheDao.clearCache();
		article.setDate(new Date());
		if(articleDao.updateByPrimaryKey(article)>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Article> findArticleByUser(User user) {
		return articleDao.findAllByPageByUser(user.getUid());
	}

}
