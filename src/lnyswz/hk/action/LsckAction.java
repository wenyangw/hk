package lnyswz.hk.action;

import javax.servlet.http.HttpSession;

import lnyswz.hk.bean.User;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LsckAction extends ActionSupport {
	HttpSession session = ServletActionContext.getRequest().getSession();
	
	User user = (User)session.getAttribute("user");
	String bmbh = user.getOrg();
	
	
}
