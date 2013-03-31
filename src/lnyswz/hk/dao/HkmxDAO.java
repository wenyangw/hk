package lnyswz.hk.dao;

import java.util.List;

import lnyswz.hk.bean.Hkmx;
import lnyswz.hk.bean.HkmxLog;

public interface HkmxDAO {
	public void save(Hkmx hkmx);
	public void update(Hkmx hkmx);
	public void delete(Hkmx hkmx);
	public String getLastHkLsh(String bmbh, String khbh, String ywybh);
	public List<Hkmx> getLastHkmx(String bmbh, String khbh, String ywybh);
	public List<Hkmx> getLastHkmxByLsh(String lastLsh);
	public List<Hkmx> findUncompletedHkmxs(String lsh);
	public List<Hkmx> findHkmxeds(String logNo);
	public List<Hkmx> findHkmxs(int sxkhId, String yearMonth);
	
}
