package net.zhulan.coder.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<Model, PK extends Serializable> {
	
	boolean deleteByPrimaryKey(PK id);
	
	boolean addModel(Model model);
	
	Model selectByPrimaryKey(PK id);
	
	int updateByPrimaryKey(Model model);
	
	List<Model> findAll();
	
}
