package lnyswz.hk.dao;

import lnyswz.hk.bean.User;
import lnyswz.hk.utils.PagerModel;

public interface UserDAO {
	public void addUser(User user);
	
	public void deleteUser(int userId);
	
	public void modifyUser(User user);
	
	public User findUser(int userId);
	
	public User findUserByName(String username);
	
	public PagerModel findUsers();
}
