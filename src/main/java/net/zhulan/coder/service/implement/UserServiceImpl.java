package net.zhulan.coder.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zhulan.coder.dao.IPermissionDao;
import net.zhulan.coder.dao.IUserDao;
import net.zhulan.coder.entity.Permission;
import net.zhulan.coder.entity.User;
import net.zhulan.coder.service.IUserService;
import net.zhulan.coder.utils.MD5Encrypt;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IPermissionDao permissionDao;
	@Autowired
	private IUserDao userDao;
	
	
	public UserServiceImpl() {}

	@Override
	public boolean addUser(User user) {
		Permission permission = new Permission();
		//设置注册用户无发表权限
		permission.setPid(3);
		user.setPermission(permission);
		String en = user.getPassword();
		user.setPassword(MD5Encrypt.Encrypt(en));
		return userDao.addModel(user);
	}

	@Override
	public boolean diseble(Long uid) {
		if(uid==1) {
			return false;
		}
		return userDao.disable(uid);
	}

	@Override
	public boolean enable(Long uid) {
		if(uid==1) {
			return false;
		}
		return userDao.enable(uid);
	}

	@Override
	public boolean upUserPassword(Long uid, String new_password) {
		return userDao.updateUserPassword(uid, MD5Encrypt.Encrypt(new_password));
	}

	@Override
	public User loginByUsername(String username, String password) {
		return userDao.findUserByUsername(username, MD5Encrypt.Encrypt(password));
	}

	@Override
	public User loginByEmail(String email, String password) {
		return userDao.findUserByEmail(email, MD5Encrypt.Encrypt(password));
	}

	@Override
	public User loginByPhone(String phone, String password) {
		return userDao.findUserByPhone(phone, MD5Encrypt.Encrypt(password));
	}

	@Override
	public List<Permission> findAllPermission() {
		return permissionDao.findAll();
	}

	@Override
	public boolean cheackUsername(String username) {
		return userDao.checkUsername(username);
	}

	@Override
	public boolean cheackNumber(String number) {
		
		return userDao.checkPhone(number);
	}

	@Override
	public boolean cheackEmail(String email) {
		
		return userDao.checkEmail(email);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public boolean upPermission(long uid, int pid) {
		return userDao.updateUserPerminssion(uid, pid);
	}

}
