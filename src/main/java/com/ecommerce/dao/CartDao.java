package com.ecommerce.dao;

import com.ecommerce.model.Cart;

public interface CartDao {
	
	void addCart(Cart c);
	String retrieveCart(String username);
	void deleteCart(String id);
	void updateCart(String id, int quantity);
	long getTotalPriceOfCart(String username);
	long getTotalQuantityOfCart(String username);

}
