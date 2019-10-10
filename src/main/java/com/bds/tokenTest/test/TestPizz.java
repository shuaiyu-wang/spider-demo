package com.bds.tokenTest.test;

public class TestPizz {
	public static void main(String[] args) {
		long t = System.currentTimeMillis();
		System.out.println((int)(Math.random()*9 + 1));
		String s = "";
		for(int i = 0;i < 19;i ++){
//			System.out.println(i);
			int j = (int) (Math.random()*9+1);
			System.out.println(j+"--"+i);
			s = s + j;
		}
		System.out.println(s);
		
//		String url = "https://emap.4008123123.com/CloudEMap/gate?callback=jQuery1830208874264040537_"+t+"&sid=200002&x="+lng+"&y=31.26902brand=2&encode=UTF-8&_="+t;
	}
}
