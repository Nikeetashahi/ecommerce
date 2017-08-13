package com.ecommerce.service;

import com.ecommerce.model.Cart;

public interface CartService {
	
	void addCart(Cart c);
	String retrieveCart(String username);
	void deleteCart(String id);
	void updateCart(String id, int quantity);
	long getTotalPriceOfCart(String username);
	long getTotalQuantityOfCart(String username);

}
