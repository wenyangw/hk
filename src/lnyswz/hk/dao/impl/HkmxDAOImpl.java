package lnyswz.hk.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;

import lnyswz.hk.bean.Hkmx;
import lnyswz.hk.dao.HkmxDAO;
import lnyswz.hk.utils.AbstractPagerManager;

public class HkmxDAOImpl extends AbstractPagerManager implements HkmxDAO {
	
	@Override
	public void save(Hkmx hkmx) {
		this.getHibernateTemplate().save(hkmx);
	}
	
	@Override
	public void update(Hkmx hkmx) {
		this.getHibernateTemplate().update(hkmx);
	}
	
	@Override
	public String getLastHkLsh(String bmbh, String khbh, String ywybh) {
		return (String)this.getSession()
			.createSQLQuery("select distinct xsfplsh from th_spxs x where xsfplsh in (select xsfplsh from t_hkmx  h where hkje <> 0 and completed = '0') and bmbh = ? and khbh = ? and ywybh = ?")
			.addScalar("xsfplsh", Hibernate.STRING)
			.setString(0, bmbh)
			.setString(1, khbh)
			.setString(2, ywybh)
			.uniqueResult();
	}
	
	@Override
	public List<Hkmx> getLastHkmx(String bmbh, String khbh, String ywybh) {
		return this.getHibernateTemplate().find("from Hkmx h where h.xsfplsh = ?", getLastHkLsh(bmbh, khbh, ywybh));
	}
	
	@Override
	public List<Hkmx> findUncompletedHkmxs() {
		return this.getHibernateTemplate().find("from Hkmx h where h.completed = '0'");
	}

}
