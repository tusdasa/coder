package net.zhulan.coder.dao.implement;

import java.util.List;

import javax.persistence.EntityManager;

import net.zhulan.coder.dao.BaseDaoObject;
import net.zhulan.coder.dao.ITagsDao;
import net.zhulan.coder.entity.Tags;
import net.zhulan.coder.utils.DaoUtils;

public class TagsDaoImpl extends BaseDaoObject implements ITagsDao {
	
	private DaoUtils<Tags> dao = new DaoUtils<>();
	
	public TagsDaoImpl() {}

	@Override
	public boolean deleteByPrimaryKey(Integer id) {
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("TagsDao.deleteByPrimaryKey");
		
		boolean falg = dao.delete(em, jsql, id);
		
		dao.close(em);
		
		return falg;
		
	}

	@Override
	public boolean addModel(Tags model) {
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		boolean falg = dao.add(em, model);
		dao.close(em);
		return falg;
	}

	@Override
	public Tags selectByPrimaryKey(Integer id) {
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		String jsql = this.getjPQLUtils().getMap().get("TagsDao.selectByPrimaryKey");
		System.out.println(jsql);
		Tags tag = dao.selectOne(em, jsql, id);
		dao.close(em);
		return tag;
	}

	@Override
	public int updateByPrimaryKey(Tags model) {
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		String jsql = this.getjPQLUtils().getMap().get("TagsDao.updateByPrimaryKey");
		int tag = dao.update(em, jsql, 2, model.getContent(),model.getTid());
		dao.close(em);
		return tag;
	}

	@Override
	public List<Tags> findAll() {
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		String jsql = this.getjPQLUtils().getMap().get("TagsDao.findAll");
		List<Tags> result = dao.selectList(em, jsql);
		dao.close(em);
		return result;
	}

}
