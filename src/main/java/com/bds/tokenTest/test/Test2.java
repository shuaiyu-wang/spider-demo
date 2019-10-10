package com.bds.tokenTest.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.jar.JarFile;

public class Test2<T> {
	public static void main(String[] args) throws MalformedURLException {
		StringBuilder sb = new StringBuilder();
		sb.append("");
		sb.append('@');
		sb.append("A5");
		System.out.println(sb.toString());
		String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
		System.out.println(uuid);
		
		String s = "a=a";
		String[] ss = s.split("=",2);
		for (String string : ss) {
			System.out.println("xxx==="+string);
		}
		
		List<String> list = new ArrayList<String>();
		list.add("list");
		list.add("");
		list.add("list");
		System.out.println(list);
		
		System.out.println(System.getProperty("user.dir")+File.separator);
		File jar = new File(System.getProperty("user.dir"));
		URL url = jar.toURI().toURL();
		System.out.println(url);
		System.out.println(4 & 0xF);//0100 & 1111--> 0100
		System.out.println(5>>2);
		for(int i = 0;i<s.length();i++){
			char c = s.charAt(i);
			if(c<=57&&c>=48){
				System.out.println("c---"+c);
			}
		}
		
		while(true){
			System.out.println(111);
			int i = 1/0;
		}
	}
	
//	public static void test(int i){
//		System.out.println("hello");
//		if(i==1){
//			break;
//		}
//	}
}
