package net.zhulan.coder.dao.implement;

import java.util.List;

import javax.persistence.EntityManager;

import net.zhulan.coder.dao.BaseDaoObject;
import net.zhulan.coder.dao.IUserDao;
import net.zhulan.coder.entity.User;
import net.zhulan.coder.utils.DaoUtils;

public class UserDaoImpl extends BaseDaoObject implements IUserDao {

	private DaoUtils<User> dao = new DaoUtils<>();

	public UserDaoImpl() {
	}

	@Override
	public boolean deleteByPrimaryKey(Long id) {

		return false;
	}

	@Override
	public boolean addModel(User model) {

		EntityManager em = this.getEntityManagerUtils().getEntityManager();

		boolean falg = dao.add(em, model);

		System.out.println(falg);
		
		dao.close(em);

		return falg;
	}

	@Override
	public User selectByPrimaryKey(Long id) {
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		String jsql = this.getjPQLUtils().getMap().get("UserDao.selectByPrimaryKey");
		User user = dao.selectOne(em, jsql, (long)id);
		dao.close(em);
		return user;
	}

	@Override
	public int updateByPrimaryKey(User model) {
		
		return 0;
	}

	@Override
	public List<User> findAll() {
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		String jsql = this.getjPQLUtils().getMap().get("UserDao.findAll");
		List<User> users = dao.selectList(em, jsql);
		dao.close(em);
		return users;
	}

	@Override
	public User findUserByUsername(String username, String password) {
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		String jsql = this.getjPQLUtils().getMap().get("UserDao.findUserByUsername");
		User user = dao.selectOne(em, jsql, 2, username, password);
		dao.close(em);
		return user;
	}

	@Override
	public User findUserByEmail(String email, String password) {
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		String jsql = this.getjPQLUtils().getMap().get("UserDao.findUserByEmail");
		User user = dao.selectOne(em, jsql, 2, email, password);
		dao.close(em);
		return user;
	}

	@Override
	public boolean disable(Long uid) {
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		String jsql = this.getjPQLUtils().getMap().get("UserDao.disable");
		int flag = dao.update(em, jsql, 1, uid);
		dao.close(em);
		if (flag > 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean enable(Long uid) {
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		String jsql = this.getjPQLUtils().getMap().get("UserDao.enable");
		int flag = dao.update(em, jsql, 1, uid);
		dao.close(em);
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User findUserByPhone(String phone, String password) {
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		String jsql = this.getjPQLUtils().getMap().get("UserDao.findUserByPhone");
		User user = dao.selectOne(em, jsql, 2, phone, password);
		dao.close(em);
		return user;
	}

	@Override
	public boolean checkUsername(String username) {
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();

		String jsql = this.getjPQLUtils().getMap().get("UserDao.checkUsername");

		boolean flag = dao.exist(em, jsql, 1, username);
		
		dao.close(em);
		
		return flag;

	}

	@Override
	public boolean checkEmail(String email) {
		EntityManager em = this.getEntityManagerUtils().getEntityManager();

		String jsql = this.getjPQLUtils().getMap().get("UserDao.checkEmail");

		boolean flag = dao.exist(em, jsql, 1, email);
		
		dao.close(em);
		
		return flag;
	}

	@Override
	public boolean checkPhone(String phone) {
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();

		String jsql = this.getjPQLUtils().getMap().get("UserDao.checkPhone");

		boolean flag = dao.exist(em, jsql, 1, phone);
		
		dao.close(em);
		
		return flag;
	}

	@Override
	public boolean updateUserPerminssion(Long uid, Integer pid) {
		EntityManager em = this.getEntityManagerUtils().getEntityManager();

		String jsql = this.getjPQLUtils().getMap().get("UserDao.updateUserPerminssion");

		int flag = dao.update(em, jsql, 2, pid,uid);
		
		dao.close(em);
		
		if(flag>0) {
			return true;
		}else {
			return false;
		}
		
		
	}

	@Override
	public boolean updateUserPassword(Long uid, String new_password) {
		
		EntityManager em = this.getEntityManagerUtils().getEntityManager();
		
		String jsql = this.getjPQLUtils().getMap().get("UserDao.updateUserPassword");
		
		
		int flag = dao.update(em, jsql, 2, new_password,uid);
		
		dao.close(em);
		
		if(flag>0) {
			return true;
		}else {
			return false;
		}
	}

}
