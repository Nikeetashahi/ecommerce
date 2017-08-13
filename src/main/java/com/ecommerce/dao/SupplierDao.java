package com.ecommerce.dao;

import com.ecommerce.model.Supplier;

public interface SupplierDao {
	
	void addSupplier(Supplier sobj);
	String retrieveSupplier();
	void deleteSupplier(int id);
	Supplier fetchproductbyid(int id);
	void updateSupplier(Supplier sopobj);

	
	

}
