package com.nextech.dscrm.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.nextech.dscrm.model.LoginUserRequest;

public class LoginUserRequestDAOImpl implements LoginUserRequestDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Integer loginSaveUserRequest(LoginUserRequest loginUserRequest) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(loginUserRequest);
		tx.commit();
		Serializable id = session.getIdentifier(loginUserRequest);
		session.close();
		return (Integer) id;

	}

}
