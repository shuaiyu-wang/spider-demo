package com.bds.tokenTest.test.thread;

public class Test{
	public void test(){
		Thread t = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
			}
		};
		t.start();
		ThreadLocal<Thread> local = new ThreadLocal<>();
		local.set(t);
		local.get();
	}

	
}
