package lnyswz.hk.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;

import lnyswz.hk.bean.Lsck;
import lnyswz.hk.dao.LsckDAO;
import lnyswz.hk.utils.AbstractPagerManager;

public class LsckDAOImpl extends AbstractPagerManager implements LsckDAO {
	
	@Override
	public List<String> findThds(){
		return this.getSession()
			.createSQLQuery("select thdlsh from v_hk_thd")
			.addScalar("thdlsh", Hibernate.STRING)
			.list();
	}
	
	@Override
	public List<String> findBzs(){
		return this.getSession()
				.createSQLQuery("select bz from v_hk_bz")
				.addScalar("bz", Hibernate.STRING)
				.list();
	}
	
	@Override
	public Lsck getLsck(String thdlsh){
		return null;
	}
	
}
