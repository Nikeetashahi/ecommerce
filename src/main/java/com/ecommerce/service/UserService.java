package com.ecommerce.service;

import com.ecommerce.model.User;

public interface UserService {
	
	void addUser(User u);
	String retrieveUser();
	User fetchUserToUpdate(int id);
	void deleteUser(int id);
	void updateUser(User u);
	long getTotalNumberOfUsers();
	String fetchproductbyid(id)


}
