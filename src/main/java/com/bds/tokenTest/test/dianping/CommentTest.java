package com.bds.tokenTest.test.dianping;

import java.util.HashMap;
import java.util.Map;

import com.bds.base.http.HttpBase;
import com.bds.tokenTest.test.TestFirefox;
import com.bds.tokenTest.util.Util;

public class CommentTest {
	public static void main(String[] args) throws Exception {
		long time = System.currentTimeMillis();
		String shopId = "5207828";//5207828
		String poiId = "443864406695217";//443864406695217
		String querying = "/waimai/ajax/weixin/shopcomments?"
				+ "lng=&lat=&gpsLng=121.38413262060968&gpsLat=31.272230139202875"
				+ "&shopId="+shopId
				+ "&mtWmPoiId="+poiId
				+ "&startIndex=0&labelId=0&scoreType=0";
		String token = TestFirefox.getHtmlUnit("file:///C:/token/token_new.html?"+querying);
		String url = "https://takeaway.dianping.com/waimai/ajax/weixin/shopcomments?"
				+ "lng=&lat=&gpsLng=121.38413262060968"
				+ "&gpsLat=31.272230139202875"
				+ "&shopId="+shopId
				+ "&mtWmPoiId="+poiId
				+ "&startIndex=0&labelId=0&scoreType=0"
				+ "&_token="+token
				+ "&_="+time;
		String xforwith = Util.replaceCharRandomly("Tdgci/aS4wIgehMWqunssOQeghx2ZDD/RUjZ0LkVcVeVTtlhOcxZ0/YKjevLw2jeW3RfrfcOBjNWbigC9kU/DdG49WXN5aq7JxQujytIXs6Q0X6bhb4rgtiiPNdxjTdql2pcpSrKtTNPti7Hy0HfGw==");
		String uuid = Util.replaceCharRandomly("1067690683080609814");
		String cuid = Util.replaceCharRandomly("1675d3a78916f-06978b096c54ac-6e7d743a-38400-1675d3a789321");
		String hc = Util.replaceCharRandomly("c22cb4c2-876f-7412-2b3f-08453b79dee4.");
		Map<String, String> map = new HashMap<String, String>();
		map.put("Host", "takeaway.dianping.com");
		map.put("Connection", "keep-alive");
		map.put("Accept", "application/json");
		map.put("X-Requested-With", "XMLHttpRequest");
		map.put("X-FOR-WITH", xforwith);
		map.put("User-Agent", "Mozilla/5.0 (Linux; Android 6.0.1; Redmi 4A Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/67.0.3396.87 XWEB/470 MMWEBSDK/21 Mobile Safari/537.36 MicroMessenger/6.6.7.1321(0x26060736) NetType/WIFI Language/zh_CN MicroMessenger/6.6.7.1321(0x26060736) NetType/WIFI Language/zh_CN miniProgram");
		map.put("Referer", "https://takeaway.dianping.com/waimai/weixin/menu?"
				+ "dpShopId=&mtShopId="+poiId
				+ "&source=shoplist&initialLat=&initialLng="
				+ "&actualLat=31.272230139202875&actualLng=121.38413262060968");
		map.put("Accept-Language", "zh-CN,en-US;q=0.9");
		map.put("Cookie", "ta.uuid="+uuid+"; "
				+ "_lxsdk_cuid="+cuid+"; "
				+ "_lxsdk="+uuid+"; "
				+ "_hc.v="+hc+time/1000+"; "
				+ "isUuidUnion=true; "
				+ "iuuid="+uuid+"; "
				+ "dpUserId=\"\"; mtUserId=\"\"; "
				+ "waimai_cityname=%E5%9F%8E%E5%B8%82%E5%90%8D%E5%B7%B2%E5%88%A0%E9%99%A4; "
				+ "_lx_utm=utm_source%3Ddianping-wxapp; "
				+ "_lxsdk_s=1675df840f6-50b-23b-168%7C%7C175");
		String html = HttpBase.get(url, "utf-8", map).getResult();
		System.out.println(html);
	}
}
