package com.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.dao.CartDao;
import com.ecommerce.model.Cart;
import com.google.gson.Gson;


@Repository
public class CartDaoimpl implements CartDao {
	
	@Autowired
	SessionFactory sf;

	public void addCart(Cart c) {
		
		Session sess = sf.openSession();
		Transaction t = sess.beginTransaction();
		sess.save(c);
		t.commit();
		sess.flush();
		sess.close();

		
	}

	public String retrieveCart(String username) {

		String jsonlist;
		Session sess = sf.openSession();
		Transaction t = sess.beginTransaction();
		Criteria cri = sess.createCriteria(Cart.class);
		cri.add(Restrictions.eq("username", username));
		List crilist = cri.list();
		if(crilist.size()==0)
		{
			jsonlist = null;
		}
		else
		{	
			Gson gs = new Gson();
			jsonlist = gs.toJson(crilist);
		}
		t.commit();
		sess.close();
		return jsonlist;
	}

	public void deleteCart(String id) {

		Session sess = sf.openSession();
		Transaction t = sess.beginTransaction();
		Cart cobj = (Cart)sess.get(Cart.class, id);
		sess.delete(cobj);
		t.commit();
		sess.flush();
		sess.close();
	}

	public void updateCart(String id, int quantity) {

		Session sess = sf.openSession();
		Transaction t = sess.beginTransaction();
		Cart cobj = (Cart)sess.get(Cart.class, id);
		cobj.setQuantity(quantity);
		sess.update(cobj);
		t.commit();
		sess.close();
	}

	public long getTotalPriceOfCart(String username) {

		long total_price;
		Session sess = sf.openSession();
		Transaction t = sess.beginTransaction();
		String hql = "select sum(price*quantity) from Cart where username = '"+username+"'";
		Query qy = sess.createQuery(hql);
		if(qy.uniqueResult()==null)
		{
			total_price = 0;
		}
		else
		{	
			total_price = (Long) qy.uniqueResult();
		}
		t.commit();
		sess.flush();
		sess.close();
		return total_price;
	}

	public long getTotalQuantityOfCart(String username) {

		long total_quantity;
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
		String hql = "select sum(quantity) from Cart where username = '"+username+"'";
		Query qy = sess.createQuery(hql);
		if(qy.uniqueResult()==null)
		{
			total_quantity = 0;
		}
		else
		{	
			total_quantity =  (Long) qy.uniqueResult();
		}
		tran.commit();
		sess.flush();
		sess.close();
		return total_quantity;
	}

}
