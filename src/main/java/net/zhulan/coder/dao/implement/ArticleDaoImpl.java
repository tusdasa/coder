package net.zhulan.coder.dao.implement;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import net.zhulan.coder.dao.BaseDaoObject;
import net.zhulan.coder.dao.IArticleDao;
import net.zhulan.coder.entity.Article;
import net.zhulan.coder.entity.Comment;
import net.zhulan.coder.entity.Page;
import net.zhulan.coder.utils.ArticleUtils;

public class ArticleDaoImpl  extends BaseDaoObject implements IArticleDao {
	
	private ArticleUtils aru = new ArticleUtils(); 
	
	public ArticleDaoImpl() {}

	@Override
	public boolean deleteByPrimaryKey(Long aid) {
			
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("ArticleDao.deleteByPrimaryKey");
		
		boolean result = aru.delete(em, jsql, aid);
		
		aru.close(em);
		
		return result;
	}

	@Override
	public boolean addModel(Article model) {
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		boolean result = aru.add(em, model);
		
		aru.close(em);
		
		return result;
	}

	@Override
	public Article selectByPrimaryKey(Long aid) {
		Article article = null;
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("ArticleDao.selectByPrimaryKey");
		
		article = aru.selectOne(em, jsql, aid);
		
		aru.close(em);
		
		return article;

	}

	@Override
	public int updateByPrimaryKey(Article model) {
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("ArticleDao.updateByPrimaryKey");
		
		int result = aru.update(em, jsql, 5, model.getTitle(),model.getDate(),model.getContent(),model.getCategory().getAcid(),model.getAid());
		
		if(model.getTags()!=null && model.getTags().size()>0) {
			aru.updateTags(em, model.getAid(), model.getTags());
		}
		
		aru.close(em);
		
		return result;
	}

	
	@Override
	public List<Article> findAll() {
		
		List<Article> reslList = null;
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("ArticleDao.findAll");
		
		reslList = aru.selectList(em, jsql);
		
		aru.close(em);
		
		return reslList;
	}

	@Override
	public List<Article> findAllByPage(Page page) {
		
		List<Article> reslList = null;
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("ArticleDao.findAll");
		
		reslList = aru.selectList(em, jsql, page);
		
		aru.close(em);
		
		return reslList;
	}
	
	@Override
	public List<Article> findAllByPageByKeyWord(String key, Page page) {
		
		List<Article> reslList = null;
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("ArticleDao.findAllByPageByKeyWord");
		
		reslList = aru.selectList(em, jsql, page, 1, key);
		
		aru.close(em);
		
		return reslList;
	}

	@Override
	public List<Article> findAllByPageByUser(Long uid) {
		
		List<Article> reslList = null;
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("ArticleDao.findAllByPageByUser");
		
		reslList = aru.selectList(em, jsql, uid);
		
		aru.close(em);
		
		return reslList;
	}

	@Override
	public long count() {
		
		long reslt = 0;
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("ArticleDao.count");
		
		reslt = aru.count(em, jsql);
		
		aru.close(em);
		
		return reslt;
	}

	@Override
	public long countByUser(Integer uid) {
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();

		String jsql = this.getjPQLUtils().getMap().get("ArticleDao.countByUser");
		
		long result = aru.count(em, jsql, 1, uid);
		
		aru.close(em);
		
		return result;
	}

	@Override
	public List<Article> findAllPageNoContent() {
		EntityManager em = this.getEntityManagerUtils().getEntityManager();

		String jsql = this.getjPQLUtils().getMap().get("ArticleDao.findAllPageNoContent");
		
		List<Article> result = aru.selectList(em, jsql);
		
		aru.close(em);

		return result;
	}

	@Override
	public List<Article> findAllPageNoContentByPage(Page page) {
		EntityManager em = this.getEntityManagerUtils().getEntityManager();

		String jsql = this.getjPQLUtils().getMap().get("ArticleDao.findAllPageNoContent");
		
		List<Article> result = aru.selectList(em, jsql, page);
		
		aru.close(em);

		return result;
	}

	@Override
	public boolean updateContent(Article article) {
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("ArticleDao.updateContent");
		
		int result = aru.update(em, jsql, 3, article.getContent(),new Date(),article.getAid());
		
		aru.close(em);
		
		if(result>0) {
			
			return true;
			
		}else {
			
			return false;
			
		}
		
	}

	@Override
	public boolean updateTitle(Article article) {
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("ArticleDao.updateTitle");
		
		int result = aru.update(em, jsql, 2, article.getTitle(),article.getAid());
		
		aru.close(em);
		
		if(result>0) {
			
			return true;
			
		}else {
			
			return false;
			
		}
	}

	@Override
	public boolean updateCategory(Article article) {
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("ArticleDao.updateCategory");
		
		int result = aru.update(em, jsql, 2, article.getCategory().getAcid(),article.getAid());
		
		aru.close(em);
		
		if(result>0) {
			
			return true;
			
		}else {
			
			return false;
			
		}
	}

	@Override
	public boolean addComments(Long aid,Comment comment) {
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		boolean flag = aru.addComment(em, aid, comment);
		
		aru.close(em);
		
		return flag;
	}

	@Override
	public boolean updateTags(Article article) {
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("ArticleDao.updateTags");
		
		int result = aru.update(em, jsql, 2, article.getTags(),article.getAid());
		
		aru.close(em);
		
		if(result>0) {
			
			return true;
			
		}else {
			
			return false;
			
		}
	}

	@Override
	public List<Article> tagFindArticle(Integer tid , Page page) {
		
		List<Article> reslList = null;
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("TagsDao.tagFindArticle");
		
		 //aru.selectList(em, jsql, 1, tid);
		reslList = aru.selectList(em, jsql, page, 1, tid);
		
		aru.close(em);
		
		return reslList;
	}

	@Override
	public List<Article> findAllByCategory(Integer acid, Page page) {
		List<Article> reslList = null;
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("ArticleDao.findAllByCategory");
		
		reslList = aru.selectList(em, jsql, page, 1, acid);
		
		aru.close(em);
		
		return reslList;
	}

	@Override
	public List<Article> findAllPageNoContentByPage(String key, Page page) {
		
		List<Article> reslList = null;
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("ArticleDao.findKeyNoContentByPage");
		
		reslList = aru.selectList(em, jsql, page, 1, key);
		
		aru.close(em);
		
		return reslList;
	}

	@Override
	public long countByKey(String key) {
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("ArticleDao.countByKey");
		
		long reslList = aru.count(em, jsql, 1, key);
		
		aru.close(em);
		
		return reslList;
	}
}
