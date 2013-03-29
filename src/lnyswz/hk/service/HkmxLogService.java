package lnyswz.hk.service;

import java.util.List;

import lnyswz.hk.bean.HkmxLog;

public interface HkmxLogService {
	public List<HkmxLog> findHkmxLogs(int sxkhId);
}
