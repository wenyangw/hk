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
		//创建返回的对象
		SxkhTotal total = new SxkhTotal();
		String bmbh = sxkh.getBmbh();
		String khbh = sxkh.getKhbh();
		//得到最后一笔还款的销售流水号
		String xsfplsh = hkmxDAO.getLastHkLsh(bmbh, khbh);
		
		//取得未还款的销售明细
		List<Xsmx> lists = xsmxDAO.findXsmxsList(bmbh, khbh, xsfplsh);
		
		//取得最后一笔未还款的记录
		List<Hkmx> hkmxs = hkmxDAO.getLastHkmx(bmbh, khbh);
		//计算最后一笔已还款金额
		BigDecimal hked = new BigDecimal(0);
		for(Hkmx hkmx : hkmxs){
			hked = hked.add(hkmx.getHkje());
		}
		
		//建立不同超期时段的汇总变量
		BigDecimal totalAll = new BigDecimal(0);
		BigDecimal totalIn = new BigDecimal(0);
		BigDecimal totalOut1 = new BigDecimal(0);
		BigDecimal totalOut2 = new BigDecimal(0);
		BigDecimal totalOut3 = new BigDecimal(0);
		BigDecimal totalOut4 = new BigDecimal(0);
		BigDecimal totalOut5 = new BigDecimal(0);
		
		//当前日期
		Date currentDate = DateUtil.getCurrentDateTime();
		for(Xsmx xsmx : lists){
			//根据开票时间，得到不同时段的时候值
			String hksjStr = DateUtil.dateIncreaseByDay(xsmx.getId().getKpsj(), DateUtil.ISO_EXPANDED_DATE_FORMAT, sxkh.getDays());
			String hksjStr1 = DateUtil.dateIncreaseByDay(hksjStr, DateUtil.ISO_EXPANDED_DATE_FORMAT, 30);
			String hksjStr2 = DateUtil.dateIncreaseByDay(hksjStr1, DateUtil.ISO_EXPANDED_DATE_FORMAT, 30);
			String hksjStr3 = DateUtil.dateIncreaseByDay(hksjStr2, DateUtil.ISO_EXPANDED_DATE_FORMAT, 30);
			String hksjStr4 = DateUtil.dateIncreaseByDay(hksjStr3, DateUtil.ISO_EXPANDED_DATE_FORMAT, 30);
			
			Date hksj = DateUtil.stringToDate(hksjStr);
			Date hksj1 = DateUtil.stringToDate(hksjStr1);
			Date hksj2 = DateUtil.stringToDate(hksjStr2);
			Date hksj3 = DateUtil.stringToDate(hksjStr3);
			Date hksj4 = DateUtil.stringToDate(hksjStr4);
			
			//本条销售金额
			BigDecimal xsje = xsmx.getId().getXsje();
			//如果是最后一笔已还款，则减掉已还金额
			if(xsfplsh.equals(xsmx.getId().getXsfplsh())){
				xsje = xsje.subtract(hked);
			}
			
			//根据还款时候，计算超期范围
			if(DateUtil.daysBetween(currentDate, hksj) >= 0){
				totalIn = totalIn.add(xsje);
			}else if(DateUtil.daysBetween(currentDate, hksj1) >= 0){
				totalOut1 = totalOut1.add(xsje);
			}else if(DateUtil.daysBetween(currentDate, hksj2) >= 0){
				totalOut2 = totalOut2.add(xsje);
			}else if(DateUtil.daysBetween(currentDate, hksj3) >= 0){
				totalOut3 = totalOut3.add(xsje);
			}else if(DateUtil.daysBetween(currentDate, hksj4) >= 0){
				totalOut4 = totalOut4.add(xsje);
			}else{
				totalOut5 = totalOut5.add(xsje);
			}
		}
		
		//累加历史陈欠金额
		totalOut5 = totalOut5.add(new BigDecimal(sxkh.getBalance()));
		
		//计算总欠款金额
		totalAll = totalAll.add(totalIn);
		totalAll = totalAll.add(totalOut1);
		totalAll = totalAll.add(totalOut2);
		totalAll = totalAll.add(totalOut3);
		totalAll = totalAll.add(totalOut4);
		totalAll = totalAll.add(totalOut5);
		
		//返回值		
		total.setKhbh(khbh);
		total.setTotal(totalAll);
		total.setTotalIn(totalIn);
		total.setTotalOut1(totalOut1);
		total.setTotalOut2(totalOut2);
		total.setTotalOut3(totalOut3);
		total.setTotalOut4(totalOut4);
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
