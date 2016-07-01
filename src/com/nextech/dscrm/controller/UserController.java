package com.nextech.dscrm.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nextech.dscrm.model.UserModel;
import com.nextech.dscrm.services.UserServiceImpl;

@Controller
public class UserController {
	private static final Logger logger = Logger
			.getLogger(UserRequestController.class);

	public UserController() {
		System.out.println("UserController");
	}

	@Autowired
	UserServiceImpl userServiceImpl;

	@RequestMapping("/userModel")
	public String userModel(ModelMap modelMap) {
		UserModel userModel = new UserModel();
		modelMap.addAttribute("userModel", userModel);
		return "userModel";
	}

	@RequestMapping("/saveUser")
	public String saveUser(@ModelAttribute("saveUser") UserModel userModel) {
		userServiceImpl.saveUser(userModel);
		return "saveUser";
	}

	@RequestMapping("/updateUserModel")
	public String updateUserModel(
			@ModelAttribute("userModel") UserModel userModel) {
		userServiceImpl.updateUserModel(userModel);
		return "updateUserModel";
	}

	@RequestMapping("/deleteUserModel")
	public ModelAndView deleteUserModel(@RequestParam long id) {
		logger.info("Deleting the UserRequest. Id : " + id);
		userServiceImpl.deleteUserModel((int) id);
		return new ModelAndView("redirect:viewAllUserRequests");
	}
	@ResponseBody
	@RequestMapping(value="email_Unique" ,method=RequestMethod.POST)
	public boolean email_Unique(@RequestParam("value") String email){
	boolean result=userServiceImpl.email_Unique(email);
	//System.out.println("MaterialName "+materialName);  
	return result;
	}
	

}
