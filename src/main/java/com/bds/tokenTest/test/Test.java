package com.bds.tokenTest.test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bds.base.http.HttpBase;
import com.bds.tokenTest.Const;

public class Test {
	public static void main(String[] args) throws Exception {
		
		Integer id = Const.id;
		if(id==null){
			id=0;
		}
		System.out.println(id++);
		long time = System.currentTimeMillis();
		System.out.println(time+"-----"+(time-1000));
		
		String uuid1 = UUID.randomUUID().toString().replace("-", "").toUpperCase();
		System.out.println(uuid1);
		
		long params = System.currentTimeMillis();
		int paramInt = (int) (params / 1000);
		
//		java.net.URL url = new URL("");
//		java.net.URLConnection urlconn = url.openConnection();
//		HttpURLConnection huc = (HttpURLConnection) urlconn ;
//		huc.setRequestProperty(key, value);
//		new java.io.OutputStream().write(b, off, len);
		Object o = null;
		System.out.println(o.toString());
	}
	
	public void overLoadMethod(){
		
	}
	public void overLoadMethod(Integer id,String name){
		
	}
	
	public void overLoadMethod(String name,Integer id){
		
	}
	
}
