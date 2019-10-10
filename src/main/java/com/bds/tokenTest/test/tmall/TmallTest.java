package com.bds.tokenTest.test.tmall;

import org.openqa.selenium.WebDriver;

import com.bds.base.http.HttpBase;

public class TmallTest {
	public static void main(String[] args) {
		String url = "https://detail.tmall.com/item.htm?id=18674856023";
		WebDriver dr = HttpBase.getFirefoxDriver();
		dr.get(url);
	}
}
