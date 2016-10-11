package com.nextech.dscrm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nextech.dscrm.dao.OrderDAOImpl;
import com.nextech.dscrm.model.OrderModel;

public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderDAOImpl orderDaoImpl;

	@Override
	public Integer createOrder(OrderModel orderModel) {
		return orderDaoImpl.createOrder(orderModel);
	}

	@Override
	public Integer saveUser(OrderModel orderModel) {
		return orderDaoImpl.saveOrder(orderModel);
	}

	@Override
	public Integer updateOrder(OrderModel orderModel) {
		return orderDaoImpl.updateOrder(orderModel);
	}

	@Override
	public Integer deleteOrder(Integer id) {
		return orderDaoImpl.deleteOrder(id);
	}

	@Override
	public OrderModel findById(Integer id) {
		return orderDaoImpl.findById(id);
	}

	@Override
	public List<OrderModel> getAllOrders() {
		return orderDaoImpl.getAllOrders();
	}

	@Override
	public List<OrderModel> getOrdersByMonth(String month) {
		return orderDaoImpl.getOrdersByMonth(month);
	}

	public Integer getNewOrderCount() {
		return orderDaoImpl.getNewOrderCount();
	}

	public Integer getCompletedCount() {
		return orderDaoImpl.getCompletedCount();
	}

	public Integer getDeliveredCount() {
		return orderDaoImpl.getDeliveredCount();
	}

	public Integer getInProgressCount() {
		return orderDaoImpl.getInProgressCount();
	}

}
