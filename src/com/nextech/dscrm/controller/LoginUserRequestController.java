package com.nextech.dscrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextech.dscrm.model.LoginUserRequest;
import com.nextech.dscrm.services.LoginUserRequestServiceImpl;

@Controller
public class LoginUserRequestController {
	public LoginUserRequestController() {
		System.out.println("loginUserRequestController");
	}

	@Autowired
	LoginUserRequestServiceImpl loginUserRequestServiceImpl;

	@RequestMapping("/loginUserRequest")
	public String loginUserRequest(ModelMap modelMap) {
		LoginUserRequest loginUserRequest = new LoginUserRequest();
		modelMap.addAttribute("loginUserRequest", loginUserRequest);
		return "loginUserRequest";

	}

	@RequestMapping("/loginSaveUserRequest")
	public String loginSaveUserRequest(
			@ModelAttribute("loginUserRequest") LoginUserRequest loginUserRequest) {
		loginUserRequestServiceImpl.loginSaveUserRequest(loginUserRequest);
		return "loginSaveUserRequest";
	}

}
