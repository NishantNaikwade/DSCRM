package com.nextech.dscrm.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.nextech.dscrm.dao.LoginUserRequestDAOImpl;

import com.nextech.dscrm.model.LoginUserRequest;

public class LoginUserRequestServiceImpl implements LoginUserRequestService {
	@Autowired
	LoginUserRequestDAOImpl loginUserRequestDAOImpl;

	@Override
	public Integer loginSaveUserRequest(LoginUserRequest loginUserRequest) {
		// TODO Auto-generated method stub
		return loginUserRequestDAOImpl.loginSaveUserRequest(loginUserRequest);
	}

}
