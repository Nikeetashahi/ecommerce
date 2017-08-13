package com.ecommerce.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;
import com.ecommerce.service.CartService;
import com.ecommerce.service.ProductService;

@Controller
public class CartController {
	
	@Autowired
	CartService cs;
	
	@Autowired
	ProductService ps;
	
	@Autowired
	Cart c;
	
	@Autowired
	Product p;
	
	
	/*for adding product in cart*/
	@RequestMapping(value="/addcart", method=RequestMethod.GET)
	public ModelAndView addcart(@RequestParam("id") int id, HttpSession session)
	{
		p=ps.fetchproductbyid(id);
		
		return null;
		
	}

}
