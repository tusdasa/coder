package net.zhulan.coder.dao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;
import net.zhulan.coder.dao.IArticleCategoryDao;
import net.zhulan.coder.entity.ArticleCategory;

public class TestArticleCategoryDaoImpl extends TestCase {
	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationcontext.xml");
	private IArticleCategoryDao acd = (IArticleCategoryDao) ac.getBean("articleCategoryDao");
	
	public void testDeleteByPrimaryKey() {
		acd.deleteByPrimaryKey(CodeUtils.getRandomInt());
	}

	public void testAddModel() {
		ArticleCategory ac = new ArticleCategory();
		ac.setAcid(20);
		ac.setAcname("未分类"+CodeUtils.getRandom());
		acd.addModel(ac);
		
	}

	public void testSelectByPrimaryKey() {
		acd.selectByPrimaryKey(8);
		
	}

	public void testUpdateByPrimaryKey() {
		ArticleCategory ac = new ArticleCategory();
		ac.setAcid(13);
		ac.setAcname("未分类"+CodeUtils.getRandom());
		acd.updateByPrimaryKey(ac);
		
	}

	public void testFindAll() {
		acd.findAll();
		
	}

	public void testCount() {
		acd.count();
		
	}

	public void testCountByCategory() {
		acd.countByCategory(3);
		
	}

}
