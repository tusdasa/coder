package net.zhulan.coder.dao;

import net.zhulan.coder.utils.EntityManagerUtils;
import net.zhulan.coder.utils.JPQLUtils;

public class BaseDaoObject {

	private EntityManagerUtils entityManagerUtils;
	private JPQLUtils jPQLUtils;
	
	
	public BaseDaoObject() {
	}

	public EntityManagerUtils getEntityManagerUtils() {
		return entityManagerUtils;
	}

	public void setEntityManagerUtils(EntityManagerUtils entityManagerUtils) {
		this.entityManagerUtils = entityManagerUtils;
	}

	public JPQLUtils getjPQLUtils() {
		return jPQLUtils;
	}

	public void setjPQLUtils(JPQLUtils jPQLUtils) {
		this.jPQLUtils = jPQLUtils;
	}
}
