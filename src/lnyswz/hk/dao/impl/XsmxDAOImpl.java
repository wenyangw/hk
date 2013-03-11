package lnyswz.hk.dao.impl;

import java.util.List;

import lnyswz.hk.bean.Hkmx;
import lnyswz.hk.dao.HkmxDAO;
import lnyswz.hk.dao.SxkhDAO;
import lnyswz.hk.dao.XsmxDAO;
import lnyswz.hk.utils.AbstractPagerManager;
import lnyswz.hk.utils.PagerModel;

public class XsmxDAOImpl extends AbstractPagerManager implements
		lnyswz.hk.dao.XsmxDAO {
		
	@Override
	public PagerModel findXsmxs(String bmbh, String khbh) {
		System.out.println("bmbh,khbh = " + bmbh + ", " + khbh);
		return this.searchPaginated("from Xsmx x where x.id.bmbh = ? and x.id.khbh = ?", new String[]{bmbh, khbh});
	}

}
