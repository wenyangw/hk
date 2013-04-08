package lnyswz.hk.action;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lnyswz.hk.bean.Sxkh;
import lnyswz.hk.bean.SxkhTotal;
import lnyswz.hk.bean.User;
import lnyswz.hk.service.SxkhService;
import lnyswz.hk.service.XsmxService;
import lnyswz.hk.utils.DateUtil;
import lnyswz.hk.utils.PagerModel;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class SxkhAction extends ActionSupport {
	private SxkhService sxkhService;
	private XsmxService xsmxService;
	//授信客户Id
	private int id;
	private String year;
	private String month;
	
	private String khbh;
	private String khmc;
	private int days;
	private float balance;
	private float limit;
	private String lsh;
    private String bmbh;
    private String yjkh;
    private String ywybh;
    private String ywymc;
    private String lastLsh;
	
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
		
		String dateStr = "";
		if(DateUtil.getYear() == Integer.parseInt(year) && (DateUtil.getMonth() + 1) == Integer.parseInt(month)){
			dateStr = DateUtil.dateIncrease(DateUtil.getCurrentDateString(),DateUtil.ISO_EXPANDED_DATE_FORMAT, Calendar.DATE, 1);
		}else{
			String yearMonth = year + "-" + (month.length() == 2 ? month : "0" + month) + "-01";
			dateStr = DateUtil.getNextMonthFirst(DateUtil.stringToDate(yearMonth));
		}
		User user = (User)session.getAttribute("user");
		List<SxkhTotal> list = xsmxService.getTotals(user.getOrg(), dateStr);
		request.setAttribute("list", list);
		return "total";
		
	}
	
	public String editPage(){
		HttpServletRequest request = (HttpServletRequest)ServletActionContext.getRequest();
		
		Sxkh sxkh = sxkhService.getSxkh(id);
		request.setAttribute("sxkh", sxkh);
		return "editPage";
	}
	
	public String edit(){
		Sxkh sxkh;
		
		if(id != 0){
			sxkh = sxkhService.getSxkh(id);
		}else{
			sxkh = new Sxkh();
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			
			User user = (User)session.getAttribute("user");
			sxkh.setBmbh(user.getOrg());
		}
		sxkh.setKhbh(khbh);
		sxkh.setKhmc(khmc);
		sxkh.setYwybh(ywybh);
		sxkh.setYwymc(ywymc);
		sxkh.setBalance(balance);
		sxkh.setDays(days);
		sxkh.setLimit(limit);
		sxkh.setLsh(lsh);
		sxkh.setYjkh(yjkh);
		
		sxkhService.modify(sxkh);
		
		return "edit";
	}
	
	public String delete(){
		sxkhService.delete(id);
		return "edit";
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

	public String getKhbh() {
		return khbh;
	}

	public void setKhbh(String khbh) {
		this.khbh = khbh;
	}

	public String getKhmc() {
		return khmc;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public float getLimit() {
		return limit;
	}

	public void setLimit(float limit) {
		this.limit = limit;
	}

	public String getLsh() {
		return lsh;
	}

	public void setLsh(String lsh) {
		this.lsh = lsh;
	}

	public String getBmbh() {
		return bmbh;
	}

	public void setBmbh(String bmbh) {
		this.bmbh = bmbh;
	}

	public String getYjkh() {
		return yjkh;
	}

	public void setYjkh(String yjkh) {
		this.yjkh = yjkh;
	}

	public String getYwybh() {
		return ywybh;
	}

	public void setYwybh(String ywybh) {
		this.ywybh = ywybh;
	}

	public String getYwymc() {
		return ywymc;
	}

	public void setYwymc(String ywymc) {
		this.ywymc = ywymc;
	}
	
	
	public String getLastLsh() {
		return lastLsh;
	}

	public void setLastLsh(String lastLsh) {
		this.lastLsh = lastLsh;
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

	public SxkhService getSxkhService() {
		return sxkhService;
	}

	public XsmxService getXsmxService() {
		return xsmxService;
	}
	
	
}
