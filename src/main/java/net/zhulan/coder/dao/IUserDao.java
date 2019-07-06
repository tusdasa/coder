package net.zhulan.coder.dao;

import net.zhulan.coder.entity.User;

public interface IUserDao extends IBaseDao<User, Long> {
	User findUserByUsername(String username,String password);
	User findUserByEmail(String email,String password);
	User findUserByPhone(String phone,String password);
	boolean disable(Long uid);
	boolean enable(Long uid);
	boolean checkUsername(String username);
	boolean checkEmail(String email);
	boolean checkPhone(String phone);
	boolean updateUserPerminssion(Long uid, Integer pid);
	boolean updateUserPassword(Long uid,String new_password);
}
