package lnyswz.hk.service;

import java.util.List;

import lnyswz.hk.bean.Lsck;

public interface LsckService {
	public List<String> findThds();
	public List<String> findBzs();
	public Lsck getLsck(String thdlsh);
}
