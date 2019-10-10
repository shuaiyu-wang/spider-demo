package com.bds.tokenTest.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
	public static void main(String[] args) throws ParseException {
		DateFormat _FORMAT = new SimpleDateFormat("yyyy年MM月dd日");
		Date d = _FORMAT.parse("2018年10月1日");
		System.out.println(d);
	}
}
