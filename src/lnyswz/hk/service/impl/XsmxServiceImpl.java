package lnyswz.hk.service.impl;

import java.math.BigDecimal;
import java.util.Date;
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
		
		//String currentDate = DateUtil.getCurrentDateString();
		Date currentDate = DateUtil.getCurrentDateTime();
		for(Xsmx xsmx : lists){
			String hksjStr = DateUtil.dateIncreaseByDay(xsmx.getId().getKpsj(), DateUtil.ISO_EXPANDED_DATE_FORMAT, sxkh.getDays());
			String hksjStr1 = DateUtil.dateIncreaseByDay(hksjStr, DateUtil.ISO_EXPANDED_DATE_FORMAT, 30);
			String hksjStr2 = DateUtil.dateIncreaseByDay(hksjStr1, DateUtil.ISO_EXPANDED_DATE_FORMAT, 30);
			String hksjStr3 = DateUtil.dateIncreaseByDay(hksjStr2, DateUtil.ISO_EXPANDED_DATE_FORMAT, 30);
			String hksjStr4 = DateUtil.dateIncreaseByDay(hksjStr3, DateUtil.ISO_EXPANDED_DATE_FORMAT, 30);
			
			Date hksj = DateUtil.stringToDate(hksjStr);
			System.out.println("hksj = " + hksj);
			Date hksj1 = DateUtil.stringToDate(hksjStr1);
			System.out.println("hksj1 = " + hksj1);
			Date hksj2 = DateUtil.stringToDate(hksjStr2);
			System.out.println("hksj2 = " + hksj2);
			Date hksj3 = DateUtil.stringToDate(hksjStr3);
			System.out.println("hksj3 = " + hksj3);
			Date hksj4 = DateUtil.stringToDate(hksjStr4);
			System.out.println("hksj4 = " + hksj4);
			
			if(DateUtil.daysBetween(currentDate, hksj) >= 0){
				System.out.println("In = " + xsmx.getId().getXsje());
				totalIn = totalIn.add(xsmx.getId().getXsje());
			}else if(DateUtil.daysBetween(currentDate, hksj1) >= 0){
				System.out.println("Out1 = " + xsmx.getId().getXsje());
				totalOut1 = totalOut1.add(xsmx.getId().getXsje());
			}else if(DateUtil.daysBetween(currentDate, hksj2) >= 0){
				System.out.println("Out2 = " + xsmx.getId().getXsje());
				totalOut2 = totalOut2.add(xsmx.getId().getXsje());
			}else if(DateUtil.daysBetween(currentDate, hksj3) >= 0){
				System.out.println("Out3 = " + xsmx.getId().getXsje());
				totalOut3 = totalOut3.add(xsmx.getId().getXsje());
			}else if(DateUtil.daysBetween(currentDate, hksj4) >= 0){
				System.out.println("Out4 = " + xsmx.getId().getXsje());
				totalOut4 = totalOut4.add(xsmx.getId().getXsje());
			}else{
				System.out.println("Out5 = " + xsmx.getId().getXsje());
				totalOut5 = totalOut5.add(xsmx.getId().getXsje());
				System.out.println("totalOut5 = " + totalOut5);
			}
		}
		
		totalOut5 = totalOut5.add(new BigDecimal(sxkh.getBalance()));
		
		System.out.println("totalIn = " + totalIn.toString());
		System.out.println("totalOut1 = " + totalOut1);
		System.out.println("totalOut2 = " + totalOut2);
		System.out.println("totalOut3 = " + totalOut3);
		System.out.println("totalOut4 = " + totalOut4);
		System.out.println("totalOut5 = " + totalOut5);
		totalAll = totalAll.add(totalIn);
		totalAll = totalAll.add(totalOut1);
		totalAll = totalAll.add(totalOut2);
		totalAll = totalAll.add(totalOut3);
		totalAll = totalAll.add(totalOut4);
		totalAll = totalAll.add(totalOut5);
				
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
