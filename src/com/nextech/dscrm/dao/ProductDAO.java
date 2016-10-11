package com.nextech.dscrm.dao;

import java.util.List;

import com.nextech.dscrm.model.ProductModel;


public interface ProductDAO {

	public Integer createProduct(ProductModel productModel);

	Integer saveProduct(ProductModel productModel);

	Integer updateProduct(ProductModel productModel);

	Integer deleteProduct(Integer id);

	ProductModel findById(Integer id);
	
	List<ProductModel> getAllProducts();
	
}
