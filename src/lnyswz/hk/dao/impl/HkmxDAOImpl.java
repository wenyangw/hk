package lnyswz.hk.dao.impl;

import java.util.List;

import lnyswz.hk.bean.Hkmx;
import lnyswz.hk.dao.HkmxDAO;
import lnyswz.hk.utils.AbstractPagerManager;

public class HkmxDAOImpl extends AbstractPagerManager implements HkmxDAO {

	@Override
	public String getLastLsh(int sxkhId, String khbh) {
		
		return null;
	}
	
	@Override
	public List<Hkmx> findUncompletedHkmxs() {
		return this.getHibernateTemplate().find("from Hkmx h where h.completed = '0'");
	}

}
