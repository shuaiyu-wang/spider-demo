package com.zmf.elme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<String>();
		List<String> list = new ArrayList<String>();
		
		test(set,list);
		System.out.println(list);
	}
	public static void test(Set<String> set,List<String> list) {
		Set<String> set1 = set;
		set1.add("a");
		list.add("a");
		System.out.println("????-------"+set);
	}
}
