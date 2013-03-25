package lnyswz.hk.action;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import lnyswz.hk.bean.Hkmx;
import lnyswz.hk.service.HkmxService;
import lnyswz.hk.utils.DateUtil;

import com.opensymphony.xwork2.ActionSupport;

public class HkmxAction extends ActionSupport {
	private HkmxService hkmxService;
	private String hk;
	
	@Override
	public String execute() throws Exception {
		String[] hkmxs = hk.split(",");
		for(String mx : hkmxs){
			
			String lsh = mx.substring(0, 12);
			String hkje = mx.substring(12,mx.lastIndexOf(':'));
			String bj = mx.substring(mx.lastIndexOf(':') + 1);
			
			String hksj = DateUtil.getCurrentDateString();
			if(bj.equals("2")){
				bj = "1";
				List<Hkmx> lists = hkmxService.findUncompletedHkmxs(lsh);
				for(Hkmx hkmxEd : lists){
					hkmxEd.setCompleted("1");
					hkmxService.update(hkmxEd);
				}
			}
			Hkmx hkmx = new Hkmx();
			hkmx.setXsfplsh(lsh);
			hkmx.setHkje(new BigDecimal(hkje));
			hkmx.setHksj(hksj);
			hkmx.setCompleted(bj);
			hkmxService.save(hkmx);
		}
		return null;
	}

	public String getHk() {
		return hk;
	}

	public void setHk(String hk) {
		this.hk = hk;
	}

	public void setHkmxService(HkmxService hkmxService) {
		this.hkmxService = hkmxService;
	}
	
}
