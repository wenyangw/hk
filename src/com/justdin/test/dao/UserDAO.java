package com.justdin.test.dao;

import lnyswz.hk.utils.PagerModel;

import com.justdin.test.bean.User;


public interface UserDAO {
	public void add(User user);
	
	public void delete(int userId);
	
	public void modify(User user);
	
	public User findUserById(int userId);
	
	public User findUserByName(String username);
	
	public PagerModel findUsers();
	
}
