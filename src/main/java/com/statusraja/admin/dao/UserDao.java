package com.statusraja.admin.dao;

import com.statusraja.admin.model.User;

public interface UserDao {

	public User findUserByUserName(String username);
	
//	public Users getUserById(Integer userId);
//
//	public Integer saveUser(Users info);
//
//	public boolean isUserExist(UsersDto user);
//	public Users getUserByUsernamePassword(UsersDto usersDto);
//	public Users checkDynamicAccessCode(UsersDto userDto);
//
//	public void updateUserInfo(UsersDto userDto);
//	public void updateDynamicCode(String dynamicCode, UsersDto users);
//
//	public void updatedUserPassword(UsersDto users);
//
//	public boolean checkOldPasssword(String oldpassword, Integer userId);
//
//	public void updateProfileImg(UsersDto userDto);
//
//	public Integer getMaxUserId();

}