package net.zhulan.coder.dao.implement;

import java.util.List;

import javax.persistence.EntityManager;

import net.zhulan.coder.dao.BaseDaoObject;
import net.zhulan.coder.dao.IPermissionDao;
import net.zhulan.coder.entity.Permission;
import net.zhulan.coder.utils.DaoUtils;

public class PermissionDaoImp extends BaseDaoObject implements IPermissionDao {

	private DaoUtils<Permission> dao = new DaoUtils<>();
	
	public PermissionDaoImp() {}

	@Override
	public boolean deleteByPrimaryKey(Integer id) {
		
		return false;
	}

	@Override
	public boolean addModel(Permission model) {
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		boolean falg = dao.add(em, model);
		
		dao.close(em);
		
		return falg;
		
	}

	@Override
	public Permission selectByPrimaryKey(Integer pid) {
		
		return null;
	}

	@Override
	public int updateByPrimaryKey(Permission model) {
		
		return 0;
	}

	@Override
	public List<Permission> findAll() {
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();

		String jsql = this.getjPQLUtils().getMap().get("PermissionDao.findAll");
		
		List<Permission> pre = dao.selectList(em, jsql);
		
		dao.close(em);
		
		return pre;
	}

}
