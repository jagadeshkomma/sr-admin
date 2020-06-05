package com.statusraja.admin.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.statusraja.admin.dao.GenericDao;
import com.statusraja.admin.dao.UserDao;
import com.statusraja.admin.model.User;

@Service
@Transactional
public class UserServiceImpl  implements UserService {

	@Autowired
	private  UserDao userDao;
	
	
	
	@Autowired 
	GenericDao<User> genericDao;
	
	@Override
	public User findUserByUserName(String username) {
		return userDao.findUserByUserName(username);
	}

//	@Override
//	public Users getUserById(Integer userId) {
//		return genericDao.findOne(userId.longValue());
//	}
//	
//	
//	@Override
//	public Integer saveUser(UsersDto users,HttpServletRequest request) {
//		
//		
//		Integer  userId=userDao.saveUser(userFunction.apply(users));
//		
//		/*List<FolderInfo> folderlist=new ArrayList<>();
//		FolderInfo newFolder =new FolderInfo();
//		newFolder.setfId(0);
//		newFolder.setfName("");
//		newFolder.setParentId(0);
//		newFolder.setFolderNamePath("home");
//		newFolder.setFolderPath("/"+userId+"/"+newFolder.getfId()+"/");
//		newFolder.setFolderStatus(DigiLockerStatusEnum.ACTIVE.toString());
//		newFolder.setOrigin("LOCKER");
//		newFolder.setChildFolders(null);
//		newFolder.setLocalFilesInfo(new ArrayList<FilesInfo>());
//		
//
//		
//		//Gallery defalut doc creating 
//		FolderInfo galFolder =new FolderInfo();
//		galFolder.setfId(99999);
//		galFolder.setfName("Gallery");
//		galFolder.setParentId(0);
//		galFolder.setFolderNamePath("home/"+galFolder.getfName());
//		galFolder.setFolderPath("/"+userId+"/"+galFolder.getfId()+"/");
//		galFolder.setFolderStatus(DigiLockerStatusEnum.ACTIVE.toString());
//		galFolder.setOrigin("GALLERY");
//		galFolder.setChildFolders(null);
//		galFolder.setLocalFilesInfo(new ArrayList<FilesInfo>());
//		
//		folderlist.add(newFolder);
//		folderlist.add(galFolder);
//		
//		digilockerService.storeFolderInfo(folderlist,  userId);*/
//		
//		return userId;
//	}
//
//	Predicate<Integer>	userIdCheck= (userId) -> userId!=null;
//	
//	Function<UsersDto,Users> userFunction = (users) -> {
//		Users info=new Users();
//		Integer userid=userDao.getMaxUserId();
//		if(userIdCheck.test(userid))
//			info.setUserId(userid+1);
//		else
//			info.setUserId(50000);
////		info.setFirstname(users.getFirstname());
////		info.setLastname(users.getLastname());
////		info.setMobile_no(users.getMobile_no());
////		//info.setDateofbirth(stringtoDate(users.getBirthday_year()+"-"+users.getBirthday_month()+"-"+users.getBirthday_date()));
////		info.setEmail(users.getEmail());
////		info.setPassword(users.getPassword());
////		info.setUserName(users.getMobile_no());
////		info.setCountry(users.getCountry());
////		info.setState(users.getState());
////		info.setCity(users.getCity());
////		info.setPhoneNumber(users.getPhoneNumber());
////		info.setZipCode(users.getZipCode());
////		info.setCreatedDate(new Date());
////		info.setGender(users.getGender());
////		Integer day=Integer.valueOf(users.getBirthday_date());
////		Integer year=Integer.valueOf(users.getBirthday_year());
////		info.setDateofbirth(day+"-"+users.getBirthday_month()+"-"+year);
////		info.setUserRole("ROLE_CUSTOMER");
////		List<Role> roles=new ArrayList<>();
////		Role role=new Role();
////		role.setRoleName("ROLE_CUSTOMER");
////		role.setRoleId(2);
////		roles.add(role);
////		info.setRoles(roles);
//		
//		return info;
//	};
//	
//	
//	
//	@Override
//	public boolean isUserExist(UsersDto user) {
//		return userDao.isUserExist(user);
//	}
//	
//	@Override
//	public Users getUserByUsernamePassword(UsersDto usersDto) {
//		return userDao.getUserByUsernamePassword(usersDto);
//	}
//	
//	@Override
//	public void updateDynamicCode(String dynamicCode,UsersDto users) {
//		userDao.updateDynamicCode(dynamicCode,users);		
//	}
//
//	
//	@Override
//	public Users checkDynamicAccessCode(UsersDto userDto) {
//		return userDao.checkDynamicAccessCode(userDto);
//	}
//
//	@Override
//	public void updateUserInfo(UsersDto userDto) {
//		userDao.updateUserInfo(userDto);
//	}
//
//
//	
//	/*public  synchronized Integer gerUniqueKey(HttpServletRequest request){
//		int newValue=0;
//		Properties properties = new Properties();
//		try(InputStream input = request.getServletContext().getResourceAsStream("/WEB-INF/uniquekey.properties");){
//			properties.load(input);
//			String uniqueKey=properties.getProperty("uniqueId");
//			newValue= Integer.parseInt(uniqueKey)+1;
//			properties.setProperty("uniqueId", ""+newValue);
//			properties.store(new FileOutputStream(request.getServletContext().getRealPath("/WEB-INF/uniquekey.properties")),null);
//		}catch(Exception e){
//			properties = null;
//		}
//		
//		return newValue;
//	}*///closing
//
//	@Override
//	public void updatedUserPassword(UsersDto users) {
//		userDao.updatedUserPassword(users);
//	}
//
//	@Override
//	public boolean checkOldPasssword(String oldpassword,Integer userId) {
//		return userDao.checkOldPasssword(oldpassword,userId);
//	}

//	@Override
//	public void updateProfileImg(UsersDto userDto) {
//		String fileURL=null;
//		 if (Objects.nonNull(userDto.getFile())) {
//			 fileURL =fileUploadServices.uploadWebDavServer2(userDto.getFile(),null);
//		 }
//		 userDto.setProfileImage(fileURL);
//		 userDao.updateProfileImg(userDto);
//		
//	}
	
}
