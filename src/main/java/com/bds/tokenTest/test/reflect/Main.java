package com.bds.tokenTest.test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) throws Exception {
//		Test.a = "b";
		Class<?> c = Test.class;
		Constructor<?> o = c.getConstructor(Test.class);
		Object obj = "";
		o.newInstance(obj);
//		System.out.println(o);
//		String a = (String) c.getField("a").get(o);
//		Method m = c.getMethod("a");
//		m.invoke(o, null);
//		System.out.println(a);
		
		
	}
}
