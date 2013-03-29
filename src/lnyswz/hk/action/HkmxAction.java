package lnyswz.hk.action;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import lnyswz.hk.bean.Hkmx;
import lnyswz.hk.bean.HkmxLog;
import lnyswz.hk.bean.User;
import lnyswz.hk.service.HkmxService;
import lnyswz.hk.utils.DateUtil;

import com.opensymphony.xwork2.ActionSupport;

public class HkmxAction extends ActionSupport {
	private HkmxService hkmxService;
	private String hk;
	private String hkzje;
	private int sxkhId;
	
	@Override
	public String execute() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute("user");
				
		//生成还款记录号
		String logNo = user.getUsername() + DateUtil.getTime();
		String hksj = DateUtil.getCurrentDateString();
		String lastLsh = hk.substring(0,11);
					
		String[] hkmxs = hk.split(",");
		for(String mx : hkmxs){
			String lsh = mx.substring(0, 11);
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
			Hkmx hkmx = new Hkmx();
			hkmx.setXsfplsh(lsh);
			hkmx.setHkje(new BigDecimal(hkje));
			hkmx.setHksj(hksj);
			hkmx.setCompleted(bj);
			hkmx.setLogNo(logNo);
			hkmxService.add(hkmx);
		}
		
		HkmxLog hkmxLog = new HkmxLog();
		hkmxLog.setHkje(new BigDecimal(hkzje));
		hkmxLog.setHksj(hksj);
		hkmxLog.setLastLsh(lastLsh);
		hkmxLog.setLogNo(logNo);
		hkmxLog.setSxkhId(sxkhId);
		
		hkmxService.addLog(hkmxLog);
		
		return null;
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

	public void setHkmxService(HkmxService hkmxService) {
		this.hkmxService = hkmxService;
	}
	
}
