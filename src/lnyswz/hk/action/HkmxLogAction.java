package lnyswz.hk.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import lnyswz.hk.bean.Hkmx;
import lnyswz.hk.bean.HkmxLog;
import lnyswz.hk.bean.Sxkh;
import lnyswz.hk.service.HkmxLogService;
import lnyswz.hk.service.HkmxService;
import lnyswz.hk.service.SxkhService;

import com.opensymphony.xwork2.ActionSupport;

public class HkmxLogAction extends ActionSupport {
	private HkmxLogService hkmxLogService;
	private HkmxService hkmxService;
	private SxkhService sxkhService;
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
	
	public String delete(){
		HttpServletRequest request = ServletActionContext.getRequest();
		//待删除的HkmxLog
		HkmxLog hkmxLog = hkmxLogService.getHkmxLog(id);
		String logNo = hkmxLog.getLogNo();
		//待删除的Hkmx
		List<Hkmx> hkmxs = hkmxService.findHkmxeds(logNo);
		for(Hkmx hkmx : hkmxs){
			hkmxService.delete(hkmx);
		}
		//恢复上次未还清Hkmx的completed标志
		String lastLsh = hkmxLog.getLastLsh();
		List<Hkmx> hkmxLasts = hkmxService.findUncompletedHkmxs(lastLsh);
		for(Hkmx hkmx : hkmxLasts){
			hkmx.setCompleted("0");
			hkmxService.modify(hkmx);
		}
		//更新Sxkh对应的最后未还清的发票号
		int sxkhId = hkmxLog.getSxkhId();
		Sxkh sxkh = sxkhService.getSxkh(sxkhId);
		sxkh.setLastLsh(lastLsh);
		sxkhService.modify(sxkh);
		
		hkmxLogService.delete(hkmxLog);
		request.setAttribute("sxkhId", sxkhId);
		return "delete";
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

	public void setSxkhService(SxkhService sxkhService) {
		this.sxkhService = sxkhService;
	}
	
}
