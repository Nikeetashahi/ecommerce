package com.ecommerce.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.SupplierDao;
import com.ecommerce.model.Supplier;
import com.ecommerce.service.SupplierService;
@Service
public class SupplierServiceimpl implements SupplierService {
	@Autowired
	SupplierDao supplierdao;

	public void addSupplier(Supplier sobj) {
		
		supplierdao.addSupplier(sobj);
		
	}

	public String retrieveSupplier() {
		return supplierdao.retrieveSupplier();
	}

	public void deleteSupplier(int id) {
		
		supplierdao.deleteSupplier(id);
		
	}

	public Supplier fetchproductbyid(int id) {
		return supplierdao.fetchproductbyid(id);
	}

	public void updateSupplier(Supplier supobj) {

		supplierdao.updateSupplier(supobj);
	}


}
