package com.justdin.test.action;

import org.apache.struts2.ServletActionContext;

import com.justdin.test.bean.User;
import com.justdin.test.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private UserService userService;
	
	private String username;
	private String password;
	
	@Override
	public String execute() throws Exception {
		User user = userService.login(username, password);
		if(user != null){
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return SUCCESS;
		}
		return INPUT;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
