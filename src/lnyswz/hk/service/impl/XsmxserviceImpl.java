package lnyswz.hk.service.impl;

import lnyswz.hk.dao.XsmxDAO;
import lnyswz.hk.service.XsmxService;
import lnyswz.hk.utils.PagerModel;

public class XsmxserviceImpl implements XsmxService {
	private XsmxDAO xsmxDAO;
	
	@Override
	public PagerModel findXsmxs(String bmbh, String khbh) {
		return xsmxDAO.findXsmxs(bmbh, khbh);
	}

	public void setXsmxDAO(XsmxDAO xsmxDAO) {
		this.xsmxDAO = xsmxDAO;
	}
}
