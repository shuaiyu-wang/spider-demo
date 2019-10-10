package com.bds.tokenTest.test.xiaohongshu;

public class Test {

	public static void main(String[] args) {
		System.out.println("a");
		test();
		System.out.println("c");
	}
	public static void test(){
		for(int i = 0;i < 10; i ++){
			if(i == 0){
				return;
			}
			System.out.println("b");
		}
	}
}
