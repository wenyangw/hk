package lnyswz.hk.service;

import lnyswz.hk.bean.Sxkh;
import lnyswz.hk.utils.PagerModel;

public interface SxkhService {
	public PagerModel findSxkhs(String org);
	public Sxkh getSxkh(int id);
}
