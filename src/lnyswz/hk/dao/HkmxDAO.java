package lnyswz.hk.dao;

import java.util.List;

import lnyswz.hk.bean.Hkmx;

public interface HkmxDAO {
	public String getLastLsh(int sxkhId, String khbh);
	public List<Hkmx> findUncompletedHkmxs();
}
