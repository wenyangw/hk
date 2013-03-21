package lnyswz.hk.action;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.corba.se.impl.copyobject.JavaStreamObjectCopierImpl;

public class HkmxAction extends ActionSupport {
	private String hk;
	
	@Override
	public String execute() throws Exception {
		Gson gson = new Gson();
		List list = gson.fromJson(hk, );
		return SUCCESS;
	}

	public String getHk() {
		return hk;
	}

	public void setHk(String hk) {
		this.hk = hk;
	}
	
	
}
