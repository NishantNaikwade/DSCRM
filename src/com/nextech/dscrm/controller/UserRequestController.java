package com.nextech.dscrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextech.dscrm.model.UserRequest;
import com.nextech.dscrm.services.UserRequestServiceImpl;

@Controller
public class UserRequestController {

	@Autowired 
	UserRequestServiceImpl userRequestServiceImpl;
	
	@RequestMapping("/userRequest")
	public String userRequest(ModelMap modelMap){
		UserRequest userRequest = new UserRequest();
		modelMap.addAttribute("userRequest", userRequest);
		return "userRequest";
	}
	@RequestMapping("/saveUserRequest")
	public String saveUserRequest(@ModelAttribute("userRequest")UserRequest userRequest){
//		UserRequest userRequest = (UserRequest) modelMap.get("userRequest");
		userRequestServiceImpl.saveUserRequest(userRequest);
		return "saveUserRequest";
	}
	
	@RequestMapping("/viewAllUserRequests")
	public String viewAllUserRequests(ModelMap modelMap){
		
		modelMap.addAttribute("userRequests", userRequestServiceImpl.findAllUserRequests());
		return "viewAllUserRequests";
	}
}
