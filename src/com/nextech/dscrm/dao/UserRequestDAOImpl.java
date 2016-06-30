package com.nextech.dscrm.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.nextech.dscrm.model.UserRequest;
import com.nextech.dscrm.util.HibernateUtil;

public class UserRequestDAOImpl implements UserRequestDAO {

	@Autowired
	SessionFactory sessionFactory;
	public HibernateUtil hibernateUtil;

	@Override
	public UserRequest findById(Integer id) {
		Session session = sessionFactory.openSession();
		UserRequest userRequest = (UserRequest) session.load(UserRequest.class,
				id);
		return userRequest;
	}

	@Override
	public Integer saveUserRequest(UserRequest userRequest) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(userRequest);
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
		UserRequest userRequest = (UserRequest) session.load(UserRequest.class,
				id);
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
		List<UserRequest> userList = session.createQuery("from UserRequest")
				.list();
		session.close();
		return userList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRequest> findUserRequestByMobileNumber(String mobileNumber) {
		String query = "SELECT * FROM UserRequest  WHERE mobile= '"
				+ mobileNumber + "'";
		System.out.println("Searching for Mobile : " + mobileNumber);
		Session session = sessionFactory.openSession();
		List<UserRequest> userList = session.createQuery(
				"from UserRequest WHERE mobile= '" + mobileNumber + "'").list();
		System.out.println("userlist size : " + userList.size());
		return userList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRequest> findAllUserRequestsForUserName(String userName) {
		String query = "SELECT * FROM UserRequest  WHERE name like '%"
				+ userName + "%'";
		System.out.println("Searching for Name : " + userName);
		Session session = sessionFactory.openSession();
		List<UserRequest> userList = session.createQuery(
				"from UserRequest WHERE name like '%" + userName + "%'").list();
		System.out.println("userlist size : " + userList.size());
		return userList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRequest> findAllUserRequsetForTime(Timestamp userTime) {
		String query = "Select * from UserRequest where requesttime='"
				+ userTime + "'";
		System.out.println("Searching for Time:" + userTime);
		Session session = sessionFactory.openSession();
		List<UserRequest> userList = session.createQuery(
				"from UserRequest Where requesttime= '" + userTime + "'")
				.list();
		System.out.println("userlist size : " + userList.size());
		return userList;
	}

	@Override
	public long createUser(UserRequest userRequest) {
		return (Long) hibernateUtil.create(userRequest);
	}
	
	
}