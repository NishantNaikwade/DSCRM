package com.nextech.dscrm.services;

import java.sql.Timestamp;
import java.util.List;

import com.nextech.dscrm.model.UserRequest;

public interface UserRequestService {

	public UserRequest findById(int id);

	public Integer saveUserRequest(UserRequest userRequest);

	public Integer updateUserRequest(UserRequest userRequest);

	public Integer deleteUserRequest(int id);

	public List<UserRequest> findAllUserRequests();
	
	public List<UserRequest> findUserRequestByMobileNumber(String mobileNumber);

	public List<UserRequest> findAllUserRequestsForUserName(String userName);

	public List<UserRequest> findAllUserRequsetForTime(Timestamp userTime);

	public long createUser(UserRequest userRequest);
	
}
