package lnyswz.hk.service.impl;

import java.util.List;

import lnyswz.hk.bean.Sxkh;
import lnyswz.hk.dao.SxkhDAO;
import lnyswz.hk.service.SxkhService;
import lnyswz.hk.utils.PagerModel;

public class SxkhServiceImpl implements SxkhService {
	private SxkhDAO sxkhDAO;
	@Override
	public PagerModel findSxkhs(String org) {
		return sxkhDAO.findSxkhByOrg(org);
	}
	
	@Override
	public List<Sxkh> getSxkhs(String org) {
		return sxkhDAO.getSxkhs(org);
	}
	
	@Override
	public void modify(Sxkh sxkh) {
		sxkhDAO.modify(sxkh);
	}
	
	public Sxkh getSxkh(int id){
		return sxkhDAO.getSxkh(id);
	}
	
	public void setSxkhDAO(SxkhDAO sxkhDAO) {
		this.sxkhDAO = sxkhDAO;
	}
	
}
