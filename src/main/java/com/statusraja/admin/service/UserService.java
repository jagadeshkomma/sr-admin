package com.statusraja.admin.service;

import com.statusraja.admin.model.User;

public interface UserService {

	User findUserByUserName(String username);
	
//	Users getUserById(Integer userId);
//	Users checkDynamicAccessCode(UsersDto userDto);
//	void updateUserInfo(UsersDto userDto);
//	void updateDynamicCode(String dynamicCode, UsersDto users);
//	boolean isUserExist(UsersDto user);
//	Integer saveUser(UsersDto usersDto,HttpServletRequest request);
//	Users getUserByUsernamePassword(UsersDto usersDto);
//	void updatedUserPassword(UsersDto users);
//	boolean checkOldPasssword(String oldpassword, Integer userId);
	
	//void updateProfileImg(UsersDto userDto);
}