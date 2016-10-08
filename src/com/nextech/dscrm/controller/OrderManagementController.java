package com.nextech.dscrm.controller;

import java.util.ArrayList;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextech.dscrm.model.OrderModel;
import com.nextech.dscrm.model.UserModel;

@Controller
public class OrderManagementController {
	
	private static final Logger logger = Logger
			.getLogger(UserRequestController.class);
	
	@RequestMapping("/orders")
	public String userModel(ModelMap modelMap) {
		ArrayList<OrderModel> orderList = new ArrayList<OrderModel>();
		OrderModel orderModel = null;
		for(int i=0;i< 10; i++ ){
			orderModel = new OrderModel();
			orderModel.setOrderId("OINV"+i);
			orderModel.setClientName("NexTecch Services Private Limited");
			orderModel.setDeliveryDate("22nd Jan, 2016");
			orderModel.setProductId("PR000012"+i);
			orderModel.setQuantity("50");
			orderList.add(orderModel);
		}
		modelMap.addAttribute("orderList", orderList);
		return "orderList";
	}

}
