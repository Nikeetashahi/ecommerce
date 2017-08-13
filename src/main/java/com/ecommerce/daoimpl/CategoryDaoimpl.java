package com.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.dao.CategoryDao;
import com.ecommerce.model.Category;

import com.google.gson.Gson;

@Repository
public class CategoryDaoimpl implements CategoryDao {
	
	@Autowired
	SessionFactory session;

	public void addCategory(Category ctry) {

		Session s = session.openSession();
		Transaction t = s.beginTransaction();
		s.save(ctry);
		t.commit();
		s.flush();
		s.close();
	}

	public String retrieveCategory() {
		
		Session s=session.openSession();
		Transaction t=s.beginTransaction();
        List clist= s.createQuery("From Category").list();
        Gson gson = new Gson();
		String jsonNames = gson.toJson(clist);
		t.commit();
		s.close();
		return jsonNames;
		
	}

	public void deleteCategory(int id) {

		Session s= session.openSession();
	    Transaction t=s.beginTransaction();
	    Category cdel=(Category) s.get(Category.class, id);
	    s.delete(cdel);
	    t.commit();
	    s.flush();
	    s.close();
	}

	public Category fetchCategory(int id) {

		 Session s = session.openSession();
		 Transaction t = s.beginTransaction();
		 Category cobj=(Category)s.get(Category.class, id);
		 t.commit();
		 s.flush();
		 s.close();
		 return cobj;
	}

	
	public void updateCategory(Category ctry) 
	{
		Session s = session.openSession();
		Transaction t = s.beginTransaction();
		s.update(ctry);
		t.commit();
		s.close();
		

	 }

	public void setCategoryStatus(int id, String status) {
		
		Session s = session.openSession();
		Transaction t = s.beginTransaction();
		Category cat = (Category)s.get(Category.class, id);
		cat.setCstatus(status);
		t.commit();
		s.flush();
		s.close();
	}
	}
