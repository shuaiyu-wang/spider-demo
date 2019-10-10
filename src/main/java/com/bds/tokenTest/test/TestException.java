package com.bds.tokenTest.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.bds.base.http.HttpBase;

public class TestException {
	public static void main(String[] args){
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document doc = Jsoup.parse(null);
		Elements elements = doc.select("tbody>tr");
		System.out.println(elements.size());
		System.out.println(123);
	}
}
