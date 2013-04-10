package lnyswz.hk.service.impl;

import java.util.List;

import lnyswz.hk.bean.User;
import lnyswz.hk.dao.UserDAO;
import lnyswz.hk.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;
	
	@Override
	public User getUser(int id) {
		return userDAO.findUser(id);
	}
	
	@Override
	public void modifyUser(User user) {
		userDAO.modifyUser(user);
	}
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
	
	@Override
	public List<User> findUsers() {
		return userDAO.findUsers();
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
