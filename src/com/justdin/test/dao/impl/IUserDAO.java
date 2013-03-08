package com.justdin.test.dao.impl;

import com.justdin.test.bean.User;
import com.justdin.test.dao.UserDAO;
import com.justdin.utils.AbstractPagerManager;
import com.justdin.utils.PagerModel;

public class IUserDAO extends AbstractPagerManager implements UserDAO {

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public User findUserByName(String username) {
		return  (User)this.getHibernateTemplate().find("from User u where u.username = ?", username).get(0);
	}

	@Override
	public PagerModel findUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(User user) {
		// TODO Auto-generated method stub

	}

}
