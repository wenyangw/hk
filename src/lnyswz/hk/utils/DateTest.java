package lnyswz.hk.utils;

import java.util.Calendar;

public class DateTest {
	public static void main(String[] args) {
		String result = "2013-03-27";
		//Date date = DateUtil.stringToDate(result);
		//System.out.println(date);
				
		
		System.out.println(HkUtil.getHksj(result, 0, "1"));
	}
}
