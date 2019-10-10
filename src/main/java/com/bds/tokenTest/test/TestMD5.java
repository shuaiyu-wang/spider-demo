package com.bds.tokenTest.test;

import com.bds.base.util.MD5Util;

public class TestMD5 {
	public static void main(String[] args) {
		String sectrt = MD5Util.getMD5("coffee_store_secret");
		String appid = MD5Util.getMD5("coffee_store_app_id");
		String pwd = MD5Util.getMD5("123456");
		System.out.println(pwd);
	}
}
