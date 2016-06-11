package com.nextech.dscrm.controller;

import java.sql.Timestamp;
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
	@RequestMapping("/updateUserRequest")
	public String updateUserRequest(@ModelAttribute("userRequest") UserRequest userRequest){
		userRequestServiceImpl.updateUserRequest(userRequest);
		return "updateUserRequest";
	}

	@RequestMapping("/viewAllUserRequests")
	public String viewAllUserRequests(ModelMap modelMap) {
		List<UserRequest> viewAllUserRequests = userRequestServiceImpl
				.findAllUserRequests();
		System.out.println("viewAllUserRequests size : "
				+ viewAllUserRequests.size());
		modelMap.addAttribute("userRequests", viewAllUserRequests);
		return "viewAllUserRequests";
	}

	@RequestMapping("/deleteUserRequest")
	public ModelAndView deleteUserRequest(@RequestParam long id) {
		logger.info("Deleting the UserRequest. Id : " + id);
		userRequestServiceImpl.deleteUserRequest((int) id);
		return new ModelAndView("redirect:findAllUserRequests");
	}

	@RequestMapping("/searchUser")
	public String searchUser(
			@RequestParam("searchTypeDropdown") String searchTypeDropdown,
			@RequestParam("searchUsers") String searchUsers, ModelMap modelMap) {
		System.out.println("in searchUser......");
		logger.info("Searching the UserRequest.UserRequest Names : "
				+ searchUsers);
		List<UserRequest> viewAllUserRequests = userRequestServiceImpl
				.findAllUserRequestsForUserName(searchUsers);
		System.out.println("viewAllUserRequests size : "
				+ viewAllUserRequests.size());
		modelMap.addAttribute("userRequests", viewAllUserRequests);
		return "viewAllUserRequests";
	}

	@RequestMapping("/searchUserByTime")
	public String searchUserByTime(
			@RequestParam("searchTypeDropdown") String searchTypeDropdown,
			@RequestParam("searchUsers") Timestamp searchUsers,
			ModelMap modelMap) {
		System.out.println("in searchUserByTime......");
		logger.info("Searching the UserRequest.UserRequest Times: "
				+ searchUsers);
		List<UserRequest> viewAllUserRequests = userRequestServiceImpl
				.findAllUserRequsetForTime(searchUsers);
		System.out.println("viewAllUserRequests size : "
				+ viewAllUserRequests.size());
		modelMap.addAttribute("userRequests", viewAllUserRequests);
		return "viewAllUserRequests";
	}

	@RequestMapping("/searchUserByMobile")
	public String searchUserByMobile(
			@RequestParam("searchTypeDropdown") String searchTypeDropdown,
			@RequestParam("searchUsers") String searchUsers, ModelMap modelMap) {
		System.out.println("in searchUserByMobile......");
		logger.info("Searching the UserRequest.UserRequest Mobiles : "
				+ searchUsers);
		List<UserRequest> viewAllUserRequests = userRequestServiceImpl
				.findUserRequestByMobileNumber(searchUsers);
		System.out.println("viewAllUserRequests size : "
				+ viewAllUserRequests.size());
		modelMap.addAttribute("userRequests", viewAllUserRequests);
		return "viewAllUserRequests";
	}
	@RequestMapping("/createUser")
	public ModelAndView createUser(@ModelAttribute UserRequest userRequest) {
		logger.info("Creating UserRequest. Data: " + userRequest);
		return new ModelAndView("userRequest");
	}

}
