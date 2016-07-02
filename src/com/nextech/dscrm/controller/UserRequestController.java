package com.nextech.dscrm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.nextech.dscrm.model.UpdateUserRequest;
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
		modelMap.addAttribute("edit", false);
		return "userRequest";
	}

	@RequestMapping("/saveUserRequest")
	public String saveUserRequest(
			@ModelAttribute("userRequest") UserRequest userRequest) {
		// UserRequest userRequest = (UserRequest) modelMap.get("userRequest");
		userRequestServiceImpl.saveUserRequest(userRequest);

		// sendEmail();
		msgsend();
		return "saveUserRequest";

	}

	private void sendEmail() {
		System.out.println("Sending email...");
		final String username = "shahadeochavan@gmail.com";
		final String password = "9730763846";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("shahadeochavan@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("nishant.naikwade@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
					+ "\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public void msgsend() {
		String username = "surajSMS";
		// Your Credentials
		String password = "suraj123";
		String smtphost = "ipipi.com";
		// Ip/Name of Server
		String compression = "None";
		// I dont want any compression
		String from = "surajSMS@ipipi.com";
		// ur userid@ipipi.com
		// This mobile number need not be registered with ipipi.com
		String to = "919766024191@sms.ipipi.com"; // mobile number where u want
													// to send sms
		String body = "Hi This Msg is sent through Java Code";

		Transport tr = null;
		try {
			Properties props = System.getProperties();
			props.put("mail.smtp.auth", "true");
			// Get a Session object
			Session mailSession = Session.getDefaultInstance(props, null);
			// construct the message
			Message msg = new MimeMessage(mailSession);
			// Set message attributes
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(compression);
			msg.setText(body);
			msg.setSentDate(new Date());
			tr = mailSession.getTransport("smtp");
			// try to connect
			tr.connect(smtphost, username, password);
			msg.saveChanges();
			// send msg to all recipients
			tr.sendMessage(msg, msg.getAllRecipients());
			tr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @RequestMapping("/updateUserRequest") public String
	 * updateUserRequest(@ModelAttribute("userRequest") UserRequest
	 * userRequest){ userRequestServiceImpl.updateUserRequest(userRequest);
	 * return "updateUserRequest"; }
	 */
	/*@RequestMapping("/updateUserRequest")
	public String updateUserRequest(ModelMap modelMap) {
		UserRequest userRequest = new UserRequest();
		modelMap.addAttribute("userRequest", userRequest);
		modelMap.addAttribute("edit", true);
		return "updateUserRequest";
	}*/

	@RequestMapping("/updateUserRequest")
	public ModelAndView deleteUserRequest(@ModelAttribute("command")UpdateUserRequest updateUserRequest,
	   BindingResult result) {
	  Map<String, Object> model = new HashMap<String, Object>();
	  model.put("userRequest", prepareUpdateUserRequest(userRequestServiceImpl.getUserRequest(updateUserRequest.getId())));
	  model.put("userRequests",  prepareListofBean(userRequestServiceImpl.findAllUserRequests()));
	  return new ModelAndView("userRequest", model);
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
		return new ModelAndView("redirect:viewAllUserRequests");
	}

	@RequestMapping("/searchUserByName")
	public String searchUserByName(
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

	private UserRequest prepareModel(UpdateUserRequest updateUserRequest){
		UserRequest userRequest = new UserRequest();
		userRequest.setName(updateUserRequest.getName());
		userRequest.setEmail(updateUserRequest.getEmail());
		userRequest.setMobile(updateUserRequest.getMobile());
		userRequest.setRequirementDescription(updateUserRequest.getRequirementDescription());
		userRequest.setId(updateUserRequest.getId());
		updateUserRequest.setId(null);
		  return userRequest;
		 }
		 
		 private List<UpdateUserRequest> prepareListofBean(List<UserRequest> userRequests){
		  List<UpdateUserRequest> beans = null;
		  if(userRequests != null && !userRequests.isEmpty()){
		   beans = new ArrayList<UpdateUserRequest>();
		   UpdateUserRequest bean = null;
		   for(UserRequest userRequest : userRequests){
		    bean = new UpdateUserRequest();
		    bean.setName(userRequest.getName());
		    bean.setId(userRequest.getId());
		    bean.setEmail(userRequest.getEmail());
		    bean.setMobile(userRequest.getMobile());
		    bean.setRequirementDescription(userRequest.getRequirementDescription());
		    beans.add(bean);
		   }
		  }
		  return beans;
		 }
		 
		 private UpdateUserRequest prepareUpdateUserRequest(UserRequest userRequet){
			 UpdateUserRequest bean = new UpdateUserRequest();
		  bean.setName(userRequet.getName());
		  bean.setId(userRequet.getId());
		  bean.setEmail(userRequet.getName());
		  bean.setMobile(userRequet.getMobile());
		  bean.setRequirementDescription(userRequet.getRequirementDescription());
		  return bean;
		 }
}
