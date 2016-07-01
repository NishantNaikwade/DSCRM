package com.nextech.dscrm.services;

import com.nextech.dscrm.model.UserModel;

public interface UserService {
	public long createUserRegistration(UserModel userModel);
	
	public UserModel findById(int id);

	public Integer saveUser(UserModel userModel);
	
	public Integer updateUserModel(UserModel userModel);
	
	public Integer deleteUserModel(int id);
	
	boolean email_Unique(String email);

}
