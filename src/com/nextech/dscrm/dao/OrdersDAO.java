package com.nextech.dscrm.dao;

import java.util.List;

import com.nextech.dscrm.model.OrderModel;

public interface OrdersDAO {

	public Integer createOrder(OrderModel orderModel);

	Integer saveOrder(OrderModel orderModel);

	Integer updateOrder(OrderModel orderModel);

	Integer deleteOrder(Integer id);

	OrderModel findById(Integer id);
	
	List<OrderModel> getAllOrders();
	
	List<OrderModel> getOrdersByMonth(String month);

}
