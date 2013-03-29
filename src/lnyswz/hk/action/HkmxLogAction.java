package lnyswz.hk.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import lnyswz.hk.bean.Hkmx;
import lnyswz.hk.bean.HkmxLog;
import lnyswz.hk.service.HkmxLogService;
import lnyswz.hk.service.HkmxService;

import com.opensymphony.xwork2.ActionSupport;

public class HkmxLogAction extends ActionSupport {
	private HkmxLogService hkmxLogService;
	private HkmxService hkmxService;
	private int id;
	private String logNo;
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<HkmxLog> list = hkmxLogService.findHkmxLogs(id);
		request.setAttribute("list", list);
		return "log";
	}
	
	public String detail(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Hkmx> list = hkmxService.findHkmxeds(logNo);
		request.setAttribute("list", list);
		return "detail";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLogNo() {
		return logNo;
	}

	public void setLogNo(String logNo) {
		this.logNo = logNo;
	}

	public void setHkmxLogService(HkmxLogService hkmxLogService) {
		this.hkmxLogService = hkmxLogService;
	}

	public void setHkmxService(HkmxService hkmxService) {
		this.hkmxService = hkmxService;
	}
	
}
