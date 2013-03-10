package lnyswz.hk.dao;

import lnyswz.hk.bean.Sxkh;
import lnyswz.hk.utils.PagerModel;

public interface SxkhDAO {
	public void add(Sxkh sxkh);
	public void delete(int id);
	public void update(Sxkh sxkh);
	public Sxkh getSxkh(int id);
	public PagerModel findSxkhByOrg(String org);
}
