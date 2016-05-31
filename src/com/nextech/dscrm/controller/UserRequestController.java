package com.nextech.dscrm.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nextech.dscrm.model.UserRequest;
import com.nextech.dscrm.services.UserRequestServiceImpl;

@Controller
public class UserRequestController {
	private static final Logger logger = Logger
			.getLogger(UserRequestController.class);

	public UserRequestController() {
		System.out.println("UserRequestController()");
	}

	@Autowired
	UserRequestServiceImpl userRequestServiceImpl;

	@RequestMapping("/userRequest")
	public String userRequest(ModelMap modelMap) {
		UserRequest userRequest = new UserRequest();
		modelMap.addAttribute("userRequest", userRequest);
		return "userRequest";
	}

	@RequestMapping("/saveUserRequest")
	public String saveUserRequest(
			@ModelAttribute("userRequest") UserRequest userRequest) {
		// UserRequest userRequest = (UserRequest) modelMap.get("userRequest");
		userRequestServiceImpl.saveUserRequest(userRequest);
		return "saveUserRequest";
	}

	@RequestMapping("/viewAllUserRequests")
	public String viewAllUserRequests(ModelMap modelMap) {

		modelMap.addAttribute("userRequests",
				userRequestServiceImpl.findAllUserRequests());
		return "viewAllUserRequests";
	}

	@RequestMapping("/deleteUserRequest")
	public ModelAndView deleteUserRequest(@RequestParam long id) {
		logger.info("Deleting the UserRequest. Id : " + id);
		userRequestServiceImpl.deleteUserRequest((int) id);
		return new ModelAndView("redirect:findAllUserRequests");
	}

	@RequestMapping("/searchUser")
	public ModelAndView searchUser(@RequestParam("searchName") String searchName) {
		logger.info("Searching the UserRequest.UserRequest Names: "
				+ searchName);
		List<UserRequest> userList = userRequestServiceImpl
				.findAllUserRequests(searchName);
		return new ModelAndView("userList", "userList", userList);
	}

	@RequestMapping("/createUser")
	public ModelAndView createUser(@ModelAttribute UserRequest userRequest) {
		logger.info("Creating UserRequest. Data: " + userRequest);
		return new ModelAndView("userRequest");
	}

}
