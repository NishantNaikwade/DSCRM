package com.nextech.dscrm.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.nextech.dscrm.dao.UserDAOImpl;
import com.nextech.dscrm.model.UserModel;
public class UserServiceImpl implements UserService {
	public UserServiceImpl() {
		System.out.println("UserServiceImpl");
	}

	@Autowired
	UserDAOImpl userDAOImpl;

	@Override
	public UserModel findById(int id) {
		// TODO Auto-generated method stub
		return userDAOImpl.findById(id);
	}

	@Override
	public long createUserRegistration(UserModel userModel) {
		return userDAOImpl.createUserRegistration(userModel);
	}

	@Override
	public Integer saveUser(UserModel userModel) {
		// TODO Auto-generated method stub
		return userDAOImpl.saveUser(userModel);
	}

	@Override
	public Integer updateUserModel(UserModel userModel) {
		UserModel user = userDAOImpl.findById(userModel.getId());
		if (user != null) {
			user.setFirstname(userModel.getFirstname());
			user.setLastname(userModel.getLastname());
			user.setEmail(userModel.getEmail());
			user.setMobile(userModel.getMobile());
			user.setUserName(userModel.getUserName());
			user.setPassword(userModel.getPassword());
		}
		// TODO Auto-generated method stub
		return userDAOImpl.updateUserModel(userModel);
	}

	@Override
	public Integer deleteUserModel(int id) {
		// TODO Auto-generated method stub
		return userDAOImpl.deleteUserModel(id);
	}

	public boolean email_Unique(String email) {
		// TODO Auto-generated method stub
		return userDAOImpl.email_Unique(email);
	}

}
