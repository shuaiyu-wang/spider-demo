package com.bds.tokenTest.test.dianping;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.bds.base.http.HttpBase;
import com.bds.tokenTest.test.TestFirefox;
import com.bds.tokenTest.util.Util;

public class dpMeituanPro {
	public static void main(String[] args) throws Exception {
		String poid = "5214566";
		String lat = "34.647331";
		String lng = "109.215935";
		String locallat = "34.647331";
		String locallng = "109.215935";
		String fontName = Util.replaceCharRandomly("dd53a913");
		String forWith = Util.replaceCharRandomly("7+Q6ZMxcJ3Y0xF3EBcq6+ba3Tp/+ypDXo2LmA6HDF7ZAxYe9FtMUTZdRJUwpnBJPt9N4OUGTmued05lBffTsmPcb25xV4+5dHTLvpGpxNh3xplEX84yz0UPBmspo1IyIPSkAx+h1n5zTXygN4dtGRw==");
		String uuid = Util.replaceCharRandomly("1073088233551868000");
		String cuid = Util.replaceCharRandomly("167a60d54d686-01ab69395524e5-12180b36-38400-167a60d54d8c8");
		String iuuid = Util.replaceCharRandomly("1073088233560256589");
		String hcv = UUID.randomUUID().toString().toLowerCase()+"."+System.currentTimeMillis()/1000;
		
		String querying = "actualLat="+lat
				+ "&actualLng="+lng
				+ "&initialLat=&initialLng=&geoType=2"
				+ "&mtWmPoiId="+poid
				+ "&dpShopId=-1"
				+ "&source=shoplist"
				+ "&fontName="+fontName;	
		String token = TestFirefox.getHtmlUnit("file:///C:/token/token_new.html?"+querying);
		
		String url = "https://takeaway.dianping.com/waimai/ajax/weixin/menu?"
				+ querying
				+ "&_token="+token
				+ "&_="+System.currentTimeMillis();
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("Host", "takeaway.dianping.com");
		map.put("Connection", "keep-alive");
		map.put("Accept", "application/json");
		map.put("X-Requested-With", "XMLHttpRequest");
		map.put("X-FOR-WITH", forWith);
		map.put("User-Agent", "Mozilla/5.0 (Linux; Android 6.0.1; Redmi 4A Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044403 Mobile Safari/537.36 MicroMessenger/6.6.7.1321(0x26060736) NetType/WIFI Language/zh_CN MicroMessenger/6.6.7.1321(0x26060736) NetType/WIFI Language/zh_CN miniProgram");
		map.put("Referer", "https://takeaway.dianping.com/waimai/weixin/menu"
				+ "?dpShopId="
				+ "&mtShopId="+poid
				+ "&source=shoplist&initialLat=&initialLng="
				+ "&actualLat="+lat
				+ "&actualLng="+lng);
		map.put("Accept-Language", "zh-CN,en-US;q=0.8");
		map.put("Cookie", "ta.uuid="+uuid
				+ "; _lx_utm=utm_source%3Ddianping-wxapp"
				+ "; _lxsdk_cuid="+cuid
				+ "; _lxsdk="+iuuid
				+ "; locallat="+locallat
				+ "; locallng="+locallng
				+ "; geoType=wgs84"
				+ "; _hc.v="+hcv
				+ "; _lxsdk_s=167ac34360f-6e5-bbb-6ba%7C%7C75"
				+ "; isUuidUnion=true"
				+ "; iuuid="+iuuid
				+ "; dpUserId=\"\"; mtUserId=\"\"; "
				+ "waimai_cityname=%E5%9F%8E%E5%B8%82%E5%90%8D%E5%B7%B2%E5%88%A0%E9%99%A4");
		String html = HttpBase.get(url, "utf-8", map).getResult();
		System.out.println(html);
	}
}
