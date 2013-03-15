package lnyswz.hk.service.impl;

import lnyswz.hk.dao.HkmxDAO;
import lnyswz.hk.dao.XsmxDAO;
import lnyswz.hk.service.XsmxService;
import lnyswz.hk.utils.PagerModel;

public class XsmxServiceImpl implements XsmxService {
	private XsmxDAO xsmxDAO;
	private HkmxDAO hkmxDAO;
	
	@Override
	public PagerModel findXsmxs(String bmbh, String khbh) {
		String xsfplsh = hkmxDAO.getLastHkLsh(bmbh, khbh);
		return xsmxDAO.findXsmxs(bmbh, khbh, xsfplsh);
	}

	public void setXsmxDAO(XsmxDAO xsmxDAO) {
		this.xsmxDAO = xsmxDAO;
	}

	public void setHkmxDAO(HkmxDAO hkmxDAO) {
		this.hkmxDAO = hkmxDAO;
	}
	
}
