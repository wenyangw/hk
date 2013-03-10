package lnyswz.hk.service.impl;

import lnyswz.hk.bean.User;
import lnyswz.hk.dao.UserDAO;
import lnyswz.hk.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;
	
	public void modifyPassword(User user) {
		userDAO.modifyUser(user);
	}
	
	public User login(String username, String password){
		User user = userDAO.findUserByName(username);
		if(user == null){
			return null;
		}
		if(user.isUsed()){
			if(password.equals(user.getPassword())){
				return user;
			}
		}else{
			System.out.println("该用户已禁用");
		}
		return null;
	}
	
	public boolean check(String username){
		User user = userDAO.findUserByName(username);
		if(user != null){
			return true;
		}
		return false;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
