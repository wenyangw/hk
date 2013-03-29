package lnyswz.hk.dao.impl;

import java.util.List;

import lnyswz.hk.bean.HkmxLog;
import lnyswz.hk.dao.HkmxLogDAO;
import lnyswz.hk.utils.AbstractPagerManager;

public class HkmxLogDAOImpl extends AbstractPagerManager implements HkmxLogDAO {

	@Override
	public List<HkmxLog> findHkmxLogs(int sxkhId) {
		return this.getHibernateTemplate().find("from HkmxLog h where h.sxkhId = ?", sxkhId);
	}

}
