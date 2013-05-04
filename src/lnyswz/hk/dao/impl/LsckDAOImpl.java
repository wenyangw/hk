package lnyswz.hk.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;

import lnyswz.hk.bean.Thd;
import lnyswz.hk.dao.LsckDAO;
import lnyswz.hk.utils.AbstractPagerManager;

public class LsckDAOImpl extends AbstractPagerManager implements LsckDAO {
	
	@Override
	public List<String> findThds(String date){
		return this.getSession()
			.createSQLQuery("select thdlsh from v_hk_thd where thsj < ?")
			.addScalar("thdlsh", Hibernate.STRING)
			.setString(0, date)
			.list();
	}
	
	@Override
	public List<String> findBzs(String date){
		return this.getSession()
				.createSQLQuery("select bz from v_hk_bz where kpsj < ?")
				.addScalar("bz", Hibernate.STRING)
				.setString(0, date)
				.list();
	}
	
	@Override
	public List<Thd> getLscks(String thdlsh, String date){
//		return this.getSession()
//				.createSQLQuery("select l.* from v_hk_thd_all l where thdlsh = ? order by thdlsh")
//				.addEntity("l", Lsck.class)
//				.setString(0, thdlsh)
//				.list();
		return this.getHibernateTemplate().find("from Thd t where t.id.thdlsh = ? and t.id.thsj < ? order by t.id.kh, t.id.thdlsh", new String[]{thdlsh, date});
	}
	
}
