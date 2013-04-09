package lnyswz.hk.service;

import java.util.List;

import lnyswz.hk.bean.User;

public interface UserService {
	public User getUser(int id);
	public void modifyPassword(User user);
	public User login(String username, String password);
	public boolean check(String username);
	public List<User> findUsers();
}
