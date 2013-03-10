package lnyswz.hk.dao.impl;

import lnyswz.hk.bean.Sxkh;
import lnyswz.hk.dao.SxkhDAO;
import lnyswz.hk.utils.AbstractPagerManager;
import lnyswz.hk.utils.PagerModel;

public class SxkhDAOImpl extends AbstractPagerManager implements SxkhDAO {

	@Override
	public void add(Sxkh sxkh) {
		this.getHibernateTemplate().save(sxkh);

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(this.getHibernateTemplate().get(Sxkh.class, id));
	}

	@Override
	public void update(Sxkh sxkh) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(sxkh);
	}
	
	@Override
	public Sxkh getSxkh(int id){
		return this.getHibernateTemplate().get(Sxkh.class, id);
	}
	
	@Override
	public PagerModel findSxkhByOrg(String org) {
		return this.searchPaginated("from Sxkh s where s.bmbh = ?", org);
	}

}
