package com.nextech.dscrm.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmailUserRequestController {
	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping("/sendEmail")
	public String doSendEmail(HttpServletRequest request) {
		// takes input from e-mail form
		String recipientAddress = request.getParameter("email");
		// prints debug info
		System.out.println("To: " + recipientAddress);

		// creates a simple e-mail object
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject("Test Subject");
		email.setText("Test MEssage");
		// sends the e-mail
		mailSender.send(email);

		// forwards to the view named "Result"
		return "result";
	}

}
