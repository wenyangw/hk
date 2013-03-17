package lnyswz.hk.service.impl;

import java.util.List;

import lnyswz.hk.bean.Hkmx;
import lnyswz.hk.dao.HkmxDAO;
import lnyswz.hk.service.HkmxService;

public class HkmxServiceImpl implements HkmxService {
	HkmxDAO hkmxDAO;
	@Override
	public List<Hkmx> getLastHkmx(String bmbh, String khbh) {
		return hkmxDAO.getLastHkmx(bmbh, khbh);
	}
	public void setHkmxDAO(HkmxDAO hkmxDAO) {
		this.hkmxDAO = hkmxDAO;
	}
	
	
}
