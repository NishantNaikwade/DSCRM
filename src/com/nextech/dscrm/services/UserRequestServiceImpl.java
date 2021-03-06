package com.nextech.dscrm.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nextech.dscrm.dao.UserRequestDAOImpl;
import com.nextech.dscrm.model.UserRequest;

public class UserRequestServiceImpl implements UserRequestService {
	public UserRequestServiceImpl() {
		System.out.println("UserRequestServiceImpl()");
	}

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
		UserRequest user=userRequestDAOImpl.findById(userRequest.getId());
		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setMobile(userRequest.getMobile());
		user.setRequestStatus(userRequest.getRequestStatus());
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
	public List<UserRequest> findUserRequestByMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		return userRequestDAOImpl.findUserRequestByMobileNumber(mobileNumber);
	}

	@Override
	public List<UserRequest> findAllUserRequestsForUserName(String userName) {
		// TODO Auto-generated method stub
		return userRequestDAOImpl.findAllUserRequestsForUserName(userName);
	}

	@Override
	public List<UserRequest> findAllUserRequsetForTime(Timestamp userTime) {
		// TODO Auto-generated method stub
		return userRequestDAOImpl.findAllUserRequsetForTime(userTime);
	}

	@Override
	public long createUser(UserRequest userRequest) {
		return userRequestDAOImpl.createUser(userRequest);
	}
	
	public boolean updateUser(String id, UserRequest userRequest) {
		// TODO Auto-generated method stub
		return userRequestDAOImpl.updateUser(id,userRequest);
	}
	@Override
	 public UserRequest getUserRequest(int userid) {
		  return userRequestDAOImpl.getUserRequest(userid);
		 }
	public List<UserRequest> getUserReqById(Integer id) {
		// TODO Auto-generated method stub
		return userRequestDAOImpl.getUserReqById(id);
	}




}
