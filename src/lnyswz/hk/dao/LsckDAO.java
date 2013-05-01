package lnyswz.hk.dao;

import java.util.List;

import lnyswz.hk.bean.Lsck;

public interface LsckDAO {
	
	public List<String> findThds();
	public List<String> findBzs();
	public Lsck getLsck(String thdlsh);
}
