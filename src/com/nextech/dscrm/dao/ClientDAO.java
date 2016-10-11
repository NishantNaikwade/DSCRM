package com.nextech.dscrm.dao;

import java.util.List;

import com.nextech.dscrm.model.ClientModel;

public interface ClientDAO {
	
	public Integer createClient(ClientModel clientModel);

	Integer saveClient(ClientModel clientModel);

	Integer updateClient(ClientModel clientModel);

	Integer deleteProduct(Integer id);

	ClientModel findById(Integer id);
	
	List<ClientModel> getAllClients();

}
