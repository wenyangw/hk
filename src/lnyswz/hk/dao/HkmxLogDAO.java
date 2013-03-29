package lnyswz.hk.dao;

import java.util.List;

import lnyswz.hk.bean.HkmxLog;

public interface HkmxLogDAO {
	public List<HkmxLog> findHkmxLogs(int sxkhId);
}
