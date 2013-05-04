package lnyswz.hk.service.impl;

import java.util.List;

import lnyswz.hk.bean.Thd;
import lnyswz.hk.dao.LsckDAO;
import lnyswz.hk.service.LsckService;

public class LsckServiceImpl implements LsckService {
	private LsckDAO lsckDAO;
	
	@Override
	public List<String> findThds(String date) {
		return lsckDAO.findThds(date);
	}
	
	@Override
	public List<String> findBzs(String date) {
		return lsckDAO.findBzs(date);
	}
	
	@Override
	public List<Thd> getLscks(String thdlsh, String date) {
		return lsckDAO.getLscks(thdlsh, date);
	}

	public void setLsckDAO(LsckDAO lsckDAO) {
		this.lsckDAO = lsckDAO;
	}
	

}
