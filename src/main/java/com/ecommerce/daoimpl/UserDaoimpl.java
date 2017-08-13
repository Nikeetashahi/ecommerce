package com.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.dao.UserDao;
import com.ecommerce.model.User;
import com.google.gson.Gson;


@Repository
public class UserDaoimpl implements UserDao {
	
	@Autowired
	SessionFactory sf;

	public void addUser(User u) {
       
		Session sess=sf.openSession();
		Transaction t=sess.beginTransaction();
		sess.save(u);
		t.commit();
		sess.flush();
		sess.close();
		
	}

	public String retrieveUser() {
		
		Session sess=sf.openSession();
		Transaction t=sess.beginTransaction();
		List lium = sess.createQuery("from User").list();
		Gson gs = new Gson();
		String jsonlist = gs.toJson(lium);
		t.commit();
		sess.flush();
		sess.close();
		return jsonlist;
	}

	public User fetchUserToUpdate(int id) {
		
		Session sess = sf.openSession();
		Transaction t = sess.beginTransaction();
		User UserObj = (User)sess.get(User.class, id);
		t.commit();
		sess.flush();
		sess.close();
		return UserObj;
	}

	public void deleteUser(int id) {

		Session sess = sf.openSession();
		Transaction t = sess.beginTransaction();
		User Userobj = (User)sess.get(User.class, id);
		sess.delete(Userobj);
		t.commit();
		sess.flush();
		sess.close();
	}

	public void updateUser(User u) {

		Session sess = sf.openSession();
		Transaction t = sess.beginTransaction();
		sess.update(u);
		t.commit();
		sess.flush();
		sess.close();
	}

	public long getTotalNumberOfUsers() {
		
		long totaluser;
		Session sess=sf.openSession();
		Transaction t=sess.beginTransaction();
		String hql="select * from user";
	    Query q=(Query) sess.createQuery(hql);
	    totaluser= (Long)q.uniqueResult();
	    t.commit();
	    sess.close();
		return totaluser;
	}

}
