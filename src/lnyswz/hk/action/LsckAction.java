package lnyswz.hk.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lnyswz.hk.bean.Lsck;
import lnyswz.hk.bean.User;
import lnyswz.hk.service.LsckService;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LsckAction extends ActionSupport {
	private LsckService lsckService;
	
	@Override
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		String bmbh = user.getOrg();
		
		List<Lsck> lscks = new ArrayList<Lsck>();
		
		request.setAttribute("lsck", lscks);
		return null;

	}

	public void setLsckService(LsckService lsckService) {
		this.lsckService = lsckService;
	}
		
}
