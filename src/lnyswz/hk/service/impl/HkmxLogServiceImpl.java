package lnyswz.hk.service.impl;

import java.util.List;

import lnyswz.hk.bean.HkmxLog;
import lnyswz.hk.dao.HkmxLogDAO;
import lnyswz.hk.service.HkmxLogService;

public class HkmxLogServiceImpl implements HkmxLogService {
	private HkmxLogDAO hkmxLogDAO;
	@Override
	public List<HkmxLog> findHkmxLogs(int sxkhId) {
		return hkmxLogDAO.findHkmxLogs(sxkhId);
	}
	public void setHkmxLogDAO(HkmxLogDAO hkmxLogDAO) {
		this.hkmxLogDAO = hkmxLogDAO;
	}
	
}
