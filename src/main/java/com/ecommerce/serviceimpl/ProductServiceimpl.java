package com.ecommerce.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;

@Service
public class ProductServiceimpl implements ProductService {
	@Autowired
	ProductDao productdao;
	
	public void addProduct(Product pd)
	{
		productdao.addProduct(pd);
		
	}
	
	public String retrieveProduct()
	{
		 
		return productdao.retrieveProduct();
	}

	public void deleteProduct(int id) {
		productdao.deleteProduct(id);
		
	}

	public Product fetchProduct(int id) {
		
		return productdao.fetchProduct(id);
	}

	public void updateProduct(Product pd) {
	  
		productdao.updateProduct(pd);
		
	}

	public String tshirt() {

		return productdao.tshirt();
	}

	public String shirt() {

		return productdao.shirt();
	}

	public String jeans() {

		return productdao.jeans();
	}

	public String fetchproductbyid(int id) {

		return productdao.fetchproductbyid( id);
	}
	
	

	
}
