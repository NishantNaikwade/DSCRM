package com.nextech.dscrm.controller;

import java.util.ArrayList;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextech.dscrm.model.OrderModel;
import com.nextech.dscrm.model.UserModel;

@Controller
public class OrderManagementController {
	
	private static final Logger logger = Logger
			.getLogger(UserRequestController.class);
	
	@RequestMapping("/orders")
	public String displayOrder(ModelMap modelMap) {
		
		modelMap.addAttribute("orderList", getDummyOrderList());
		return "orderList";
	}
	
	@RequestMapping("/oms")
	public String displayOrderManager(ModelMap modelMap) {
		modelMap.addAttribute("number", 10);
		modelMap.addAttribute("completedCount", 10);
		modelMap.addAttribute("deliveredCount", 10);
		modelMap.addAttribute("inProgressCount", 10);
		modelMap.addAttribute("orderList", getDummyOrderList());
		return "orderManagement";
	}
	
	@RequestMapping("/addOrder")
	public String displayAddOrder(ModelMap modelMap) {
		logger.info("Loading Add Order Page");
		OrderModel orderModel = new OrderModel();
		modelMap.addAttribute("orderModel", orderModel);
		return "addOrder";
	}
	
	@RequestMapping("/addNewOrder")
	public String addNewOrder(@ModelAttribute("orderModel")OrderModel orderModel) {
		logger.info("Adding New Order");
		logger.info("Client : " + orderModel.getClientName());
		logger.info("Quantity : " + orderModel.getQuantity());
		return "oms";
	}

	public ArrayList<OrderModel> getDummyOrderList(){
		ArrayList<OrderModel> orderList = new ArrayList<OrderModel>();
		OrderModel orderModel = null;
		for(int i=0;i< 10; i++ ){
			orderModel = new OrderModel();
			orderModel.setOrderId("OINV"+i);
			orderModel.setClientName("NexTech Services Private Limited");
			orderModel.setDeliveryDate("22nd Jan, 2016");
			orderModel.setProductId("PR000012"+i);
			orderModel.setQuantity("50");
			orderModel.setStatus((i%2 == 0) ? "completed" : "inprogress");
			orderList.add(orderModel);
		}
		return orderList;
	}
	
}
