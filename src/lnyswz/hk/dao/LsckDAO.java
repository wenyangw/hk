package lnyswz.hk.dao;

import java.util.List;

import lnyswz.hk.bean.Thd;

public interface LsckDAO {
	
	public List<String> findThds(String date);
	public List<String> findBzs(String date);
	public List<Thd> getLscks(String thdlsh, String date);
}
