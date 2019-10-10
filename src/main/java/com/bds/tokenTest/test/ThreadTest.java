package com.bds.tokenTest.test;

public class ThreadTest {
	public static void main(String[] args) {
		System.out.println(1);
		//异步？？？
		new Thread(){
			public void run(){
				for(int i = 1; i < 10; i ++){
					System.out.println(333);
				}
			}
		}.start();
		System.out.println(2);
	}
}
