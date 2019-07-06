package net.zhulan.coder.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtils {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("code");;
	
	public EntityManagerUtils() {}

	public EntityManagerFactory getFactory() {
		return factory;
	}
	
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
