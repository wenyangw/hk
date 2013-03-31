package lnyswz.hk.dao.impl;

import java.util.List;

import lnyswz.hk.bean.HkmxLog;
import lnyswz.hk.dao.HkmxLogDAO;
import lnyswz.hk.utils.AbstractPagerManager;

public class HkmxLogDAOImpl extends AbstractPagerManager implements HkmxLogDAO {
	@Override
	public void addLog(HkmxLog log) {
		this.getHibernateTemplate().save(log);
	}
	@Override
	public void delete(HkmxLog hkmxLog) {
		this.getHibernateTemplate().delete(hkmxLog);
	}
	
	@Override
	public HkmxLog getHkmxLog(int id) {
		return this.getHibernateTemplate().get(HkmxLog.class, id);
	}
	
	@Override
	public List<HkmxLog> findHkmxLogs(int sxkhId) {
		return this.getHibernateTemplate().find("from HkmxLog h where h.sxkhId = ? order by id desc", sxkhId);
	}

}
