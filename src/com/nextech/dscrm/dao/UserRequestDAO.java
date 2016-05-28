package com.nextech.dscrm.dao;

import java.util.List;

import com.nextech.dscrm.model.UserRequest;

public interface UserRequestDAO {
	UserRequest findById(Integer id);

	Integer saveUserRequest(UserRequest userRequest);

	Integer updateUserRequest(UserRequest userRequest);

	Integer deleteUserRequest(int id);

	List<UserRequest> findAllUserRequests();

	UserRequest findUserRequestByMobileNumber(String ssn);

}
