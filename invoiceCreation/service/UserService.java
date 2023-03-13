package com.alacriti.invoiceCreation.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.invoiceCreation.dao.UserDAO;
import com.alacriti.invoiceCreation.vo.User;

public class UserService {

	private static Logger log = Logger.getLogger(UserService.class.getName());
	UserDAO userDao = new UserDAO();
	
	public List<User> getUsers() {
		
		return null;
	}

	public User signUp(User user) {
		
		log.info("in UserService--->signUp Method starts.");
		return userDao.signUp(user);
	}

	public User login(User user) {
		
		log.info("in UserService--->login Method starts.");
		return userDao.login(user);
	}

	public User getUserById(int id) {
		
		log.info("in UserService--->getUserById Method starts.");
		return userDao.getUserById(id);
	}

	public User updateProfile(User user) {
		
		log.info("in UserService--->updateProfile Method starts.");
		int rowsUpdated = 0;
		rowsUpdated = userDao.updateProfile(user);
		return getUserById(user.getId());
	}

	public User updateUserDetails(User user) {
		
		log.info("in UserService--->updateUserDetails Method starts.");
		int rowsUpdated = 0;
		rowsUpdated = userDao.updateUserDetails(user);
		return getUserById(user.getId());
	}

}
