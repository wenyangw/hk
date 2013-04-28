package lnyswz.hk.service;

import java.util.List;

import lnyswz.hk.bean.Lsck;

public interface LsckService {
	public List<Lsck> findLscks(String bmbh, String date);
}
