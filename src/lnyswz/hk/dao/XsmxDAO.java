package lnyswz.hk.dao;

import java.util.List;

import lnyswz.hk.bean.Xsmx;

public interface XsmxDAO {
	public List<Xsmx> findXsmxs(String bmbh, String khbh, String ywybh, String xsfplsh, String date);
	public Xsmx getXsmx(String xsfplsh);
	public List<Xsmx> findXsmxsList(String bmbh, String khbh, String xsfplsh, String ywybh, String yearMonth);
}
