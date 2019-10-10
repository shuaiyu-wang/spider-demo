package com.bds.tokenTest.test.taobao;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bds.base.http.HttpBase;
import com.bds.tokenTest.util.Util;

public class UrlTest {
	public static void main(String[] args) throws Exception {
		String u = "http://211.152.47.81:8888/waimai?lon=112.05548&lat=39.1255&p=1";
		String s = HttpBase.get(u, "utf-8").getResult();
		JSONObject json = JSON.parseObject(s);
		String url = json.getString("url");
		String header = json.getString("header");
		String[] headersarray = header.split(", ");
		Map<String, String> map = new HashMap<String, String>();
		for (String string : headersarray) {
			map.put(string.split("=")[0], string.split("=")[1]);
		}
//		String result = HttpBase.get(url, "utf-8", map).getResult();
		Map<String,String> map1 = new HashMap<String, String>();
		String[] headersarray1 = header.split(", ");
		for (String string : headersarray1) {
			map.put(string.split("=")[0], string.split("=")[1]);
		}
		String result = Util.doGet(url, map1);
		System.out.println(result);
	}
}
