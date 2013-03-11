package lnyswz.hk.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import lnyswz.hk.bean.Sxkh;
import lnyswz.hk.service.SxkhService;
import lnyswz.hk.service.XsmxService;
import lnyswz.hk.utils.PagerModel;

import com.opensymphony.xwork2.ActionSupport;

public class XsmxAction extends ActionSupport {
	private SxkhService sxkhService;
	private XsmxService xsmxService;
	
	private int id;
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		Sxkh sxkh = sxkhService.getSxkh(id);
		
		PagerModel pm = xsmxService.findXsmxs(sxkh.getBmbh(), sxkh.getKhbh());
		System.out.println("Hello World");
		request.setAttribute("pm", pm);
		return "list";
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setXsmxService(XsmxService xsmxService) {
		this.xsmxService = xsmxService;
	}

	public void setSxkhService(SxkhService sxkhService) {
		this.sxkhService = sxkhService;
	}
	
}
