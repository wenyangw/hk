package lnyswz.hk.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lnyswz.hk.bean.Lsck;
import lnyswz.hk.bean.User;
import lnyswz.hk.bean.Xsmx;
import lnyswz.hk.service.LsckService;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LsckAction extends ActionSupport {
	private LsckService lsckService;
	
	@Override
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		String bmbh = user.getOrg();
		
		List<String> thds = lsckService.findThds();
		List<String> bzs = lsckService.findBzs();
		
		System.out.println("thds.size = " + thds.size());
		//for(int i = 0; i < thds.size(); i++)
		for(Iterator<String> itr = thds.iterator();itr.hasNext();)  
        {  
            //String thd = thds.get(i);
			String thd = itr.next();
            //boolean flag = false;
            for(String bz : bzs){
            	if(bz.indexOf(thd) >= 0){
            		System.out.println("thd:" + thd);
            		System.out.println("bz:" + bz);
            		itr.remove();
            		//flag = true;
            		break;
            	}
            }
            //if(flag){
            	//itr.remove();
            //}
        }
		System.out.println("thds.size = " + thds.size());
		
		List<Lsck> lscks = new ArrayList<Lsck>();
		for(String thd : thds){
			lscks.add(lsckService.getLsck(thd));
		}
		
		request.setAttribute("lsck", lscks);
		return null;

	}

	public void setLsckService(LsckService lsckService) {
		this.lsckService = lsckService;
	}
		
}
