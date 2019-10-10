package com.bds.tokenTest.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	public static void main(String[] args) {
		String s = "Outstanding experience. Wonderful location.";
		s = regex(s);
		System.out.println(s);
	}
	public static String regex(String s){
//		String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		String regEx = "[”“]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(s);
		return m.replaceAll("").trim();
	}
}
