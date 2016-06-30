package com.nextech.dscrm.dao;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.nextech.dscrm.model.UserModel;
import com.nextech.dscrm.model.UserRequest;
import com.nextech.dscrm.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;
	public HibernateUtil hibernateUtil;

	@Override
	public long createUserRegistration(UserModel userModel) {
		return (Long) hibernateUtil.create(userModel);
	}
	@Override
	public UserModel findById(Integer id) {
		Session session = sessionFactory.openSession();
		UserModel userModel = (UserModel) session.load(UserModel.class, id);
		return userModel;
	}

	@Override
	public Integer saveUser(UserModel userModel) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(userModel);
		tx.commit();
		Serializable id = session.getIdentifier(userModel);
		session.close();
		return (Integer) id;
	}
	@Override
	public Integer updateUserModel(UserModel userModel) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(userModel);
		tx.commit();
		Serializable id = session.getIdentifier(userModel);
		session.close();
		return (Integer) id;

	}

	@Override
	public Integer deleteUserModel(int id) {
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

}
