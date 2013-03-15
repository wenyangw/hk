package lnyswz.hk.service.impl;

import lnyswz.hk.bean.Hkmx;
import lnyswz.hk.dao.HkmxDAO;
import lnyswz.hk.service.HkmxService;

public class HkmxServiceImpl implements HkmxService {
	HkmxDAO hkmxDAO;
	@Override
	public Hkmx getLastHkmx(String bmbh, String khbh) {
		// TODO Auto-generated method stub
		return null;
	}
	public void setHkmxDAO(HkmxDAO hkmxDAO) {
		this.hkmxDAO = hkmxDAO;
	}
	
	
}
