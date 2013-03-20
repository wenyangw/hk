package lnyswz.hk.service;

import lnyswz.hk.bean.Sxkh;
import lnyswz.hk.bean.SxkhTotal;
import lnyswz.hk.utils.PagerModel;

public interface XsmxService {
	public PagerModel findXsmxs(String bmbh, String khbh, String ywybh);
	public SxkhTotal total(Sxkh sxkh);
}
