package lnyswz.hk.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lnyswz.hk.bean.Sxkh;
import lnyswz.hk.bean.SxkhTotal;
import lnyswz.hk.bean.User;
import lnyswz.hk.service.SxkhService;
import lnyswz.hk.service.XsmxService;
import lnyswz.hk.utils.PagerModel;

import org.apache.struts2.ServletActionContext;
import org.springframework.http.HttpRequest;

import com.opensymphony.xwork2.ActionSupport;

public class SxkhAction extends ActionSupport {
	private SxkhService sxkhService;
	private XsmxService xsmxService;
	//授信客户Id
	private int id;
	
	public String list() throws Exception {
		HttpServletRequest request = (HttpServletRequest)ServletActionContext.getRequest();
		HttpSession session = (HttpSession)request.getSession();
		
		User user = (User)session.getAttribute("user");
		String org = user.getOrg();
		
		PagerModel pm = sxkhService.findSxkhs(org);
		
		request.setAttribute("pm", pm);

		return "list";
	}
	
	public String listTotal(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		List<SxkhTotal> list = xsmxService.getTotals(user.getOrg());
		
		request.setAttribute("list", list);
		return "total";
		
	}
	
	public String editPage(){
		HttpServletRequest request = (HttpServletRequest)ServletActionContext.getRequest();
		
		Sxkh sxkh = sxkhService.getSxkh(id);
		request.setAttribute("sxkh", sxkh);
		return "editPage";
	}
	
	public String ye(){
		HttpServletRequest request = (HttpServletRequest)ServletActionContext.getRequest();
		
		//根据授信客户Id，获得授信客户基本授信信息
		Sxkh sxkh = sxkhService.getSxkh(id);
		
		request.setAttribute("sxkh", sxkh);
		return "ye";
	}

	public void setSxkhService(SxkhService sxkhService) {
		this.sxkhService = sxkhService;
	}
	
	public void setXsmxService(XsmxService xsmxService) {
		this.xsmxService = xsmxService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
