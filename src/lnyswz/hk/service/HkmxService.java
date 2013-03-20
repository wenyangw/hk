package lnyswz.hk.service;

import java.util.List;

import lnyswz.hk.bean.Hkmx;

public interface HkmxService {
	public List<Hkmx> getLastHkmx(String bmbh, String khbh, String ywybh);
}
