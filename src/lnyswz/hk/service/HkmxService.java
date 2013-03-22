package lnyswz.hk.service;

import java.util.List;

import lnyswz.hk.bean.Hkmx;

public interface HkmxService {
	public void save(Hkmx hkmx);
	public void update(Hkmx hkmx);
	public List<Hkmx> getLastHkmx(String bmbh, String khbh, String ywybh);
	
	
}
