package lnyswz.hk.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lnyswz.hk.bean.Thd;
import lnyswz.hk.bean.User;
import lnyswz.hk.bean.Xsmx;
import lnyswz.hk.service.LsckService;
import lnyswz.hk.utils.DateUtil;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LsckAction extends ActionSupport {
	private LsckService lsckService;
	
	private String year;
	private String month; 
	
	@Override
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		String bmbh = user.getOrg();
		
		String dateStr = "";
		
		if(DateUtil.getYear() == Integer.parseInt(year) && (DateUtil.getMonth() + 1) == Integer.parseInt(month)){
			dateStr = DateUtil.getCurrentDateString();
			//yearMonth = DateUtil.dateIncrease(dateStr, DateUtil.ISO_EXPANDED_DATE_FORMAT, Calendar.DATE, 1);
		}else{
			String yearMonth = year + "-" + (month.length() == 2 ? month : "0" + month) + "-01";
			dateStr = DateUtil.getLastDateOfMonth(DateUtil.stringToDate(yearMonth));
		}
		//String yearMonth = year + "-" + (month.length() == 2 ? month : "0" + month) + "-01";
		String sj = DateUtil.dateIncrease(dateStr, DateUtil.ISO_EXPANDED_DATE_FORMAT, Calendar.DATE, 1);
		
		
		List<String> thds = lsckService.findThds(sj);
		List<String> bzs = lsckService.findBzs(sj);
		
		//System.out.println("thds.size = " + thds.size());
		//for(int i = 0; i < thds.size(); i++)
		for(Iterator<String> itr = thds.iterator();itr.hasNext();)  
        {  
            //String thd = thds.get(i);
			String thd = itr.next();
            //boolean flag = false;
            for(String bz : bzs){
            	if(bz.indexOf(thd) >= 0){
            		//System.out.println("thd:" + thd);
            		//System.out.println("bz:" + bz);
            		itr.remove();
            		//flag = true;
            		break;
            	}
            }
            //if(flag){
            	//itr.remove();
            //}
        }
		//System.out.println("thds.size = " + thds.size());
		
		
		List<Thd> lscks = new ArrayList<Thd>();
		for(String thd : thds){
			lscks.addAll(lsckService.getLscks(thd, sj));
		}
		
//		for(Thd lsck : lscks){
//			System.out.println("Lsck.thsj = " + lsck.getId().getThsj());
//		}
		
		request.setAttribute("lscks", lscks);
		return SUCCESS;

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

	public void setLsckService(LsckService lsckService) {
		this.lsckService = lsckService;
	}
		
}
