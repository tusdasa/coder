package net.zhulan.coder.dao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;
import net.zhulan.coder.dao.ITagsDao;
import net.zhulan.coder.entity.Tags;

public class TestTagsDaoImpl extends TestCase {
	
	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationcontext.xml");
	
	private ITagsDao td = (ITagsDao) ac.getBean("tagsDao");
	
	public void testDeleteByPrimaryKey() {
		td.deleteByPrimaryKey(9);
	}

	public void testAddModel() {
		Tags t = new Tags(CodeUtils.getRandom());
		td.addModel(t);
	}

	public void testSelectByPrimaryKey() {
		td.selectByPrimaryKey(1);
	}

	public void testUpdateByPrimaryKey() {
		Tags t = new Tags(CodeUtils.getRandom());
		t.setTid(3);
		td.updateByPrimaryKey(t);
	}

	public void testFindAll() {
		td.findAll();
	}

}
