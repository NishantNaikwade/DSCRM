package com.nextech.dscrm.controller;

import java.sql.Date;
import java.util.ArrayList;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nextech.dscrm.model.OrderModel;
import com.nextech.dscrm.services.ClientServiceImpl;
import com.nextech.dscrm.services.OrderServiceImpl;
import com.nextech.dscrm.services.ProductServiceImpl;

@Controller
public class OrderManagementController {
	
	private static final Logger logger = Logger
			.getLogger(UserRequestController.class);
	
	@Autowired
	OrderServiceImpl orderServiceImpl;
	
	@Autowired
	ClientServiceImpl clientServiceImpl;
	
	@Autowired
	ProductServiceImpl productServiceImpl;
	
	
	@RequestMapping("/orders")
	public String displayOrder(ModelMap modelMap) {
		
		modelMap.addAttribute("orderList", getDummyOrderList());
		return "orderList";
	}
	
	@RequestMapping("/oms")
	public String displayOrderManager(ModelMap modelMap) {
		modelMap.addAttribute("number", 10);
		modelMap.addAttribute("newOrderCount",orderServiceImpl.getNewOrderCount());
		modelMap.addAttribute("completedCount", orderServiceImpl.getCompletedCount());
		modelMap.addAttribute("deliveredCount", orderServiceImpl.getDeliveredCount());
		modelMap.addAttribute("inProgressCount", orderServiceImpl.getInProgressCount());
		modelMap.addAttribute("orderList", orderServiceImpl.getAllOrders());
		return "orderManagement";
	}
	
	@RequestMapping("/addOrder")
	public String displayAddOrder(ModelMap modelMap) {
		logger.info("Loading Add Order Page");
		OrderModel orderModel = new OrderModel();
		modelMap.addAttribute("orderModel", orderModel);
		modelMap.addAttribute("clientList", clientServiceImpl.getAllClients());
		modelMap.addAttribute("productList", productServiceImpl.getAllProducts());
		return "addOrder";
	}
	
	@RequestMapping("/addNewOrder")
	public ModelAndView addNewOrder(@ModelAttribute("orderModel")OrderModel orderModel) {
		logger.info("Adding New Order");
		logger.info("Client : " + orderModel.getClientId());
		logger.info("Product : " + orderModel.getProductId());
		logger.info("Quantity : " + orderModel.getQuantity());
		logger.info("Delivery Date : " + orderModel.getDeliveryDate());
		orderModel.setStatus(1);
		orderModel.setCreateTime(new Date(System.currentTimeMillis()));
		orderServiceImpl.createOrder(orderModel);
		return new ModelAndView("redirect:/oms");
		//return "orderManagement";
	}

	public ArrayList<OrderModel> getDummyOrderList(){
		ArrayList<OrderModel> orderList = new ArrayList<OrderModel>();
//		OrderModel orderModel = null;
//		for(int i=0;i< 10; i++ ){
//			orderModel = new OrderModel();
//			orderModel.setOrderId(i);
//			orderModel.setClientName("NexTech Services Private Limited");
//			orderModel.setDeliveryDate(new Date(System.currentTimeMillis()));
//			orderModel.setProductId("PR000012"+i);
//			orderModel.setQuantity(50);
//			orderModel.setStatus((i%2 == 0) ? "completed" : "inprogress");
//			orderList.add(orderModel);
//		}
		return orderList;
	}
	
}
