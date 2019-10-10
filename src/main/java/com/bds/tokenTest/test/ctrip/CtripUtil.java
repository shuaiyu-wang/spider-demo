package com.bds.tokenTest.test.ctrip;

public class CtripUtil {
	public String getCtripHtml(String n,String t){
		
//		System.out.println(t);
//		System.out.println("---");
//		System.out.println(n);
		int r;
		char o;
		String c = "";
		for (r = 0; r < n.length(); r++){
			 o = t.charAt(n.charAt(r) - 21760);
			 c += o;
		}
		return c;
	}
	
}
