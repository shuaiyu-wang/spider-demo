package com.bds.tokenTest.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("a", "a");
//		System.out.println(map.get("b"));
		
		final String f = "a";
		
		Map<String, String> headermap = new HashMap<>();
		headermap.put("x-region-channel", "CN");
		headermap.put("x-features", "27");
		headermap.put("x-nettype", "WIFI/");
		headermap.put("x-pv", "5.1");
		headermap.put("cache-control", "no-cache");
		headermap.put("x-unitinfo", "center");
		headermap.put("x-app-ver", "6.8.0");
		headermap.put("x-page-url", "http://s.m.taobao.com/h5entry");
		headermap.put("x-page-name", "com.taobao.search.searchdoor.SearchDoorActivity");
		headermap.put("f-refer", "mtop");
		headermap.keySet();
		Set<String> set = new HashSet<>();
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		set.add("xs");
		set.add("ss");
		set.add(null);
		set.add(null);
		System.out.println(set);
		System.out.println(headermap.toString());
		

	}
	
}
