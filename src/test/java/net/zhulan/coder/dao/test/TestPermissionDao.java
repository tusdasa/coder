package net.zhulan.coder.dao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;
import net.zhulan.coder.dao.IPermissionDao;

public class TestPermissionDao extends TestCase {

	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationcontext.xml");
	private IPermissionDao pd = (IPermissionDao) ac.getBean("permissionDao");
	
	public void testFindAll() {
		pd.findAll();
	}

}
