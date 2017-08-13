package com.ecommerce.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.CartDao;
import com.ecommerce.model.Cart;
import com.ecommerce.service.CartService;

@Service
public class CartServiceimpl implements CartService {
	
	@Autowired
	CartDao cartdao;

	public void addCart(Cart c) {
		
		cartdao.addCart(c);

	}

	public String retrieveCart(String username) {

		return cartdao.retrieveCart(username);
	}

	public void deleteCart(String id) {
		
		cartdao.deleteCart(id);

		}

	public void updateCart(String id, int quantity) {
		
		cartdao.updateCart(id, quantity);

		
	}

	public long getTotalPriceOfCart(String username) {

		return cartdao.getTotalPriceOfCart(username);
	}

	public long getTotalQuantityOfCart(String username) {

		return cartdao.getTotalQuantityOfCart(username);
	}

}
