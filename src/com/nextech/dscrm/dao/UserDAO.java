package com.nextech.dscrm.dao;

import com.nextech.dscrm.model.UserModel;

public interface UserDAO {
	public long createUserRegistration(UserModel userModel);

	Integer saveUser(UserModel userModel);

	Integer updateUserModel(UserModel userModel);

	Integer deleteUserModel(int id);

	UserModel findById(Integer id);

	boolean email_Unique(String email);

}
