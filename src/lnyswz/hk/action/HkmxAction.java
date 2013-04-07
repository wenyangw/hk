package lnyswz.hk.action;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import lnyswz.hk.bean.Hkmx;
import lnyswz.hk.bean.HkmxLog;
import lnyswz.hk.bean.HkmxTotal;
import lnyswz.hk.bean.Sxkh;
import lnyswz.hk.bean.SxkhTotal;
import lnyswz.hk.bean.User;
import lnyswz.hk.service.HkmxLogService;
import lnyswz.hk.service.HkmxService;
import lnyswz.hk.service.SxkhService;
import lnyswz.hk.utils.DateUtil;

import com.opensymphony.xwork2.ActionSupport;

public class HkmxAction extends ActionSupport {
	private HkmxService hkmxService;
	private HkmxLogService hkmxLogService;
	private SxkhService sxkhService;
	private String hk;
	private String hkzje;
	private int sxkhId;
	private String year;
	private String month;
	private String hkTime;
	
	@Override
	public String execute() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute("user");
				
		//生成还款记录号
		String logNo = user.getUsername() + DateUtil.getTime();
		//String hksj = DateUtil.getCurrentDateString();
		
		String lastLsh = hk.substring(0,11);
		//String newLsh = "";
		String lsh = "";
		String[] hkmxs = hk.split(",");
		boolean isCompleted = true;
		for(String mx : hkmxs){
			lsh = mx.substring(0, 11);
			String hkje = mx.substring(12,mx.lastIndexOf(':'));
			String bj = mx.substring(mx.lastIndexOf(':') + 1);
			
			if(bj.equals("2")){
				bj = "1";
				List<Hkmx> lists = hkmxService.findUncompletedHkmxs(lsh);
				if(lists.size() != 0){
					for(Hkmx hkmxEd : lists){
						hkmxEd.setCompleted("1");
						hkmxService.modify(hkmxEd);
					}
				}
			}
			if(bj.equals("0")){
				isCompleted = false;
			}
			//newLsh = lsh;
			
			Hkmx hkmx = new Hkmx();
			hkmx.setXsfplsh(lsh);
			hkmx.setHkje(new BigDecimal(hkje));
			//hkmx.setHksj(hksj);
			hkmx.setHksj(hkTime);
			hkmx.setCompleted(bj);
			hkmx.setLogNo(logNo);
			hkmxService.add(hkmx);
		}
		
		HkmxLog hkmxLog = new HkmxLog();
		hkmxLog.setHkje(new BigDecimal(hkzje));
		//hkmxLog.setHksj(hksj);
		hkmxLog.setHksj(hkTime);
		hkmxLog.setLastLsh(lastLsh);
		hkmxLog.setLogNo(logNo);
		hkmxLog.setSxkhId(sxkhId);
		
		hkmxLogService.addLog(hkmxLog);
		
		
		Sxkh sxkh = sxkhService.getSxkh(sxkhId);
		if (isCompleted){
			String str = lsh.substring(7);
			int i = Integer.parseInt(str) + 1;
			lsh = lsh.substring(0, 7).concat(String.format("%04d", i));
		}
		sxkh.setLastLsh(lsh);
		
		sxkhService.modify(sxkh);
		
		return null;
	}
	
	public String listTotal(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		String yearMonth = year + "-" + (month.length() == 2 ? month : "0" + month);
		List<HkmxTotal> list = hkmxService.getTotals(user.getOrg(), yearMonth);
		
		request.setAttribute("list", list);
		return "total";
	}
	
	public String getHk() {
		return hk;
	}

	public void setHk(String hk) {
		this.hk = hk;
	}
	
	public String getHkzje() {
		return hkzje;
	}

	public void setHkzje(String hkzje) {
		this.hkzje = hkzje;
	}
	
	public int getSxkhId() {
		return sxkhId;
	}

	public void setSxkhId(int sxkhId) {
		this.sxkhId = sxkhId;
	}
	
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
	
	public String getHkTime() {
		return hkTime;
	}

	public void setHkTime(String hkTime) {
		this.hkTime = hkTime;
	}

	public void setHkmxService(HkmxService hkmxService) {
		this.hkmxService = hkmxService;
	}

	public void setSxkhService(SxkhService sxkhService) {
		this.sxkhService = sxkhService;
	}

	public void setHkmxLogService(HkmxLogService hkmxLogService) {
		this.hkmxLogService = hkmxLogService;
	}
	
	
}
