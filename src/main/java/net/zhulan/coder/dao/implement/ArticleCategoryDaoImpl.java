package net.zhulan.coder.dao.implement;

import java.util.List;

import javax.persistence.EntityManager;

import net.zhulan.coder.dao.BaseDaoObject;
import net.zhulan.coder.dao.IArticleCategoryDao;
import net.zhulan.coder.entity.ArticleCategory;
import net.zhulan.coder.utils.DaoUtils;

public class ArticleCategoryDaoImpl extends BaseDaoObject implements IArticleCategoryDao {
	
	private DaoUtils<ArticleCategory> dao = new DaoUtils<>();
	
	public ArticleCategoryDaoImpl() {}

	@Override
	public boolean deleteByPrimaryKey(Integer acid) {
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("ArticleCategoryDao.deleteByPrimaryKey");
		
		boolean result = dao.delete(em, jsql, acid);
		
		dao.close(em);
		
		return result;

	}

	@Override
	public boolean addModel(ArticleCategory model) {
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		boolean result =  dao.add(em, model);
		
		dao.close(em);
		
		return result;
	}

	@Override
	public ArticleCategory selectByPrimaryKey(Integer acid) {
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("ArticleCategoryDao.selectByPrimaryKey");
		
		ArticleCategory ac = dao.selectOne(em, jsql, acid);
		
		return ac;
	}

	@Override
	public int updateByPrimaryKey(ArticleCategory model) {
		
		int result = 0;
		
		if(model.getAcid()==0) {
			return 0;
		}
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("ArticleCategoryDao.updateByPrimaryKey");
		
		result = dao.update(em, jsql, 2, model.getAcname(),model.getAcid());
		
		return result;
	}

	@Override
	public List<ArticleCategory> findAll() {
		
		List<ArticleCategory> result = null;
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("ArticleCategoryDao.findAll");
		
		result = dao.selectList(em, jsql);
		
		return result;
	}

	@Override
	public long count() {
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();

		String jsql = this.getjPQLUtils().getMap().get("ArticleCategoryDao.count");
		
		long result = dao.count(em, jsql);
		
		dao.close(em);
		
		return result;
	}

	@Override
	public long countByCategory(Integer acid) {
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();

		String jsql = this.getjPQLUtils().getMap().get("ArticleCategoryDao.countByCategory");
		
		long result = dao.count(em, jsql, 1, acid);
		
		dao.close(em);
		
		return result;
	}

}
