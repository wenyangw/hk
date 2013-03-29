package lnyswz.hk.service;

import java.util.List;

import lnyswz.hk.bean.Hkmx;
import lnyswz.hk.bean.HkmxLog;

public interface HkmxService {
	public void add(Hkmx hkmx);
	public void modify(Hkmx hkmx);
	public void addLog(HkmxLog log);
	public List<Hkmx> getLastHkmx(String bmbh, String khbh, String ywybh);
	public List<Hkmx> findUncompletedHkmxs(String lsh);
	public List<Hkmx> findHkmxeds(String logNo);
	
	
}
