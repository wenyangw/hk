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
			.createSQLQuery("select distinct thdlsh from v_hk_thd where thsj < ?")
			//��ͼ�д��������ڲ�ѯ���޺󲹿���Ʊ����ʱ����Ҫ��ʾ����
			//.createSQLQuery("select distinct thdlsh from fun_hk_thd(?) where thsj < ?")	
			.addScalar("thdlsh", Hibernate.STRING)
			.setString(0, date)
			.setString(1, date)
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
		return this.getHibernateTemplate().find("from Thd t where t.id.thdlsh = ? and t.id.thsj < ? order by t.id.kh, t.id.thdlsh", new String[]{thdlsh, date});
	}
	
}
