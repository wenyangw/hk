package lnyswz.hk.utils;

import lnyswz.hk.bean.Sxkh;

public class HkUtil {
	public static String getHksj(String kpsj, int days, String yjkh){
		String hksj = "";
		if(yjkh.equals("0") || yjkh == null || yjkh.equals(" ")){
			hksj = DateUtil.dateIncreaseByDay(kpsj, DateUtil.ISO_EXPANDED_DATE_FORMAT, days);
		}else{
			if(DateUtil.getDayOfMonth(kpsj) < 21){
				hksj = DateUtil.getLastDateOfMonth(DateUtil.stringToDate(kpsj));
			}else{
				hksj = DateUtil.dateIncreaseByDay(kpsj, DateUtil.ISO_EXPANDED_DATE_FORMAT, 30);
			}
		}
		return hksj;
	}
}
