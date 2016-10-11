package com.nextech.dscrm.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.nextech.dscrm.model.ProductModel;

public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Integer createProduct(ProductModel productModel) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(productModel);
		tx.commit();
		Serializable id = session.getIdentifier(productModel);
		session.close();
		return (Integer) id;
	}

	@Override
	public Integer saveProduct(ProductModel productModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateProduct(ProductModel productModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductModel findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> getAllProducts() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<ProductModel> list = (List<ProductModel>)session.createCriteria(ProductModel.class).list();
		tx.commit();
		session.close();
		return list;

	}

}
