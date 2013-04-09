package lnyswz.hk.service;

import java.util.List;

import lnyswz.hk.bean.Hkmx;
import lnyswz.hk.bean.Sxkh;
import lnyswz.hk.bean.SxkhTotal;
import lnyswz.hk.bean.Xsmx;

public interface XsmxService {
	public List<Xsmx> findXsmxs(String bmbh, String khbh, String ywybh, String lastLsh, String date);
	public SxkhTotal getTotal(Sxkh sxkh, String yearMonth);
	public List<SxkhTotal> getTotals(String bmbh, String yearMonth);
}
