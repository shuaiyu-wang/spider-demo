package com.bds.tokenTest.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestSubstring {
	
	
	public TestSubstring() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		String s = test02();
		System.out.println(s);
//		test02();
	}
	public static String test02(){
//		String s = (int)(Math.random()*10*Math.pow(10, 9))+"";
//		try {
////			System.out.println(1/0);
//			System.out.println("try");
//			return "111";
//		} catch (Exception e) {
//			System.out.println("catch");
//			return "222";
//		}finally{
//			System.out.println("finally");
////			return "333";
//		}
//		System.out.println(Test01.a);
		String s = "123";
		s.substring(2,s.length()-2);
		return s;
	}
}
