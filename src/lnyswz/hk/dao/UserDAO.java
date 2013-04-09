package lnyswz.hk.dao;

import java.util.List;

import lnyswz.hk.bean.User;
import lnyswz.hk.utils.PagerModel;

public interface UserDAO {
	public void addUser(User user);
	
	public void deleteUser(int userId);
	
	public void modifyUser(User user);
	
	public User findUser(int userId);
	
	public User findUserByName(String username);
	
	public List<User> findUsers();
}
