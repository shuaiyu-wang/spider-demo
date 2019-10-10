package com.bds.tokenTest.test.dianping;

import java.util.HashMap;
import java.util.Map;

import com.bds.base.http.HttpBase;
import com.bds.tokenTest.test.TestFirefox;
import com.bds.tokenTest.util.Util;

public class DianpingTest {
	public static void main(String[] args) throws Exception {
		//simple
		long time = System.currentTimeMillis();
		String querying = "/waimai/ajax/weixin/homepage?startIndex=0&sortId=&multiFilterIds=&sliderSelectCode=&sliderSelectMin=&sliderSelectMax="
				+ "&actualLat=31.27217517630727&actualLng=121.38419768620572&initialLat=31.271429&initialLng=121.38394"
				+ "&geoType=2";
		String token = TestFirefox.getHtmlUnit("file:///C:/token/token_new.html?"+querying);
		String sessionId = Util.replaceCharRandomly("16759ec88f6-702b-78ad-5c4d");
		String fontName = Util.replaceCharRandomly("dd53a913");
		String mtsiToken1 = Util.replaceCharRandomly("fGWYLwMPbqzWxcrJ");
		String mtsitoken2 = Util.replaceCharRandomly("CuIrUQTDswicgaxEB");
		String unionId = Util.replaceCharRandomly("1067690683080609814");
//		System.out.println(token);
		String simpleUrl = "https://takeaway.dianping.com/waimai/ajax/weixin/homepage?startIndex=0"
				+ "&sortId=&multiFilterIds=&sliderSelectCode=&sliderSelectMin=&sliderSelectMax="
				+ "&actualLat=31.27217517630727&actualLng=121.38419768620572&initialLat=31.271429&initialLng=121.38394"
				+ "&geoType=2&rankTraceId="
				+ "&unionId="+unionId
				+ "&sessionId="+sessionId
				+ "&fontName="+fontName
				+ "&mtsiToken="+mtsiToken1+"%2"+mtsitoken2
				+ "&_token="+token
				+ "&_="+time;
//		simpleUrl = "https://takeaway.dianping.com/waimai/ajax/weixin/homepage?startIndex=0&sortId=&multiFilterIds=&sliderSelectCode=&sliderSelectMin=&sliderSelectMax="
//				+ "&actualLat=31.272213192266488&actualLng=121.38419768951844&initialLat=&initialLng=&geoType=2&rankTraceId=&unionId=&sessionId=&fontName=20ad699b&mtsiToken=RwyfbeyhQyYrKwuL%2CKzMMictqQapZbEhe&_token=eJxtUWtvokAU%2FS986BdEBxiGgcZsiq1UBSq2RXDTkOGhIvKQh6DN%2FvedNm2aTTZzk3PvOefDvWfemWoWMSoPABDEAXOOK0Zl%2BCEYImbANDVVJChCJPBQlBRpwIT%2FcBBKaMAElXPPqL9FBAYSwm8fxIrOnwSC4G3w0wmQ1odjRg3MvmnKWh2NGpLGpCOXYZSQvEzy3TAsslFHkowkoy5O%2BiT%2F1TaZXxdtFcbjbxfX9aQsb7IkJ35Osv8L9KI6KfKxOOSlIbjx%2FWNfR6lfkopk9bhWeSRLEUS8JAMujALCRYgoHI5F8fZIRRRjmZdDKIuQ42UYC1JICEZI2XKAvh8DDvEtUb838D83uO1Uzn6MW93ugbAsG%2FFwOqLn%2FuAfrcv19bmcTOpZ5emLc2rKOKWBMzSa7IVGQzH9QvKFzfds0h%2Bi3jrZ5bSL5310MKdtd7iztS073QHsdCkk8sxanuavdqnNG6Plm4cL23WVXp5XeuoqeHZKqyZ4WS0DIbCxrbEToTOenMgo1%2Fb%2B4MwdZ10023rT1VNjHpOpQTbEsQrl%2BYhcr8d3Z7CwnIk4cUwCoKdfdXyxH7T1Am1ERToVSWxe3X5v6qxbb5SEtXpLRvl17XrL7MKiskCj5qqxxFKeTkah4RF4mcO%2BcgRhlj5Ay06Re19XZrsxzehqp3gJ9nsou%2Bn6cQuAxYvspEtWCWxa1%2FOMHdYL19sdRNh2gdlq22A3HjN%2F%2FgJAHeNW&_=1543462144484";
		String xforwith = Util.replaceCharRandomly("UGpn9PmPjJ3xdZgt0P02FLtT/z4NjRBUUly6tlEitkiENXh5tNAQb/tlEYysGyN7ptoU2QIRoJ0CxFihf1s/xnlCmnJGYkdoPSmwgNLQZm9el1Bq/0l6SMI2NgtK/x1B+J1OpvWMjHDMayR2DT2Wjg==");
		String cuid = Util.replaceCharRandomly("1675d3a78916f-06978b096c54ac-6e7d743a-38400-1675d3a789321");
		Map<String, String> simap = new HashMap<String, String>();
		simap.put("Host", "takeaway.dianping.com") ;
		simap.put("Connection", "keep-alive") ;
		simap.put("Accept", "application/json") ;
		simap.put("X-Requested-With", "XMLHttpRequest") ;
		simap.put("User-Agent", "Mozilla/5.0 (Linux; Android 6.0.1; Redmi 4A Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.143 Crosswalk/24.53.595.0 XWEB/362 MMWEBSDK/21 Mobile Safari/537.36 MicroMessenger/6.6.7.1321(0x26060736) NetType/WIFI Language/zh_CN MicroMessenger/6.6.7.1321(0x26060736) NetType/WIFI Language/zh_CN miniProgram") ;
		simap.put("Accept-Language", "zh-CN,en-US;q=0.9");
		simap.put("X-FOR-WITH", xforwith) ;
		simap.put("Referer", "https://takeaway.dianping.com/waimai/weixin/home?"
				+ "__lxsdk_params=s%3A167596a451d-e877-aed5-b023%3Bl%3A166e8717c4734-174e25caa8669f-0-0-166e8717c48c8%3Ba%3Adianping_wxapp%3Bw%3A-QHeuGQx02Ppt3jql6Sxj_lNyzUSpCCsIrYGKvkM78k"
				+ "&mina_name=dianping-wxapp"
				+ "&mina_version=3.15.0"
				+ "&utm_source=dianping-wxapp"
				+ "&__="+(time-1000)) ;
		simap.put("Cookie", "ta.uuid=1067963725966962711"
				+ "; _lxsdk_cuid=1675d3a78916f-06978b096c54ac-6e7d743a-38400-1675d3a789321"
				+ "; _lxsdk=1067690683080609814"
				+ "; _hc.v=c22cb4c2-876f-7412-2b3f-08453b79dee4.1543457377"
				+ "; isUuidUnion=true"
				+ "; iuuid=1067690683080609814"
				+ "; dpUserId=\"\"; mtUserId=\"\""
				+ "; waimai_cityname=%E5%9F%8E%E5%B8%82%E5%90%8D%E5%B7%B2%E5%88%A0%E9%99%A4"
				+ "; _lx_utm=utm_source%3Ddianping-wxapp"
				+ "; locallat=31.27402"
				+ "; locallng=121.37958"
				+ "; geoType=wgs84"
				+ "; _lxsdk_s=1675df840f6-50b-23b-168%7C%7C77") ;
		String simpleHtml = HttpBase.get(simpleUrl, "utf-8", simap).getResult();
		System.out.println(simpleHtml);

		
		//产品
		String s = "https://takeaway.dianping.com/waimai/ajax/weixin/menu?"
				+ "actualLat=31.272193206981562"
				+ "&actualLng=121.38422271480015"
				+ "&initialLat="
				+ "&initialLng="
				+ "&geoType=2"
				+ "&mtWmPoiId=502993221146780"
				+ "&dpShopId=-1"
				+ "&source=shoplist"
				+ "&fontName=dd53a913"
				+ "&_token=eJyVUttuo0AM%2FRek5qUJmQvXSKiialJIKQ25t6sKDTCBKYHQcEuy2n%2FfaZtstfu2mpFsn3NsWbZ%2FCns7EgYQAIBwV2joXhgIUASiInSFquSMLCFd1lQdQ03vCuFfmASg2hWC%2FfJOGPzACugqkvb6AUx5%2FAmoCLx2vz2M%2BP9Q2FwgJFVVlIN%2BvyIpJS05ihEjecHyWAx3Wb8lLCOs31J2YHk%2Fo3l9ExWzZFfYkdHJqrMnA6TrGCEIJUXVQKfc1fuQGiVnt6ysOixnFSNbh1TGHz%2BPjQ4Jq%2FoLxlBEKoK8CFB0DcoKupBcBxEUsSYhhFQoaQBAmc%2Flf%2FpOdhm98f3toYxSvyB7kpVGeYVNqKh4I0cRkmBPjsKwx%2BsrPahTeoVvt58CRVUVNUCbIIg4gSHaqJRIkR6FPcDftyAMNZ5EeNKlEb89kKLgYMvBZjxevTGX6O48Kzxke%2Bvt7RvwRkWgm65nW64ymVltOFm8m52M5cTPSUaNS6neZ6kvgp9HyXa5gUUoi6BTV5l%2Fnvc%2Fat83LkeiyUAHAt95Nuc75zY9W3K21SV%2B5KfHp1uyOOceHbf6KSwf2jfTS%2BgIK6sx2pbHlLy4Iys1veF0GibHYOVZk9t5Qq8bzxrh5%2BEd1q%2FlbE1xnhwCNoduMiSzexveu1NHO%2B0Pz%2BOn49baJbs2HTqxV2jNXHYm60L1LLY43dN13CzpbBV5beI8qEt0N36O5bBps%2F6%2BHqcTRh22QJ6ZHp1FbbenpDCXzcsaP7Wr68m6tixsBvHmsbAN4ddvaQcLoA%3D%3D"
				+ "&_=1542958794052";

		Map<String, String> map = new HashMap<String, String>();
		map.put("Host", "takeaway.dianping.com");
		map.put("Connection", "keep-alive");
		map.put("Accept", "application/json");
		map.put("X-Requested-With", "XMLHttpRequest");
		map.put("User-Agent", "Mozilla/5.0 (Linux; Android 8.1; Redmi 6 Build/O11019; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.143 Crosswalk/24.53.595.0 XWEB/362 MMWEBSDK/180803 Mobile Safari/537.36 MMWEBID/3514 MicroMessenger/6.7.3.1360(0x2607033A) NetType/WIFI Language/zh_CN Process/appbrand2 miniProgram");
		map.put("X-FOR-WITH", "qlQHoUv+q+glzg6jgFoQ7Kv8PPysTnNSMipfH+Lx1FV+f7o3yVUppqBCGQTJwTmTUJ5AS6J0Dp7gYh/IjGfJYqEeLjnF972m2Zubw7Ly/Ii6t/JUZoZPfhQNDUGBTqEeBNjwLCSiIvBWKD3ey2fLmg==");
		map.put("Referer", "https://takeaway.dianping.com/waimai/weixin/menu?dpShopId=&mtShopId=502993221146780&source=shoplist&initialLat=&initialLng=&actualLat=31.272193206981562&actualLng=121.38422271480015");
		map.put("Accept-Language", "zh-cn");
//		map.put("", "");
		map.put("Cookie", "ta.uuid=1065862444532084774; _lxsdk_cuid=1673f5e0badc5-08521768ec8238-6c503731-3f480-1673f5e0bb0c8; _lxsdk=1065862444532060162; _hc.v=5e9179ab-c490-87c5-c7d0-e3114950e178.1542956397; cityid=1; msource=qianbaowaimai; qianbaowaimai_ab=shopphoto%3AA%3A1; _lx_utm=utm_source%3Ddianping-wxapp; locallat=31.27402; locallng=121.37958; geoType=wgs84; _lxsdk_s=1673f5e0bb3-55c-f73-226%7C%7C232; isUuidUnion=true; iuuid=1065862444532060162; dpUserId=\"\"; mtUserId=\"\"; waimai_cityname=%E5%9F%8E%E5%B8%82%E5%90%8D%E5%B7%B2%E5%88%A0%E9%99%A4");
		String html = HttpBase.get(s, "utf-8", map).getResult();
		System.out.println(html);
	}
}
