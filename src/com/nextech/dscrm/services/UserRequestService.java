package com.nextech.dscrm.services;

import java.util.List;

import com.nextech.dscrm.model.UserRequest;

public interface UserRequestService {

	UserRequest findById(int id);
    
    Integer saveUserRequest(UserRequest userRequest);
     
    Integer updateUserRequest(UserRequest userRequest);
     
    Integer deleteUserRequest(int id);
 
    List<UserRequest> findAllUserRequests(); 
     
    UserRequest findUserRequestByMobileNumber(String ssn);
 
}
