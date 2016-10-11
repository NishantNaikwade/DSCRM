package com.nextech.dscrm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nextech.dscrm.dao.ProductDAOImpl;
import com.nextech.dscrm.model.ProductModel;

public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDAOImpl productDaoImpl;
	
	@Override
	public Integer createProduct(ProductModel productModel) {
		// TODO Auto-generated method stub
		return productDaoImpl.createProduct(productModel);
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
		return productDaoImpl.getAllProducts();
	}

}
