package com.ecommerce.daoimpl;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.dao.UserCredentialDao;
import com.ecommerce.model.UserCredential;
import com.google.gson.Gson;


@Repository
public class UserCredentialDaoimpl implements UserCredentialDao {
	
	@Autowired
	SessionFactory sf;

	public void addUserCredential(UserCredential uc) {

		Session sess = sf.openSession();
		Transaction t = sess.beginTransaction();
		sess.save(uc);
		t.commit();
		sess.flush();
		sess.close();
	}

	public String retrieveUserCredential() {
		
		Session sess = sf.openSession();
		Transaction t = sess.beginTransaction();
		List listuc = sess.createQuery("from UserCredential").list();
		Gson gs = new Gson();
		String jsonlist = gs.toJson(listuc);
		t.commit();
		sess.flush();
		sess.close();
		return jsonlist;

	}

	public UserCredential fetchUserCredToUpdate(String username) {
		
		Session sess = sf.openSession();
		Transaction t = sess.beginTransaction();
		UserCredential ucobj = (UserCredential)sess.get(UserCredential.class, username);
		t.commit();
		sess.flush();
		sess.close();
		return ucobj;
	}

	public void updateUserCredentials(UserCredential uc) {
		
		Session sess = sf.openSession();
		Transaction t = sess.beginTransaction();
		sess.update(uc);
		sess.flush();
		t.commit();
		sess.close();

		
	}

	public long getTotalNumberOfActiveUsers() {
		long totalactiveusers;
		Session sess = sf.openSession();
		Transaction t = sess.beginTransaction();
		Criteria cri = sess.createCriteria(UserCredential.class);
		cri.add(Restrictions.eq("role", "ROLE_USER"));
		cri.add(Restrictions.eq("enabled", true));
		cri.setProjection(Projections.rowCount());
		totalactiveusers =  (Long) cri.uniqueResult();
		t.commit();
		sess.close();
		return totalactiveusers;
	}

}
