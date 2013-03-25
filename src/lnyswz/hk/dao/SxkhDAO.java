package lnyswz.hk.dao;

import java.util.List;

import lnyswz.hk.bean.Sxkh;
import lnyswz.hk.utils.PagerModel;

public interface SxkhDAO {
	public void add(Sxkh sxkh);
	public void delete(int id);
	public void modify(Sxkh sxkh);
	public Sxkh getSxkh(int id);
	public List<Sxkh> getSxkhs(String org);
	public PagerModel findSxkhByOrg(String org);
}
