package lnyswz.hk.action;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lnyswz.hk.bean.User;
import lnyswz.hk.service.UserService;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	UserService userService;
	private String username;
	private String password;
	
	@Override
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		User user = userService.login(username, password); 
		if(user != null){
			session.setAttribute("user", user);
			return SUCCESS;
		}
		return INPUT;
	}
	
	public String check() throws IOException{
		//String str="xxoohuai";
		boolean isExist = userService.check(username);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");//解决中文乱码
		PrintStream out = new PrintStream(response.getOutputStream());//获取out输出对象
		if(isExist){
			out.println("1");
		}else{
			out.println("0");	
		}
		return null;//这里返回的是null
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
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
}
