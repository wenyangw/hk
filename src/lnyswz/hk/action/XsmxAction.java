package lnyswz.hk.action;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.Request;

import lnyswz.hk.bean.Hkmx;
import lnyswz.hk.bean.Sxkh;
import lnyswz.hk.bean.SxkhTotal;
import lnyswz.hk.bean.User;
import lnyswz.hk.bean.Xsmx;
import lnyswz.hk.bean.XsmxS;
import lnyswz.hk.service.HkmxService;
import lnyswz.hk.service.SxkhService;
import lnyswz.hk.service.XsmxService;
import lnyswz.hk.utils.DateUtil;
import lnyswz.hk.utils.PagerModel;

import com.opensymphony.xwork2.ActionSupport;

public class XsmxAction extends ActionSupport {
	private SxkhService sxkhService;
	private XsmxService xsmxService;
	private HkmxService hkmxService;
	
	private int id;
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		Sxkh sxkh = sxkhService.getSxkh(id);
		
		String lastLsh = sxkh.getLastLsh();
		if(lastLsh == null){
			lastLsh = hkmxService.getLastLsh(sxkh.getBmbh(), sxkh.getKhbh(), sxkh.getYwybh());
		}
		
		//List<Hkmx> hkmxs = hkmxService.getLastHkmx(sxkh.getBmbh(), sxkh.getKhbh(), sxkh.getYwybh());
		List<Hkmx> hkmxs = hkmxService.getLastHkmxByLsh(lastLsh);
		Hkmx hkmx = new Hkmx();
		hkmx.setHkje(new BigDecimal(0));
		for(Hkmx h : hkmxs){
			hkmx.setHkje(hkmx.getHkje().add(h.getHkje()));
			hkmx.setXsfplsh(h.getXsfplsh());
		}
		
		PagerModel pm1 = xsmxService.findXsmxs(sxkh.getBmbh(), sxkh.getKhbh(), sxkh.getYwybh(), lastLsh);
		PagerModel pm = new PagerModel();
		
		List<Object> list1 = pm1.getList();
		List<Object> list = new ArrayList<Object>();
		
		for(Object xsmx: list1){
			XsmxS xsmxS = new XsmxS((Xsmx)xsmx, sxkh.getDays(), sxkh.getYjkh());
			
			list.add(xsmxS);
		}
		
		pm.setTotal(pm1.getTotal());
		pm.setList(list);
		
		request.setAttribute("pm", pm);
		request.setAttribute("hkmx", hkmx);
		request.setAttribute("sxkh", sxkh);
		return "list";
	}
	
	public String total(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		Sxkh sxkh = sxkhService.getSxkh(id); 
		String yearMonth = DateUtil.getYear(DateUtil.getCurrentDateTime()) + "-" + DateUtil.getMonth(DateUtil.getCurrentDateTime()) + "-01";
		String dateStr = DateUtil.dateToString(DateUtil.dateIncreaseByMonth(DateUtil.stringToDate(yearMonth),1));
		SxkhTotal total = xsmxService.getTotal(sxkh, dateStr);
		request.setAttribute("total", total);
		request.setAttribute("sumOf", sxkh.getLimit());
		return "total";
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

	public void setHkmxService(HkmxService hkmxService) {
		this.hkmxService = hkmxService;
	}
	
	
}
