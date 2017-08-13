package com.ecommerce.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.UserCredentialDao;
import com.ecommerce.model.UserCredential;
import com.ecommerce.service.UserCredentialService;


@Service
public class UserCredentialServiceimpl implements UserCredentialService {
	
	@Autowired
	UserCredentialDao ucd;

	public void addUserCredential(UserCredential uc) {

		ucd.addUserCredential(uc);
	}

	public String retrieveUserCredential() {

		return ucd.retrieveUserCredential();
	}

	public UserCredential fetchUserCredToUpdate(String username) {

		return ucd.fetchUserCredToUpdate(username);
	}

	public void updateUserCredentials(UserCredential uc) {

		ucd.updateUserCredentials(uc);
	}

	public long getTotalNumberOfActiveUsers() {
		
		
		return ucd.getTotalNumberOfActiveUsers();
	}

}
