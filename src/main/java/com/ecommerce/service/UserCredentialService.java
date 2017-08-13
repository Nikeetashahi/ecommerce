package com.ecommerce.service;

import com.ecommerce.model.UserCredential;

public interface UserCredentialService {
	
	void addUserCredential(UserCredential uc);
	String retrieveUserCredential();
	UserCredential fetchUserCredToUpdate(String username);
	void updateUserCredentials(UserCredential uc);
	long getTotalNumberOfActiveUsers();


}
