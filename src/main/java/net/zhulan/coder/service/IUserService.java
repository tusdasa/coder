package net.zhulan.coder.service;

import java.util.List;

import net.zhulan.coder.entity.Permission;
import net.zhulan.coder.entity.User;

public interface IUserService {
	boolean addUser(User user);
	boolean diseble(Long uid);
	boolean enable(Long uid);
	boolean upUserPassword(Long uid ,String new_password);
	User loginByUsername(String username ,String password);
	User loginByEmail(String email ,String password);
	User loginByPhone(String phone ,String password);
	List<Permission> findAllPermission();
	List<User> findAll();
	boolean cheackUsername(String username);
	boolean cheackNumber(String number);
	boolean cheackEmail(String email);
	boolean upPermission(long uid, int pid);
}
