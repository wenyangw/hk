package lnyswz.hk.service.impl;

import java.math.BigDecimal;
import java.util.List;

import lnyswz.hk.bean.Hkmx;
import lnyswz.hk.bean.Sxkh;
import lnyswz.hk.bean.SxkhTotal;
import lnyswz.hk.bean.Xsmx;
import lnyswz.hk.dao.HkmxDAO;
import lnyswz.hk.dao.XsmxDAO;
import lnyswz.hk.service.XsmxService;
import lnyswz.hk.utils.DateUtil;
import lnyswz.hk.utils.PagerModel;

public class XsmxServiceImpl implements XsmxService {
	private XsmxDAO xsmxDAO;
	private HkmxDAO hkmxDAO;
	
	@Override
	public PagerModel findXsmxs(String bmbh, String khbh) {
		String xsfplsh = hkmxDAO.getLastHkLsh(bmbh, khbh);
		return xsmxDAO.findXsmxs(bmbh, khbh, xsfplsh);
	}
	
	@Override
	public SxkhTotal total(Sxkh sxkh) {
		SxkhTotal total = new SxkhTotal();
		String bmbh = sxkh.getBmbh();
		String khbh = sxkh.getKhbh();
		String xsfplsh = hkmxDAO.getLastHkLsh(bmbh, khbh);
		
		List<Xsmx> lists = xsmxDAO.findXsmxsList(bmbh, khbh, xsfplsh);
		
		List<Hkmx> hkmxs = hkmxDAO.getLastHkmx(bmbh, khbh);
		BigDecimal totalAll = new BigDecimal(0);
		BigDecimal totalIn = new BigDecimal(0);
		BigDecimal totalOut1 = new BigDecimal(0);
		BigDecimal totalOut2 = new BigDecimal(0);
		BigDecimal totalOut3 = new BigDecimal(0);
		BigDecimal totalOut4 = new BigDecimal(0);
		BigDecimal totalOut5 = new BigDecimal(0);
		
		String currentDate = DateUtil.getCurrentDateString();
		
		for(Xsmx xsmx : lists){
			String hksj = DateUtil.dateIncreaseByDay(xsmx.getId().getKpsj(), DateUtil.ISO_EXPANDED_DATE_FORMAT, sxkh.getDays());
			String hksj1 = DateUtil.dateIncreaseByDay(hksj, DateUtil.ISO_EXPANDED_DATE_FORMAT, 30);
			String hksj2 = DateUtil.dateIncreaseByDay(hksj1, DateUtil.ISO_EXPANDED_DATE_FORMAT, 30);
			String hksj3 = DateUtil.dateIncreaseByDay(hksj2, DateUtil.ISO_EXPANDED_DATE_FORMAT, 30);
			String hksj4 = DateUtil.dateIncreaseByDay(hksj, DateUtil.ISO_EXPANDED_DATE_FORMAT, 30);
			
			if(DateUtil.daysBetween(currentDate, hksj) > 0){
				totalIn.add(xsmx.getId().getXsje());
			}else if(DateUtil.daysBetween(currentDate, hksj1) > 0){
				totalOut1.add(xsmx.getId().getXsje());
			}else if(DateUtil.daysBetween(currentDate, hksj2) > 0){
				totalOut2.add(xsmx.getId().getXsje());
			}else if(DateUtil.daysBetween(currentDate, hksj3) > 0){
				totalOut3.add(xsmx.getId().getXsje());
			}else if(DateUtil.daysBetween(currentDate, hksj4) > 0){
				totalOut4.add(xsmx.getId().getXsje());
			}else{
				totalOut5.add(xsmx.getId().getXsje());
			}
		}
		
		totalOut5.add(new BigDecimal(sxkh.getBalance()));
		
		totalAll.add(totalIn);
		totalAll.add(totalOut1);
		totalAll.add(totalOut2);
		totalAll.add(totalOut3);
		totalAll.add(totalOut4);
		totalAll.add(totalOut5);
				
		total.setKhbh(khbh);
		total.setTotal(totalAll);
		total.setTotalOut1(totalOut1);
		total.setTotalOut2(totalOut2);
		total.setTotalOut3(totalOut3);
		total.setTotalOut4(totalOut5);
		total.setTotalOut5(totalOut5);
		
		return total;
	}
	
	public void setXsmxDAO(XsmxDAO xsmxDAO) {
		this.xsmxDAO = xsmxDAO;
	}

	public void setHkmxDAO(HkmxDAO hkmxDAO) {
		this.hkmxDAO = hkmxDAO;
	}
	
}
