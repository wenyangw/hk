package lnyswz.hk.service;

import java.util.List;

import lnyswz.hk.bean.Thd;

public interface LsckService {
	public List<String> findThds(String date);
	public List<String> findBzs(String date);
	public List<Thd> getLscks(String thdlsh, String date);
}
