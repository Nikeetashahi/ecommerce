package com.ecommerce.service;

import com.ecommerce.model.Product;

public interface ProductService {
	void addProduct(Product pd);
	String retrieveProduct();
	void deleteProduct(int id);
	Product fetchProduct(int id);
	void updateProduct(Product pd);
	String tshirt();
	String shirt();
	String jeans();
	Product fetchproductbyid(int id);
	

}
