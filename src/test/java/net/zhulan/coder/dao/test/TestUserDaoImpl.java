package net.zhulan.coder.dao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;
import net.zhulan.coder.dao.IUserDao;
import net.zhulan.coder.entity.Permission;
import net.zhulan.coder.entity.User;

public class TestUserDaoImpl extends TestCase {
	
	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationcontext.xml");
	
	private IUserDao ud = (IUserDao) ac.getBean("userDao");
	
	public void testAddModel() {
		User user = new User();
		user.setEmail(CodeUtils.getRandom());
		user.setNumber(CodeUtils.getRandom());
		user.setPassword(CodeUtils.getRandom());
		Permission r = new Permission();
		r.setPid(1);
		user.setPermission(r);
		user.setStatus(1);
		user.setUsername(CodeUtils.getRandom());
		ud.addModel(user);
	}

	public void testSelectByPrimaryKey() {
		ud.selectByPrimaryKey(1L).getEmail();
	}

	public void testUpdateByPrimaryKey() {
		User user = new User();
		user.setEmail(CodeUtils.getRandom());
		user.setNumber(CodeUtils.getRandom());
		user.setPassword(CodeUtils.getRandom());
		Permission rr = new Permission();
		rr.setPid(1);
		user.setPermission(rr);
		user.setStatus(1);
		user.setUsername(CodeUtils.getRandom());
		ud.updateByPrimaryKey(user);
	}

	public void testFindAll() {
		System.out.println(ud.findAll().size());
	}

	public void testFindUserByUsername() {
		if(ud.findUserByUsername("admin", "1234")!=null) {
			System.out.println("success");
		}else {
			fail("Not yet implemented");
		}
	}

	public void testFindUserByEmail() {
		if(ud.findUserByEmail("tusdasa@163.com", "1234")!=null) {
			System.out.println("success");
		}else {
			fail("Not yet implemented");
		}
	}

	public void testDisable() {
		System.out.println(ud.disable(1L));
	}

	public void testEnable() {
		System.out.println(ud.enable(1L));
	}

	public void testFindUserByPhone() {
		if(ud.findUserByPhone("15719161970", "1234")!=null) {
			System.out.println("success");
		}else {
			fail("Not yet implemented");
		}
	}

	public void testCheckUsername() {
		System.out.println(ud.checkUsername("admin"));
	}

	public void testCheckEmail() {
		System.out.println(ud.checkEmail("tusdasa@163.com"));
	}

	public void testCheckPhone() {
		System.out.println(ud.checkPhone("15719161970"));
	}
}
