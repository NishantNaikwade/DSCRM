package com.nextech.dscrm.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.nextech.dscrm.model.UserRequest;
import com.nextech.dscrm.util.HibernateUtil;

public class UserRequestDAOImpl implements UserRequestDAO {

	@Autowired
	SessionFactory sessionFactory;
	private HibernateUtil hibernateUtil;
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
		List<UserRequest> userList = session.createQuery("from UserRequest").list();
		session.close();
		return userList;
	}

	@Override
	public UserRequest findUserRequestByMobileNumber(String mobileNumber) {
		Session session = sessionFactory.openSession();
		UserRequest userRequest = (UserRequest) session.load(UserRequest.class, mobileNumber);
		return userRequest;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<UserRequest> findAllUserRequests(String userName) { 
	String query = "SELECT * FROM UserRequest  WHERE name like '%"+ userName +"%'";
	List<Object[]> userObjects = hibernateUtil.fetchAll(query);
	List<UserRequest> userRequest = new ArrayList<UserRequest>();
	for(Object[] userObject: userObjects) {
		UserRequest user = new UserRequest();
	int id = (int)  userObject[0];
	String name = (String)  userObject[1];
	String mobile = (String)  userObject[2];
	String email = (String)  userObject[3];
	user.setId(id);
	user.setName(name);
	user.setMobile(mobile);
	user.setEmail(email);
	userRequest.add(user);
	}
	System.out.println(userRequest);
	return userRequest;
	}

	@Override
	public long createUser(UserRequest userRequest) { 
	return (Long) hibernateUtil.create(userRequest);
	}

	@Override
	public List<UserRequest> findAllUserRequests(String userName,
			HibernateUtil hibernateUtil) {
		// TODO Auto-generated method stub
		return null;
	} 
}