package com.ecommerce.dao;

import com.ecommerce.model.UserCredential;

public interface UserCredentialDao {
	
	void addUserCredential(UserCredential uc);
	String retrieveUserCredential();
	UserCredential fetchUserCredToUpdate(String username);
	void updateUserCredentials(UserCredential uc);
	long getTotalNumberOfActiveUsers();

}
