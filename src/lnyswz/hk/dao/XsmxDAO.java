package lnyswz.hk.dao;

import java.util.List;

import lnyswz.hk.bean.Xsmx;
import lnyswz.hk.utils.PagerModel;

public interface XsmxDAO {
	public PagerModel findXsmxs(String bmbh, String khbh, String xsfplsh);
	public List<Xsmx> findXsmxsList(String bmbh, String khbh, String xsfplsh);
}
