package com.ecommerce.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.UserDao;
import com.ecommerce.model.User;
import com.ecommerce.service.UserService;
@Service
public class UserServiceimpl implements UserService {
	
	@Autowired
	UserDao userdao;

	public void addUser(User u) {
      
		userdao.addUser(u);
	}

	public String retrieveUser() {

		return userdao.retrieveUser();
	}

	public User fetchUserToUpdate(int id) {

		return userdao.fetchUserToUpdate(id);
	}

	public void deleteUser(int id) {

		userdao.deleteUser(id);
	}

	public void updateUser(User u) {

		userdao.updateUser(u);
	}

	public long getTotalNumberOfUsers() {

		return userdao.getTotalNumberOfUsers();
	}

}
