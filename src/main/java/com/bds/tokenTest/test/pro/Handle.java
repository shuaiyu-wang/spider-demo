package com.bds.tokenTest.test.pro;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Handle implements InvocationHandler{
	
	private ProTestImpl impl = new ProTestImpl();

//	public Handle(ProTestImpl impl) {
//		super();
//		this.impl = impl;
//	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("????");
		String[] s = {"a"};
		System.out.println(s.length);
		method.invoke(impl, args);
		return null;
	}

	public Object getProxy(){
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), impl.getClass().getInterfaces(), this);
	}
	public static void main(String[] args) {
		Handle h = new Handle();
		ProTest pt = (ProTest) h.getProxy();
		pt.sayHello("sss");
	}
}
