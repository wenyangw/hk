package lnyswz.hk.service;

import lnyswz.hk.bean.User;

public interface UserService {
	public void modifyPassword(User user);
	public User login(String username, String password);
	public boolean check(String username);
}
