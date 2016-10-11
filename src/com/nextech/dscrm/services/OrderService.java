package com.nextech.dscrm.services;

import java.util.List;

import com.nextech.dscrm.model.OrderModel;

public interface OrderService {

	public Integer createOrder(OrderModel orderModel);

	Integer saveUser(OrderModel orderModel);

	Integer updateOrder(OrderModel orderModel);

	Integer deleteOrder(Integer id);

	OrderModel findById(Integer id);
	
	List<OrderModel> getAllOrders();
	
	List<OrderModel> getOrdersByMonth(String month);
}
