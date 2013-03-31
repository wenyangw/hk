package lnyswz.hk.service;

import java.util.List;

import lnyswz.hk.bean.Sxkh;
import lnyswz.hk.bean.SxkhTotal;
import lnyswz.hk.bean.Xsmx;
import lnyswz.hk.bean.XsmxS;
import lnyswz.hk.utils.PagerModel;

public interface XsmxService {
	public PagerModel findXsmxs(String bmbh, String khbh, String ywybh, String lastLsh);
	public SxkhTotal getTotal(Sxkh sxkh, String yearMonth);
	public List<SxkhTotal> getTotals(String bmbh, String yearMonth);
}
