package com.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.dao.SupplierDao;
import com.ecommerce.model.Supplier;
import com.google.gson.Gson;
@Repository
public class SupplierDaoimpl implements SupplierDao {
	
	@Autowired
	SessionFactory session;

	public void addSupplier(Supplier sobj) {

		Session s=session.openSession();
		Transaction t=s.beginTransaction();
		s.save(sobj);
		t.commit();
		s.flush();
		s.close();
	}

	public String retrieveSupplier()
	{
		Session s=session.openSession();
		Transaction t=s.beginTransaction();
		List suplierlist=s.createQuery("FROM Supplier").list();
		Gson gson=new Gson();
		String jsonName=gson.toJson(suplierlist);
		t.commit();
		s.close();
		return jsonName;
	}

	public void deleteSupplier(int id)
	{
		Session s=session.openSession();
		Transaction t=s.beginTransaction();
		Supplier del=(Supplier) s.get(Supplier.class, id);
		s.delete(del);
		t.commit();
		s.flush();
		s.close();
		
  
		}

	public Supplier fetchproductbyid(int id) {
		Session s=session.openSession();
		Transaction t=s.beginTransaction();
		Supplier suplist=(Supplier) s.get(Supplier.class, id);
		t.commit();
		s.flush();
		s.close();
		return suplist;
	}

	public void updateSupplier(Supplier sopobj) {
		Session s=session.openSession();
		Transaction t=s.beginTransaction();
		s.update(sopobj);
		t.commit();
		s.flush();
		s.close();
		
		
	}

	
}
