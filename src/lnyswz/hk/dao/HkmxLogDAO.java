package lnyswz.hk.dao;

import java.util.List;

import lnyswz.hk.bean.HkmxLog;

public interface HkmxLogDAO {
	public void addLog(HkmxLog log);
	public void delete(HkmxLog hkmxLog);
	public HkmxLog getHkmxLog(int id);
	public List<HkmxLog> findHkmxLogs(int sxkhId);
}
