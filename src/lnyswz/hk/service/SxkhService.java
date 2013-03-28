package lnyswz.hk.service;

import java.util.List;

import lnyswz.hk.bean.Sxkh;
import lnyswz.hk.utils.PagerModel;

public interface SxkhService {
	public void modify(Sxkh sxkh);
	public void delete(int id);
	public PagerModel findSxkhs(String org);
	public List<Sxkh> getSxkhs(String org);
	public Sxkh getSxkh(int id);
	
}
