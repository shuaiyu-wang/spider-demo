package com.bds.tokenTest.test.koubei;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.bds.base.http.HttpBase;
import com.bds.tokenTest.util.Util;
import com.google.gson.JsonObject;

public class KoubeiSimple {
	public static void main(String[] args) throws Exception {
		String sessionId = Util.replaceCharRandomly("05ee4ff2-c90f-4857-a89e-bf68649bdcfb");
		String zone = Util.replaceCharRandomly("RZ19B");
		String spanner = Util.replaceCharRandomly("Vhf6zUG4zMBpraYdVqmOIA3AIbwOzXHc4EJoL7C0n0A=");
		String city = "330100";
		String lat = "31.272238";
		String lng = "121.384109";
		Boolean hasMore = false;
		int size = 9;
		int start = 0;
		do{
			String data = "[{\"currentCity\":\""+city+"\","
					+ "\"location\":\""+lng+","+lat+"\","
					+ "\"paramsMap\":{},"
					+ "\"selectedMenus\":{\"mg_category_v1\":\"2018041210003450\","
					+ "\"mg_order\":\"mi_distance\"},"
					+ "\"size\":"+size+",\"start\":"+start+","
					+ "\"actionSrc\":\"offlinetaobao_h5\","
					+ "\"clientOs\":\"ios\","
					+ "\"sceneSrc\":\"taobao_h5_search\","
					+ "\"searchSrc\":\"category\","
					+ "\"sessionId\":\""+sessionId+"\","
					+ "\"queryIndex\":\"1\"}]";
			String url = "https://mobilegw.alipay.com/mgw.htm?operationType=alipay.publicplatform.kbsearch.h5.search&"
					+ "requestData="+URLEncoder.encode(data, "utf-8")
					+ "&disableLimitView=true&callback=kobe_callback_3";
			Map<String, String> header = new HashMap<String, String>();
			header.put("Host", "mobilegw.alipay.com");
			header.put("Accept", "*/*");
			header.put("Cookie", "zone="+zone+"; spanner="+spanner);
			header.put("User-Agent", "iPhone10,1(iOS/12.1.1) AliApp(TB/8.4.0) Weex/0.20.0 750x1334");
			header.put("Accept-Language", "zh-cn");
			String html = HttpBase.get(url, "utf-8", header).getResult().replace("kobe_callback_3(", "");
			String htm = html.substring(0, html.length()-1);
			JSONObject jo =new JSONObject(htm);
			hasMore = jo.getJSONObject("result").getJSONArray("groupRecords").getJSONObject(0).getBoolean("hasMore");
			start = jo.getJSONObject("result").getJSONArray("groupRecords").getJSONObject(0).getInt("nextPageStart");
			size = 14;
			System.out.println(htm);
		}while(hasMore);
	}
}
