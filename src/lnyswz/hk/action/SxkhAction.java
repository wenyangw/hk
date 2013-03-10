package lnyswz.hk.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lnyswz.hk.bean.Sxkh;
import lnyswz.hk.bean.User;
import lnyswz.hk.service.SxkhService;
import lnyswz.hk.utils.PagerModel;

import org.apache.struts2.ServletActionContext;
import org.springframework.http.HttpRequest;

import com.opensymphony.xwork2.ActionSupport;

public class SxkhAction extends ActionSupport {
	private SxkhService sxkhService;
	//���ſͻ�Id
	private int id;
	
	public String list() throws Exception {
		HttpServletRequest request = (HttpServletRequest)ServletActionContext.getRequest();
		HttpSession session = (HttpSession)request.getSession();
		
		User user = (User)session.getAttribute("user");
		String org = user.getOrg();
		
		PagerModel pg = sxkhService.findSxkhs(org);
		
		request.setAttribute("pg", pg);

		return "list";
	}
	
	public String editPage(){
		HttpServletRequest request = (HttpServletRequest)ServletActionContext.getRequest();
		
		Sxkh sxkh = sxkhService.getSxkh(id);
		request.setAttribute("sxkh", sxkh);
		return "editPage";
	}
	
	public String ye(){
		HttpServletRequest request = (HttpServletRequest)ServletActionContext.getRequest();
		
		//�������ſͻ�Id��������ſͻ�����������Ϣ
		Sxkh sxkh = sxkhService.getSxkh(id);
		
		request.setAttribute("sxkh", sxkh);
		return "ye";
	}

	public void setSxkhService(SxkhService sxkhService) {
		this.sxkhService = sxkhService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
