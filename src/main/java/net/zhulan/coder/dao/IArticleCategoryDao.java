package net.zhulan.coder.dao;

import net.zhulan.coder.entity.ArticleCategory;

public interface IArticleCategoryDao extends IBaseDao<ArticleCategory, Integer> {
	long count();
	long countByCategory(Integer acid);
}
