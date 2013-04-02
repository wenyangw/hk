package lnyswz.hk.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lnyswz.hk.bean.Hkmx;
import lnyswz.hk.bean.Sxkh;
import lnyswz.hk.bean.SxkhTotal;
import lnyswz.hk.bean.Xsmx;
import lnyswz.hk.bean.XsmxS;
import lnyswz.hk.dao.HkmxDAO;
import lnyswz.hk.dao.SxkhDAO;
import lnyswz.hk.dao.XsmxDAO;
import lnyswz.hk.service.XsmxService;
import lnyswz.hk.utils.DateUtil;
import lnyswz.hk.utils.PagerModel;

public class XsmxServiceImpl implements XsmxService {
	private XsmxDAO xsmxDAO;
	private HkmxDAO hkmxDAO;
	private SxkhDAO sxkhDAO;
	
	@Override
	public PagerModel findXsmxs(String bmbh, String khbh, String ywybh, String lastLsh) {
		//String xsfplsh = hkmxDAO.getLastHkLsh(bmbh, khbh, ywybh);
		return xsmxDAO.findXsmxs(bmbh, khbh, lastLsh, ywybh);
	}
	
	@Override
	public List<SxkhTotal> getTotals(String bmbh, String yearMonth) {
		System.out.println("Bmbh = " + bmbh);
		List<Sxkh> sxkhs = sxkhDAO.getSxkhs(bmbh);
		System.out.println("sxkhs = " + sxkhs.size());
		List<SxkhTotal> totals = new ArrayList<SxkhTotal>();
		for(Sxkh sxkh : sxkhs){
			SxkhTotal total = getTotal(sxkh, yearMonth);
			if(total != null){
				totals.add(total);
			}
		}
		
		return totals;
	}
	
	@Override
	public SxkhTotal getTotal(Sxkh sxkh, String yearMonth) {
		//创建返回的对象
		SxkhTotal total = new SxkhTotal();
		String bmbh = sxkh.getBmbh();
		String khbh = sxkh.getKhbh();
		String khmc = sxkh.getKhmc();
		String ywybh = sxkh.getYwybh();
		String ywymc = sxkh.getYwymc();
		String lastLsh = sxkh.getLastLsh();
		//原处理方式，单独取一次流水号
//		if(lastLsh == null){
//			lastLsh = hkmxDAO.getLastHkLsh(bmbh, khbh, ywybh);
//		}
		
		//建立不同超期时段的汇总变量
		BigDecimal totalAll = new BigDecimal(0);
		BigDecimal totalIn = new BigDecimal(0);
		BigDecimal totalOut1 = new BigDecimal(0);
		BigDecimal totalOut2 = new BigDecimal(0);
		BigDecimal totalOut3 = new BigDecimal(0);
		BigDecimal totalOut4 = new BigDecimal(0);
		
		//得到最后一笔还款的销售流水号
		//String xsfplsh = hkmxDAO.getLastHkLsh(bmbh, khbh, ywybh);
		
				
		//按新方式
		List<Hkmx> hkmxs = hkmxDAO.getLastHkmx(bmbh, khbh, ywybh);
		BigDecimal hked = new BigDecimal(0);
		if(hkmxs.size() != 0){
			if(lastLsh == null){
				lastLsh = hkmxs.get(0).getXsfplsh();
			}
			
			
				//计算最后一笔已还款金额
				
				for(Hkmx hkmx : hkmxs){
					hked = hked.add(hkmx.getHkje());
				}
		}else{
			lastLsh = sxkh.getLsh();
		}
		
		//原方式，按前面取得的流水号，再次取得还款记录
		//List<Hkmx> hkmxs = hkmxDAO.getLastHkmxByLsh(lastLsh);
		
		
			//得到最后一笔还款的销售流水号
			//String xsfplsh = hkmxs.get(0).getXsfplsh();
		
			//取得未还款的销售明细
			List<Xsmx> lists = xsmxDAO.findXsmxsList(bmbh, khbh, lastLsh, ywybh, yearMonth);

			//当前日期
			Date currentDate = DateUtil.getCurrentDateTime();
			for(Xsmx xsmx : lists){
				//根据开票时间，得到不同时段的时候值
				String hksjStr = DateUtil.dateIncreaseByDay(xsmx.getId().getKpsj(), DateUtil.ISO_EXPANDED_DATE_FORMAT, 
					sxkh.getDays());
				String hksjStr1 = DateUtil.dateIncreaseByDay(hksjStr, DateUtil.ISO_EXPANDED_DATE_FORMAT, 30);
				String hksjStr2 = DateUtil.dateIncreaseByDay(hksjStr1, DateUtil.ISO_EXPANDED_DATE_FORMAT, 60);
				String hksjStr3 = DateUtil.dateIncreaseByDay(hksjStr2, DateUtil.ISO_EXPANDED_DATE_FORMAT, 90);
			
				Date hksj = DateUtil.stringToDate(hksjStr);
				Date hksj1 = DateUtil.stringToDate(hksjStr1);
				Date hksj2 = DateUtil.stringToDate(hksjStr2);
				Date hksj3 = DateUtil.stringToDate(hksjStr3);
			
				//本条销售金额
				BigDecimal xsje = xsmx.getId().getXsje();
				//如果是最后一笔已还款，则减掉已还金额
				if(lastLsh.equals(xsmx.getId().getXsfplsh())){
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
				}else{
					totalOut4 = totalOut4.add(xsje);
				}
			}
		
			//累加历史陈欠金额
			totalOut4 = totalOut4.add(new BigDecimal(sxkh.getBalance()));
			
			//计算总欠款金额
			totalAll = totalAll.add(totalIn);
			totalAll = totalAll.add(totalOut1);
			totalAll = totalAll.add(totalOut2);
			totalAll = totalAll.add(totalOut3);
			totalAll = totalAll.add(totalOut4);
		
		//返回值	
		total.setYwybh(ywybh);
		total.setYwymc(ywymc);
		total.setKhbh(khbh);
		total.setKhmc(khmc);
		total.setTotal(totalAll);
		total.setTotalIn(totalIn);
		total.setTotalOut1(totalOut1);
		total.setTotalOut2(totalOut2);
		total.setTotalOut3(totalOut3);
		total.setTotalOut4(totalOut4);
		
		return total;
	}
	
	public void setXsmxDAO(XsmxDAO xsmxDAO) {
		this.xsmxDAO = xsmxDAO;
	}

	public void setHkmxDAO(HkmxDAO hkmxDAO) {
		this.hkmxDAO = hkmxDAO;
	}

	public void setSxkhDAO(SxkhDAO sxkhDAO) {
		this.sxkhDAO = sxkhDAO;
	}
	
	
}
