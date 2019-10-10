package com.bds.tokenTest.test;

import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.bds.base.http.HttpBase;

public class Lyan {
	public static void main(String[] args) {
		String url = "https://m.lyancoffee.com/wechat/address/findareav2";
		HashMap<String, String> headers = new HashMap<>();
		headers.put("Host", "m.lyancoffee.com");
		headers.put("Accept", "*/*");
		headers.put("X-Requested-With", "XMLHttpRequest");
		headers.put("Accept-Language", "zh-cn");
		headers.put("Accept-Encoding", "br, deflate");
		headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		headers.put("Origin", "https://m.lyancoffee.com");
		headers.put("User-Agent",
				"Mozilla/5.0 (iPhone; CPU iPhone OS 12_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16A5327f MicroMessenger/6.7.1 NetType/WIFI Language/zh_CN");
		headers.put("Referer", "https://m.lyancoffee.com/wechat/address/findarea");
		headers.put("Cookie",
				"SESSION=e763a17e-6bc2-4631-babc-283f29c0a6a1; SERVERID=854725ca38783d348a5623892a765149|1533107263|1533107238");

		Map<String, String> map = new HashMap<>();
		map.put("lat", "39.930016");
		map.put("lng", "116.409235");
		map.put("wx", "false");
		String html = null;
		try {
			html = HttpBase.post(url, headers, map);
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(html);
		try {
			String s = "{data: null}";
			JSONObject jo = new JSONObject(s);
			System.out.println(jo.getString("data"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String , String> testMap = new HashMap<String , String>();
		testMap.put("String", "123");
		for(String s : testMap.keySet()){
			System.out.println(s+"---"+testMap.get(s));
		}
	}
}
