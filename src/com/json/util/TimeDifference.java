package com.json.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimeDifference {
	public static List<Date> getDatesBetweenTwoDate(Date beginDate, Date endDate){
		List<Date> date = new ArrayList<Date>();
		date.add(beginDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(beginDate);
		
		boolean bContinue = true;
		while(bContinue) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			if (endDate.after(calendar.getTime())) {
				date.add(calendar.getTime());
			} else {
				break;
			}
		}
		date.add(endDate);
		return date;
	}
}
