package lnyswz.hk.service;

import java.util.List;

import lnyswz.hk.bean.HkmxLog;

public interface HkmxLogService {
	public void addLog(HkmxLog hkmxLog);
	public void delete(HkmxLog hkmxLog);
	public HkmxLog getHkmxLog(int id);
	public List<HkmxLog> findHkmxLogs(int sxkhId);
}
