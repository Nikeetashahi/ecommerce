package com.ecommerce.dao;

import com.ecommerce.model.User;

public interface UserDao {
	
	void addUser(User u);
	String retrieveUser();
	User fetchUserToUpdate(int id);
	void deleteUser(int id);
	void updateUser(User u);
	long getTotalNumberOfUsers();
}

