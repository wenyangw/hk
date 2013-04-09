package lnyswz.hk.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lnyswz.hk.bean.User;
import lnyswz.hk.service.UserService;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private UserService userService;
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		List<User> users = userService.findUsers();
		
		request.setAttribute("users", users);
		return "list";
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
