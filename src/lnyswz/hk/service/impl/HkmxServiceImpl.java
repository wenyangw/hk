package lnyswz.hk.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lnyswz.hk.bean.Hkmx;
import lnyswz.hk.bean.HkmxLog;
import lnyswz.hk.bean.HkmxTotal;
import lnyswz.hk.bean.Sxkh;
import lnyswz.hk.bean.SxkhTotal;
import lnyswz.hk.bean.Xsmx;
import lnyswz.hk.bean.XsmxS;
import lnyswz.hk.dao.HkmxDAO;
import lnyswz.hk.dao.SxkhDAO;
import lnyswz.hk.dao.XsmxDAO;
import lnyswz.hk.service.HkmxService;
import lnyswz.hk.utils.DateUtil;

public class HkmxServiceImpl implements HkmxService {
	HkmxDAO hkmxDAO;
	SxkhDAO sxkhDAO;
	XsmxDAO xsmxDAO;
	
	@Override
	public void add(Hkmx hkmx) {
		hkmxDAO.save(hkmx);
	}
	
	@Override
	public void delete(Hkmx hkmx) {
		hkmxDAO.delete(hkmx);
	}
	@Override
	public void modify(Hkmx hkmx) {
		hkmxDAO.update(hkmx);
	}
	
	@Override
	public String getLastLsh(String bmbh, String khbh, String ywybh) {
		return hkmxDAO.getLastHkLsh(bmbh, khbh, ywybh);
	}
	
	@Override
	public List<Hkmx> getLastHkmx(String bmbh, String khbh, String ywybh) {
		return hkmxDAO.getLastHkmx(bmbh, khbh, ywybh);
	}
	
	@Override
	public List<Hkmx> getLastHkmxByLsh(String lastLsh) {
		return hkmxDAO.getLastHkmxByLsh(lastLsh);
	}
	
	@Override
	public List<Hkmx> findUncompletedHkmxs(String lsh) {
		
		return hkmxDAO.findUncompletedHkmxs(lsh);
	}
	
	@Override
	public List<HkmxTotal> getTotals(String bmbh, String yearMonth) {
		List<Sxkh> sxkhs = sxkhDAO.getSxkhs(bmbh);
		List<HkmxTotal> totals = new ArrayList<HkmxTotal>();
		for(Sxkh sxkh : sxkhs){
			HkmxTotal total = getTotal(sxkh, yearMonth);
			if(total != null){
				totals.add(total);
			}
		}
		
		return totals;
	}
	
	public HkmxTotal getTotal(Sxkh sxkh, String yearMonth) {
		//创建返回的对象
		HkmxTotal total = new HkmxTotal();
		//String bmbh = sxkh.getBmbh();
		String khbh = sxkh.getKhbh();
		String khmc = sxkh.getKhmc();
		String ywybh = sxkh.getYwybh();
		String ywymc = sxkh.getYwymc();
		//String lastLsh = sxkh.getLastLsh();
		//if(lastLsh == null){
			//lastLsh = hkmxDAO.getLastHkLsh(bmbh, khbh, ywybh);
		//}
		
		//建立不同超期时段的汇总变量
		BigDecimal totalAll = new BigDecimal(0);
		BigDecimal total1 = new BigDecimal(0);
		BigDecimal total2 = new BigDecimal(0);
		BigDecimal total3 = new BigDecimal(0);
		
		//得到最后一笔还款的销售流水号
		//String xsfplsh = hkmxDAO.getLastHkLsh(bmbh, khbh, ywybh);
		
				
		//取得最后一笔未还款的记录
		//List<Hkmx> hkmxs = hkmxDAO.getLastHkmx(bmbh, khbh, ywybh);
		//List<Hkmx> hkmxs = hkmxDAO.getLastHkmxByLsh(lastLsh);
		
		
		List<Hkmx> hkmxs = hkmxDAO.findHkmxs(sxkh.getId(), yearMonth);
		
		if(hkmxs != null && hkmxs.size() != 0){
		
			for(Hkmx hkmx : hkmxs){
				System.out.println("xsfplsh = " + hkmx.getXsfplsh());
				String xsfplsh = hkmx.getXsfplsh();
				int days = sxkh.getDays();
				Xsmx xsmx = xsmxDAO.getXsmx(xsfplsh);
				XsmxS xsmxS = new XsmxS(xsmx, days);
				BigDecimal hkje = hkmx.getHkje();
				String hksj = hkmx.getHksj();
				String hksjP = xsmxS.getHksj();
				String hksjB = DateUtil.dateIncreaseByDay(hksjP, DateUtil.ISO_EXPANDED_DATE_FORMAT, -30);
				String hksjA = DateUtil.dateIncreaseByDay(hksjP, DateUtil.ISO_EXPANDED_DATE_FORMAT, 30);
				
				Date hksjD = DateUtil.stringToDate(hksj);
				Date hksjBD = DateUtil.stringToDate(hksjB);
				Date hksjAD = DateUtil.stringToDate(hksjA);

				if(DateUtil.daysBetween(hksjD, hksjBD) >= 0){
					total1 = total1.add(hkje);
				}else if(DateUtil.daysBetween(hksjAD, hksjD) >= 0){
					total3 = total3.add(hkje);
				}else{
					total2 = total2.add(hkje);
				}
			}

			
			//计算总欠款金额
			totalAll = totalAll.add(total1);
			totalAll = totalAll.add(total2);
			totalAll = totalAll.add(total3);
		}
		//返回值	
		total.setYwybh(ywybh);
		total.setYwymc(ywymc);
		total.setKhbh(khbh);
		total.setKhmc(khmc);
		total.setTotal(totalAll);
		total.setTotal1(total1);
		total.setTotal2(total2);
		total.setTotal3(total3);
		
		return total;
	}
	
	
	
	@Override
	public List<Hkmx> findHkmxeds(String logNo){
		return hkmxDAO.findHkmxeds(logNo);
	}
	
	
	public void setHkmxDAO(HkmxDAO hkmxDAO) {
		this.hkmxDAO = hkmxDAO;
	}

	public void setSxkhDAO(SxkhDAO sxkhDAO) {
		this.sxkhDAO = sxkhDAO;
	}

	public void setXsmxDAO(XsmxDAO xsmxDAO) {
		this.xsmxDAO = xsmxDAO;
	}
	
	
}
