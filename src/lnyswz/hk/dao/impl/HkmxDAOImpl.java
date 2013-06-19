package lnyswz.hk.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;

import lnyswz.hk.bean.Hkmx;
import lnyswz.hk.bean.HkmxLog;
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
	public void delete(Hkmx hkmx) {
		this.getHibernateTemplate().delete(hkmx);
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
	//public List<Hkmx> getLastHkmx(String bmbh, String khbh, String ywybh) {
		//return this.getHibernateTemplate().find("from Hkmx h where h.xsfplsh = ?", getLastHkLsh(bmbh, khbh, ywybh));
	//}
	
	public List<Hkmx> getLastHkmx(String bmbh, String khbh, String ywybh, String date) {
		//return this.getHibernateTemplate().find("from Hkmx h where h.hkje <> 0 and h.completed = '0' and h.xsfplsh in (select x.id.xsfplsh from Xsmx x where x.id.bmbh = ? and x.id.khbh = ? and x.id.ywybh = ?)", new String[]{bmbh, khbh, ywybh});
		return this.getHibernateTemplate().find("from Hkmx h where h.hkje <> 0 and h.xsfplsh in (select x.id.xsfplsh from Xsmx x where x.id.bmbh = ? and x.id.khbh = ? and x.id.ywybh = ?) and hksj < ? and h.xsfplsh = (select max(h.xsfplsh) from Hkmx h" + 
				 " where h.hkje <> 0 and h.xsfplsh in (select x.id.xsfplsh from Xsmx x where x.id.bmbh = ? and x.id.khbh = ? and x.id.ywybh = ?) and hksj < ?)", new String[]{bmbh, khbh, ywybh, date, bmbh, khbh, ywybh, date});
	}
	
	
	@Override
	public List<Hkmx> getLastHkmxByLsh(String lastLsh) {
		return this.getHibernateTemplate().find("from Hkmx h where h.xsfplsh = ?", lastLsh);
	}
	
	@Override
	public List<Hkmx> findUncompletedHkmxs(String lsh) {
		return this.getHibernateTemplate().find("from Hkmx h where h.completed = '0' and h.xsfplsh = ?", lsh);
	}
	
	@Override
	public List<Hkmx> findHkmxeds(String logNo){
		return this.getHibernateTemplate().find("from Hkmx h where h.logNo = ?", logNo);
	}
	
	@Override
	public List<Hkmx> findHkmxs(int sxkhId, String yearMonth) {
		//List<String> logNos = this.getHibernateTemplate().find("select logNo from HkmxLog l where l.sxkhId = ? and l.hksj like ?", new Object[]{sxkhId, yearMonth + "%"});
		//if(logNos.size() > 0){
			//return this.getHibernateTemplate().find("from Hkmx h where h.logNo in elements(?)", logNos.);
		//}
		//return null;
		return this.getHibernateTemplate().find("select h from Hkmx h,HkmxLog l where l.sxkhId = ? and h.logNo = l.logNo and l.hksj like ?",new Object[]{sxkhId, yearMonth + "%"});
}
	
}
