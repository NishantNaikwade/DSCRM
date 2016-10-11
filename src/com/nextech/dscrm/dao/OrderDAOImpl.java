package com.nextech.dscrm.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.nextech.dscrm.model.OrderModel;

public class OrderDAOImpl implements OrdersDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Integer createOrder(OrderModel orderModel) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(orderModel);
		tx.commit();
		Serializable id = session.getIdentifier(orderModel);
		session.close();
		return (Integer) id;
	}

	@Override
	public Integer saveOrder(OrderModel orderModel) {
		return null;
	}

	@Override
	public Integer updateOrder(OrderModel orderModel) {
		return null;
	}

	@Override
	public Integer deleteOrder(Integer id) {
		return null;
	}

	@Override
	public OrderModel findById(Integer id) {
		return null;
	}

	@Override
	public List<OrderModel> getAllOrders() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<OrderModel> list = (List<OrderModel>)session.createCriteria(OrderModel.class).list();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public List<OrderModel> getOrdersByMonth(String month) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from OrderModel where Month(NOW)= :month");
		query.setString("month", month);
		@SuppressWarnings("unchecked")
		List<OrderModel> list = query.list();
		tx.commit();
		session.close();
		return list;
	}

	public Integer getNewOrderCount() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from OrderModel where status= :status");
		query.setInteger("status", 1);
		@SuppressWarnings("unchecked")
		List<OrderModel> list = query.list();
		tx.commit();
		session.close();
		return list.size();
	}

	public Integer getCompletedCount() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from OrderModel where status= :status");
		query.setInteger("status", 3);
		@SuppressWarnings("unchecked")
		List<OrderModel> list = query.list();
		tx.commit();
		session.close();
		return list.size();
	}

	public Integer getDeliveredCount() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from OrderModel where status= :status");
		query.setInteger("status", 4);
		@SuppressWarnings("unchecked")
		List<OrderModel> list = query.list();
		tx.commit();
		session.close();
		return list.size();
	}

	public Integer getInProgressCount() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from OrderModel where status= :status");
		query.setInteger("status", 2);
		@SuppressWarnings("unchecked")
		List<OrderModel> list = query.list();
		tx.commit();
		session.close();
		return list.size();
	}

}
