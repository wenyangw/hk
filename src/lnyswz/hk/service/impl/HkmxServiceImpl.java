package lnyswz.hk.service.impl;

import java.util.List;

import lnyswz.hk.bean.Hkmx;
import lnyswz.hk.dao.HkmxDAO;
import lnyswz.hk.service.HkmxService;

public class HkmxServiceImpl implements HkmxService {
	HkmxDAO hkmxDAO;
	
	@Override
	public void add(Hkmx hkmx) {
		hkmxDAO.save(hkmx);
	}
	@Override
	public void modify(Hkmx hkmx) {
		hkmxDAO.update(hkmx);
	}
	
	@Override
	public List<Hkmx> getLastHkmx(String bmbh, String khbh, String ywybh) {
		return hkmxDAO.getLastHkmx(bmbh, khbh, ywybh);
	}
	
	@Override
	public List<Hkmx> findUncompletedHkmxs(String lsh) {
		
		return hkmxDAO.findUncompletedHkmxs(lsh);
	}
	
	
	public void setHkmxDAO(HkmxDAO hkmxDAO) {
		this.hkmxDAO = hkmxDAO;
	}
	
	
}
