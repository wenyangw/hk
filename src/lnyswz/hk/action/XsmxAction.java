package lnyswz.hk.action;


import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JasperCompileManager;

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
	private List<XsmxS> xsmxSs;
	private Map<String, Object> map;
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		Sxkh sxkh = sxkhService.getSxkh(id);
		
		Hkmx hkmx = getHkmx(sxkh);
		
		String lastLsh = hkmx.getXsfplsh();
		
		xsmxSs = getXsmxSs(sxkh, lastLsh);
		
//		List<Hkmx> hkmxs = hkmxService.getLastHkmx(sxkh.getBmbh(), sxkh.getKhbh(), sxkh.getYwybh());
//		BigDecimal hked = new BigDecimal(0);
//		if(hkmxs.size() != 0){
//			if(lastLsh == null){
//				lastLsh = hkmxs.get(0).getXsfplsh();
//			}
//			//计算最后一笔已还款金额
//			for(Hkmx hkmx : hkmxs){
//				hked = hked.add(hkmx.getHkje());
//			}
//		}else{
//			if(lastLsh == null || lastLsh.trim().equals("")){
//				lastLsh = sxkh.getLsh();
//			}else{
//				String str = lastLsh.substring(7);
//				int i = Integer.parseInt(str) + 1;
//				lastLsh = lastLsh.substring(0, 7).concat(String.format("%04d", i));
//			}
//		}
//		
//		Hkmx hkmx = new Hkmx();
//		hkmx.setHkje(hked);
//		hkmx.setXsfplsh(lastLsh);
		
//		List<Xsmx> xsmxs= xsmxService.findXsmxs(sxkh.getBmbh(), sxkh.getKhbh(), sxkh.getYwybh(), lastLsh);
//		
//		List<XsmxS> xsmxSs = new ArrayList<XsmxS>();
//		
//		for(Xsmx xsmx: xsmxs){
//			XsmxS xsmxS = new XsmxS(xsmx, sxkh.getDays(), sxkh.getYjkh());
//			
//			xsmxSs.add(xsmxS);
//		}
		
		request.setAttribute("list", xsmxSs);
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
	
	public String print(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Sxkh sxkh = sxkhService.getSxkh(id);
		map = new HashMap<String, Object>();
		
		Hkmx hkmx = getHkmx(sxkh);
		String lastLsh = hkmx.getXsfplsh();
		
		xsmxSs = getXsmxSs(sxkh, lastLsh);
		
		map.put("bmmc", "wdys");
		try{
			String reportSource;
			reportSource = ServletActionContext.getServletContext().getRealPath("/report/xsmx.jrxml");
			File parent = new File(reportSource).getParentFile();
			JasperCompileManager.compileReportToFile(reportSource, new File(parent, "xsmx_report.jasper").getAbsolutePath());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ERROR;
		}
		return "print";
	}
	
	public List<XsmxS> getXsmxSs(Sxkh sxkh, String lastLsh){
		List<Xsmx> xsmxs= xsmxService.findXsmxs(sxkh.getBmbh(), sxkh.getKhbh(), sxkh.getYwybh(), lastLsh);
		
		List<XsmxS> xsmxSs = new ArrayList<XsmxS>();
		
		for(Xsmx xsmx: xsmxs){
			XsmxS xsmxS = new XsmxS(xsmx, sxkh.getDays(), sxkh.getYjkh());
			
			xsmxSs.add(xsmxS);
		}
		
		return xsmxSs;
	}
	
	public Hkmx getHkmx(Sxkh sxkh){
		String lastLsh = sxkh.getLastLsh();
		List<Hkmx> hkmxs = hkmxService.getLastHkmx(sxkh.getBmbh(), sxkh.getKhbh(), sxkh.getYwybh());
		BigDecimal hked = new BigDecimal(0);
		if(hkmxs.size() != 0){
			if(lastLsh == null){
				lastLsh = hkmxs.get(0).getXsfplsh();
			}
			//计算最后一笔已还款金额
			for(Hkmx hkmx : hkmxs){
				hked = hked.add(hkmx.getHkje());
			}
		}else{
			if(lastLsh == null || lastLsh.trim().equals("")){
				lastLsh = sxkh.getLsh();
			}else{
				String str = lastLsh.substring(7);
				int i = Integer.parseInt(str) + 1;
				lastLsh = lastLsh.substring(0, 7).concat(String.format("%04d", i));
			}
		}
		
		Hkmx hkmx = new Hkmx();
		hkmx.setHkje(hked);
		hkmx.setXsfplsh(lastLsh);
		
		return hkmx;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<XsmxS> getXsmxSs() {
		return xsmxSs;
	}

	public Map<String, Object> getMap() {
		return map;
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
