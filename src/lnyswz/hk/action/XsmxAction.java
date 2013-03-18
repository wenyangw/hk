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
		
		List<Hkmx> hkmxs = hkmxService.getLastHkmx(sxkh.getBmbh(), sxkh.getKhbh());
		Hkmx hkmx = new Hkmx();
		hkmx.setHkje(new BigDecimal(0));
		for(Hkmx h : hkmxs){
			hkmx.setHkje(hkmx.getHkje().add(h.getHkje()));
			hkmx.setXsfplsh(h.getXsfplsh());
		}
		
		
		PagerModel pm1 = xsmxService.findXsmxs(sxkh.getBmbh(), sxkh.getKhbh());
		PagerModel pm = new PagerModel();
		
		List<Object> list1 = pm1.getList();
		List<Object> list = new ArrayList<Object>();
		
		for(Object xsmx: list1){
			XsmxS xsmxs = new XsmxS();
			xsmxs.setBmbh(((Xsmx)xsmx).getId().getBmbh());
			xsmxs.setKhbh(((Xsmx)xsmx).getId().getKhbh());
			xsmxs.setKpsj(((Xsmx)xsmx).getId().getKpsj());
			xsmxs.setXsfplsh(((Xsmx)xsmx).getId().getXsfplsh());
			xsmxs.setXsje(((Xsmx)xsmx).getId().getXsje());
			xsmxs.setHksj(DateUtil.dateIncreaseByDay(((Xsmx)xsmx).getId().getKpsj(), DateUtil.ISO_EXPANDED_DATE_FORMAT, sxkh.getDays()));
			
			list.add(xsmxs);
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
		
		SxkhTotal total = xsmxService.total(sxkh);
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
