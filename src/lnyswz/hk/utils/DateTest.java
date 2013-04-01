package lnyswz.hk.utils;

import java.util.Calendar;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		String result = "2013-04-01";
		Date date = DateUtil.stringToDate(result);
		System.out.println(DateUtil.getLastDateOfMonth(date));
	}
}
