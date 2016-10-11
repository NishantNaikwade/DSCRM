package com.nextech.dscrm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.nextech.dscrm.model.ClientModel;

public class ClientDAOImpl implements ClientDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer createClient(ClientModel clientModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer saveClient(ClientModel clientModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateClient(ClientModel clientModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientModel findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientModel> getAllClients() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<ClientModel> list = (List<ClientModel>)session.createCriteria(ClientModel.class).list();
		tx.commit();
		session.close();
		return list;
	}

}
