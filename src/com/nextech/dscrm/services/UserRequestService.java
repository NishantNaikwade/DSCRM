package com.nextech.dscrm.services;

import java.util.List;

import com.nextech.dscrm.model.UserRequest;

public interface UserRequestService {

public	UserRequest findById(int id);
    
 public    Integer saveUserRequest(UserRequest userRequest);
     
 public   Integer updateUserRequest(UserRequest userRequest);
     
  public  Integer deleteUserRequest(int id);
 
 public   List<UserRequest> findAllUserRequests(); 
     
 public   UserRequest findUserRequestByMobileNumber(String ssn);
    
  public   List<UserRequest> findAllUserRequests(String userName);
    
    public long createUser(UserRequest userRequest);
 
}
