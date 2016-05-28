package com.nextech.dscrm.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nextech.dscrm.dao.UserRequestDAOImpl;
import com.nextech.dscrm.model.UserRequest;

public class UserRequestServiceImpl implements UserRequestService{

	@Autowired
	UserRequestDAOImpl userRequestDAOImpl;
	
	@Override
	public UserRequest findById(int id) {
		// TODO Auto-generated method stub
		return userRequestDAOImpl.findById(id);
	}

	@Override
	public Integer saveUserRequest(UserRequest userRequest) {
		// TODO Auto-generated method stub
		return userRequestDAOImpl.saveUserRequest(userRequest);
	}

	@Override
	public Integer updateUserRequest(UserRequest userRequest) {
		// TODO Auto-generated method stub
		return userRequestDAOImpl.updateUserRequest(userRequest);
	}

	@Override
	public Integer deleteUserRequest(int id) {
		// TODO Auto-generated method stub
		return userRequestDAOImpl.deleteUserRequest(id);
	}

	@Override
	public List<UserRequest> findAllUserRequests() {
		// TODO Auto-generated method stub
		return userRequestDAOImpl.findAllUserRequests();
	}

	@Override
	public UserRequest findUserRequestByMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		return userRequestDAOImpl.findUserRequestByMobileNumber(mobileNumber);
	}


}
