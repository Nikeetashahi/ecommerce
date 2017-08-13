package com.ecommerce.service;

import com.ecommerce.model.Supplier;

public interface SupplierService {
	
	void addSupplier(Supplier sobj);
	String retrieveSupplier();
	void deleteSupplier(int id);
	Supplier fetchproductbyid(int id);
	void updateSupplier(Supplier sopobj);

}
