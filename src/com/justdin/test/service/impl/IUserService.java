package com.justdin.test.service.impl;

import com.justdin.test.bean.User;
import com.justdin.test.dao.UserDAO;
import com.justdin.test.service.UserService;

public class IUserService implements UserService {
	private UserDAO userDAO;
	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		User user = userDAO.findUserByName(username);
		if(password.equals(user.getPassword())){
			return user;
		}
		return null;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	

}
