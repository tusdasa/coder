package net.zhulan.coder.utils;

import java.util.List;

import javax.persistence.Query;

import net.zhulan.coder.entity.Page;

import javax.persistence.EntityTransaction;
import javax.persistence.EntityManager;

public class DaoUtils<Model> {

	public DaoUtils() {}

	@SuppressWarnings("unchecked")
	public Model selectOne(EntityManager em, String jsql, Integer id) {

		Model model = null;

		Query query = em.createQuery(jsql);

		try {

			query.setParameter(1, id);

			model = (Model) query.getSingleResult();

			if (model == null) {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
		return model;
	}
	@SuppressWarnings("unchecked")
	public Model selectOne(EntityManager em, String jsql, Long id) {

		Model model = null;

		Query query = em.createQuery(jsql);

		try {

			query.setParameter(1, id);

			model = (Model) query.getSingleResult();

			if (model == null) {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
		return model;
	}
	@SuppressWarnings("unchecked")
	public List<Model> selectList(EntityManager em, String jsql, Long id) {

		List<Model> model = null;

		Query query = em.createQuery(jsql);

		try {

			query.setParameter(1, id);

			model = query.getResultList();

			if (model == null) {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
		return model;
	}
	@SuppressWarnings("unchecked")
	public Model selectOne(EntityManager em, String jsql, int size, Object... objects) {

		Model model = null;

		Query query = em.createQuery(jsql);

		try {

			for (int i = 0; i < size; i++) {
				query.setParameter(i + 1, objects[i]);
			}

			model = (Model) query.getSingleResult();

			if (model == null) {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
		return model;
	}

	@SuppressWarnings("unchecked")
	public List<Model> selectList(EntityManager em, String jsql) {

		List<Model> model = null;

		Query query = em.createQuery(jsql);

		try {

			model = query.getResultList();

			if (model == null) {
				return null;
			}

		} catch (Exception e) {
			return null;
		}
		return model;
	}

	@SuppressWarnings("unchecked")
	public List<Model> selectList(EntityManager em, String jsql, Page page) {
		
		List<Model> model = null;

		Query query = em.createQuery(jsql);

		try {
			model = query.setMaxResults(page.getPageSize())
					.setFirstResult(page.getPageSize() * page.getPageNum())
					.getResultList();
			if (model == null) {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
		return model;
	}

	@SuppressWarnings("unchecked")
	public List<Model> selectList(EntityManager em, String jsql, int size, Object... objects) {
		List<Model> model = null;

		Query query = em.createQuery(jsql);

		try {
			for (int i = 0; i < size; i++) {
				query.setParameter(i + 1, objects[i]);
			}
			model = query.getResultList();
			if (model == null) {
				return null;
			}
		} catch (Exception e) {

			return null;

		}
		return model;
	}

	@SuppressWarnings("unchecked")
	public List<Model> selectList(EntityManager em, String jsql, Page page, int size, Object... objects) {
		List<Model> model = null;

		Query query = em.createQuery(jsql);

		try {
			for (int i = 0; i < size; i++) {
				query.setParameter(i + 1, objects[i]);
			}
			model = query.setMaxResults(page.getPageSize()).setFirstResult(page.getPageSize() * page.getPageNum())
					.getResultList();
			if (model == null) {
				return null;
			}
		} catch (Exception e) {

			return null;

		}
		return model;
	}

	public boolean delete(EntityManager em, String jsql, Integer id) {

		int result = 0;

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		Query query = em.createQuery(jsql);

		try {
			query.setParameter(1, id);

			result = query.executeUpdate();

			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			return false;
		}
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean delete(EntityManager em, String jsql, Long id) {

		int result = 0;

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		Query query = em.createQuery(jsql);

		try {
			query.setParameter(1, id);

			result = query.executeUpdate();

			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			return false;
		}
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean delete(EntityManager em, String jsql, int size, Object... objects) {
		int result = 0;

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		Query query = em.createQuery(jsql);

		try {
			
			for(int i = 0 ; i<objects.length ;i++) {
				query.setParameter(i+1, objects[i]);
			}

			result = query.executeUpdate();

			transaction.commit();
			
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			return false;
		}
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	public int update(EntityManager em, String jsql, int size, Object... objects) {
		int result = 0;
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Query query = em.createQuery(jsql);
		try {
			for (int i = 0; i < size; i++) {
				query.setParameter(i + 1, objects[i]);
			}
			result = query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			return result;
		}
		return result;
	}

	public boolean add(EntityManager em, Model model) {

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		try {

			em.persist(model);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			return false;
		}
		return true;
	}
	
	public long count(EntityManager em, String jsql) {
		long result = 0;

		Query query = em.createQuery(jsql);

		try {
			
			result = (long) query.getSingleResult();
			
		} catch (Exception e) {
			
			return 0;
			
		}
		return result;
	}
	
	public long count(EntityManager em, String jsql, int size, Object... objects) {
		long result = 0;

		Query query = em.createQuery(jsql);

		try {
			
			for(int i=0 ; i < size;i++) {
				query.setParameter(i+1, objects[i]);
			}
			
			result = (long) query.getSingleResult();
			
		} catch (Exception e) {
			
			return 0;
			
		}
		return result;
	}
	
	public boolean exist(EntityManager em, String jsql, int size, Object... objects) {
		
		Query query = em.createQuery(jsql);
		
		try {
			
			for(int i=0 ; i < size;i++) {
				query.setParameter(i+1, objects[i]);
			}
			
			long result = query.getResultList().size();
			
			if(result==0) {
				return true;
			}
			
		} catch (Exception e) {
			
			return false;
			
		}
		return false;
	}

	public void close(EntityManager entityManager) {
		entityManager.close();
	}

}
