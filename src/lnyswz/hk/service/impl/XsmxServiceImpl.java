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
		//�������صĶ���
		SxkhTotal total = new SxkhTotal();
		String bmbh = sxkh.getBmbh();
		String khbh = sxkh.getKhbh();
		//�õ����һ�ʻ����������ˮ��
		String xsfplsh = hkmxDAO.getLastHkLsh(bmbh, khbh);
		
		//ȡ��δ�����������ϸ
		List<Xsmx> lists = xsmxDAO.findXsmxsList(bmbh, khbh, xsfplsh);
		
		//ȡ�����һ��δ����ļ�¼
		List<Hkmx> hkmxs = hkmxDAO.getLastHkmx(bmbh, khbh);
		//�������һ���ѻ�����
		BigDecimal hked = new BigDecimal(0);
		for(Hkmx hkmx : hkmxs){
			hked = hked.add(hkmx.getHkje());
		}
		
		//������ͬ����ʱ�εĻ��ܱ���
		BigDecimal totalAll = new BigDecimal(0);
		BigDecimal totalIn = new BigDecimal(0);
		BigDecimal totalOut1 = new BigDecimal(0);
		BigDecimal totalOut2 = new BigDecimal(0);
		BigDecimal totalOut3 = new BigDecimal(0);
		BigDecimal totalOut4 = new BigDecimal(0);
		BigDecimal totalOut5 = new BigDecimal(0);
		
		//��ǰ����
		Date currentDate = DateUtil.getCurrentDateTime();
		for(Xsmx xsmx : lists){
			//���ݿ�Ʊʱ�䣬�õ���ͬʱ�ε�ʱ��ֵ
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
			
			//�������۽��
			BigDecimal xsje = xsmx.getId().getXsje();
			//��������һ���ѻ��������ѻ����
			if(xsfplsh.equals(xsmx.getId().getXsfplsh())){
				xsje = xsje.subtract(hked);
			}
			
			//���ݻ���ʱ�򣬼��㳬�ڷ�Χ
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
		
		//�ۼ���ʷ��Ƿ���
		totalOut5 = totalOut5.add(new BigDecimal(sxkh.getBalance()));
		
		//������Ƿ����
		totalAll = totalAll.add(totalIn);
		totalAll = totalAll.add(totalOut1);
		totalAll = totalAll.add(totalOut2);
		totalAll = totalAll.add(totalOut3);
		totalAll = totalAll.add(totalOut4);
		totalAll = totalAll.add(totalOut5);
		
		//����ֵ		
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
