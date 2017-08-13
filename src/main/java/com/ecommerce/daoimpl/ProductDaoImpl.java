package com.ecommerce.daoimpl;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Product;
import com.google.gson.Gson;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void addProduct(Product pd)
	{
		
		Session con= sessionFactory.openSession();
		Transaction t= con.beginTransaction();
		con.save(pd);
		t.commit();
	    con.flush();
	    con.close();
		
		}
	
	public String retrieveProduct()
  {
	    Session con = sessionFactory.openSession();
		Transaction t = con.beginTransaction();
		List prodlist = con.createQuery("FROM Product").list();
	
		Gson gson = new Gson();
		String jsonNames = gson.toJson(prodlist);
		t.commit();
		con.close();
		return jsonNames;
		
  }
	
	public void deleteProduct(int id){
		Session con= sessionFactory.openSession();
	    Transaction t=con.beginTransaction();
	    Product pdel=(Product) con.get(Product.class, id);
	    con.delete(pdel);
	    t.commit();
	    con.flush();
	    con.close();
	    
		
	}
	
	public Product fetchProduct(int id){
		Session con=sessionFactory.openSession();
		Transaction t=con.beginTransaction();
		Product pobj=(Product) con.get(Product.class, id);
		t.commit();
		con.flush();
		con.close();
		return pobj;
		
	}

	public void updateProduct(Product pd) {

		Session con = sessionFactory.openSession();
		Transaction t = con.beginTransaction();
		con.update(pd);
		t.commit();
		con.close();
		
	}

	public String tshirt() {
		Session con = sessionFactory.openSession();
		Transaction t = con.beginTransaction();
		Criteria cri= con.createCriteria(Product.class);
		cri.add(Restrictions.eq("cid", 7));
		List prodlist = cri.list();
		Gson gs = new Gson();
		String jsonlist = gs.toJson(prodlist);
		t.commit();
		con.flush();
		con.close();
		return jsonlist;
	}

	public String shirt()
	  {
		Session con = sessionFactory.openSession();
		Transaction t = con.beginTransaction();
		Criteria cri= con.createCriteria(Product.class);
		cri.add(Restrictions.eq("cid", 8));
		List prodlist = cri.list();
		Gson gs = new Gson();
		String jsonlist = gs.toJson(prodlist);
		t.commit();
		con.flush();
		con.close();
		return jsonlist;

		}

	public String jeans()
	  {
        Session con = sessionFactory.openSession();
		Transaction t = con.beginTransaction();
		Criteria cri= con.createCriteria(Product.class);
		cri.add(Restrictions.eq("cid", 7));
		List prodlist = cri.list();
		Gson gs = new Gson();
		String jsonlist = gs.toJson(prodlist);
		t.commit();
		con.flush();
		con.close();
		return jsonlist;
	}

	public String fetchproductbyid(int id) {
		Session con = sessionFactory.openSession();
		Transaction t = con.beginTransaction();
		Product pobj=(Product) con.get(Product.class, id);
		Gson gs = new Gson();
		String jsonlist = gs.toJson(pobj);
		t.commit();
		con.flush();
		con.close();
		return jsonlist;
		
	}
	
	
}
