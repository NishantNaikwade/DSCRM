package com.nextech.dscrm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nextech.dscrm.dao.ClientDAOImpl;
import com.nextech.dscrm.model.ClientModel;

public class ClientServiceImpl implements ClientService{
	@Autowired
	ClientDAOImpl clientDAOImpl;

	@Override
	public Integer createClient(ClientModel clientModel) {
		// TODO Auto-generated method stub
		return clientDAOImpl.createClient(clientModel);
	}

	@Override
	public Integer saveClient(ClientModel clientModel) {
		// TODO Auto-generated method stub
		return clientDAOImpl.saveClient(clientModel);
	}

	@Override
	public Integer updateClient(ClientModel clientModel) {
		// TODO Auto-generated method stub
		return clientDAOImpl.updateClient(clientModel);
	}

	@Override
	public Integer deleteClient(Integer id) {
		// TODO Auto-generated method stub
		return clientDAOImpl.deleteProduct(id);
	}

	@Override
	public ClientModel findById(Integer id) {
		// TODO Auto-generated method stub
		return clientDAOImpl.findById(id);
	}

	@Override
	public List<ClientModel> getAllClients() {
		// TODO Auto-generated method stub
		return clientDAOImpl.getAllClients();
	}

}
