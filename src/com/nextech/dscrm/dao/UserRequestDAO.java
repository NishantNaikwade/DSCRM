package com.nextech.dscrm.dao;

import java.sql.Timestamp;
import java.util.List;

import com.nextech.dscrm.model.UserRequest;

public interface UserRequestDAO {
	UserRequest findById(Integer id);

	Integer saveUserRequest(UserRequest userRequest);

	Integer updateUserRequest(UserRequest userRequest);

	Integer deleteUserRequest(int id);

	List<UserRequest> findAllUserRequests();

	List<UserRequest> findUserRequestByMobileNumber(String mobileNumber);

	List<UserRequest> findAllUserRequestsForUserName(String userName);

	List<UserRequest> findAllUserRequsetForTime(Timestamp userTime);

	public long createUser(UserRequest userRequest);
}
