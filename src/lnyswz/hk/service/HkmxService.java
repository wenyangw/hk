package lnyswz.hk.service;

import java.util.List;

import lnyswz.hk.bean.Hkmx;
import lnyswz.hk.bean.HkmxLog;
import lnyswz.hk.bean.HkmxTotal;

public interface HkmxService {
	public void add(Hkmx hkmx);
	public void delete(Hkmx hkmx);
	public void modify(Hkmx hkmx);
	public String getLastLsh(String bmbh, String khbh, String ywybh);
	public List<Hkmx> getLastHkmx(String bmbh, String khbh, String ywybh, String yearMonth);
	public List<Hkmx> getLastHkmxByLsh(String lastLsh);
	public List<Hkmx> findUncompletedHkmxs(String lsh);
	public List<Hkmx> findHkmxeds(String logNo);
	public List<HkmxTotal> getTotals(String bmbh, String yearMonth);
	
}
