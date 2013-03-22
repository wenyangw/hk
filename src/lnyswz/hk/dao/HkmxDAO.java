package lnyswz.hk.dao;

import java.util.List;

import lnyswz.hk.bean.Hkmx;

public interface HkmxDAO {
	public void save(Hkmx hkmx);
	public void update(Hkmx hkmx);
	public String getLastHkLsh(String bmbh, String khbh, String ywybh);
	public List<Hkmx> getLastHkmx(String bmbh, String khbh, String ywybh);
	public List<Hkmx> findUncompletedHkmxs();
	
}
