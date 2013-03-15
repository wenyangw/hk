package lnyswz.hk.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;

import lnyswz.hk.bean.Hkmx;
import lnyswz.hk.dao.HkmxDAO;
import lnyswz.hk.utils.AbstractPagerManager;

public class HkmxDAOImpl extends AbstractPagerManager implements HkmxDAO {

	@Override
	public String getLastHkLsh(String bmbh, String khbh) {
		return (String)this.getSession()
			.createSQLQuery("select distinct xsfplsh from th_spxs x where xsfplsh in (select xsfplsh from t_hkmx  h where hkje <> 0 and completed = '0') and bmbh = ? and khbh = ?")
			.addScalar("xsfplsh", Hibernate.STRING)
			.setString(0, bmbh)
			.setString(1, khbh)
			.uniqueResult();
	}
	
	@Override
	public List<Hkmx> findUncompletedHkmxs() {
		return this.getHibernateTemplate().find("from Hkmx h where h.completed = '0'");
	}

}
