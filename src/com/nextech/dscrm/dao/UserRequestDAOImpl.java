package com.nextech.dscrm.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.nextech.dscrm.model.UserRequest;

public class UserRequestDAOImpl implements UserRequestDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public UserRequest findById(Integer id) {
		Session session = sessionFactory.openSession();
		UserRequest userRequest = (UserRequest) session.load(UserRequest.class, id);
		return userRequest;
	}

	@Override
	public Integer saveUserRequest(UserRequest userRequest) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(userRequest);
		tx.commit();
		Serializable id = session.getIdentifier(userRequest);
		session.close();
		return (Integer) id;
	}

	@Override
	public Integer updateUserRequest(UserRequest userRequest) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(userRequest);
		tx.commit();
		Serializable id = session.getIdentifier(userRequest);
		session.close();
		return (Integer) id;

	}

	@Override
	public Integer deleteUserRequest(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		UserRequest userRequest = (UserRequest) session.load(UserRequest.class, id);
		session.delete(userRequest);
		tx.commit();
		Serializable ids = session.getIdentifier(userRequest);
		session.close();
		return (Integer) ids;
	}

	@Override
	public List<UserRequest> findAllUserRequests() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<UserRequest> employeeList = session.createQuery("from UserRequest").list();
		session.close();
		return employeeList;
	}

	@Override
	public UserRequest findUserRequestByMobileNumber(String mobileNumber) {
		Session session = sessionFactory.openSession();
		UserRequest userRequest = (UserRequest) session.load(UserRequest.class, mobileNumber);
		return userRequest;
	}

}
