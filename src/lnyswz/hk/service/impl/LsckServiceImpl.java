package lnyswz.hk.service.impl;

import java.util.List;

import lnyswz.hk.bean.Lsck;
import lnyswz.hk.dao.LsckDAO;
import lnyswz.hk.service.LsckService;

public class LsckServiceImpl implements LsckService {
	private LsckDAO lsckDAO;
	
	@Override
	public List<String> findThds() {
		return lsckDAO.findThds();
	}
	
	@Override
	public List<String> findBzs() {
		return lsckDAO.findBzs();
	}
	
	@Override
	public Lsck getLsck(String thdlsh) {
		return lsckDAO.getLsck(thdlsh);
	}

	public void setLsckDAO(LsckDAO lsckDAO) {
		this.lsckDAO = lsckDAO;
	}
	

}
