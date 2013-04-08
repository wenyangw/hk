package lnyswz.hk.utils;

import java.util.Calendar;

public class DateTest {
	public static void main(String[] args) {
		String result = "2013-03-07";
		//Date date = DateUtil.stringToDate(result);
		//System.out.println(date);
				
		System.out.println(DateUtil.dateIncrease(result, DateUtil.ISO_EXPANDED_DATE_FORMAT, Calendar.DATE, 30));
	}
}
