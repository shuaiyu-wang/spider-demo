package com.bds.tokenTest.test;


public class Test01 {
	public static void main(String[] args) throws Exception {
		System.out.println(Test01.a);
		
		
		try {
			while(true){
				System.out.println(1/0);
			}
		} catch (Exception e) {
			System.out.println("0 0");
		}
		
		System.out.println("abc---->"+"\rd");
	}
	
	private static final int a = 0;
	
	
	
	

}
