package com.bds.tokenTest.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestTime {
	public static void main(String[] args) throws Exception {
		String format = "HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
        	String now = sdf.format(new Date());
        	Date nowTime = new SimpleDateFormat(format).parse(now);
			Date startTime = new SimpleDateFormat(format).parse("09:00:00");
			Date endTime = new SimpleDateFormat(format).parse("20:00:00");
			System.out.println(isInTime(nowTime, startTime, endTime));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Object o = 12;
        System.out.println(o.equals(12));
        
        ////////////////////////////////////////////////////////////////////
        String da = "2018-12-31";
        format = "yyyy-MM-dd";
        sdf = new SimpleDateFormat(format);
        Date date = sdf.parse(da);
        date.setDate(date.getDate()+1);
        String sd = sdf.format(date);
        System.out.println(sd);
	}
	
	public static boolean isInTime(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime() || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }
}
