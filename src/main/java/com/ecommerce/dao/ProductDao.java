package com.ecommerce.dao;

import com.ecommerce.model.Product;

public interface ProductDao {
	void addProduct(Product pd);
	String retrieveProduct();
	void deleteProduct(int id);
	Product fetchProduct(int id);
	void updateProduct(Product pd);
	String tshirt();
	String shirt();
	String jeans();
	String fetchproductbyid(int id);
	
	

}
