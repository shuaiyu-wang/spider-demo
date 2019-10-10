package com.bds.tokenTest.test.douyin;

import java.util.HashMap;
import java.util.Map;

import com.bds.base.http.HttpBase;
import com.bds.tokenTest.test.TestFirefox;
import com.bds.tokenTest.util.Util;

public class TestDate {
	public static void main(String[] args) throws Exception {
		String vid = Util.replaceCharRandomly("64326556-C5DC-4E62-BE6E-BA845827EE3C");
		String openid = Util.replaceCharRandomly("ab5cf845768b1a3a6b271898adf849c9e9f434d5");
		String idfa = Util.replaceCharRandomly("9B93CED2-CBE1-4DA5-86C9-E27193354D75");
		String awemeid = Util.replaceCharRandomly("6643168269299617032");
		String deviceid = Util.replaceCharRandomly("56057831791");
		String iid = Util.replaceCharRandomly("56260107973");
//		deviceid = "56057831791";
//		iid = "56260107973";
//		deviceid = "61690141509";
//		iid = "57090655027";
//		deviceid = "60902514577";
//		iid = "55000717301";
		
		
		String url = "https://api.amemv.com/aweme/v2/comment/list/?"
				+ "version_code=3.8.1"
				+ "&pass-region=1"
				+ "&pass-route=1"
				+ "&app_name=aweme"
				+ "&vid="+vid
				+ "&app_version=3.8.1"
				
				+ "&device_id="+deviceid
				+ "&iid="+iid
				
				+ "&channel=App%20Store"
				+ "&mcc_mnc="
				+ "&aid="
				+ "&screen_width=750"
				+ "&openudid="+openid
				+ "&os_api=18"
				+ "&ac=WIFI"
				+ "&os_version=12.1.1"
				+ "&device_platform=iphone"
				+ "&build_number=38101"
				+ "&device_type=iPhone10,1"
				+ "&idfa="+idfa
				+ "&cursor=0"
				+ "&aweme_id=6642234951947259149"
				+ "&count=20"
				+ "&insert_ids="
				+ "&ts="+System.currentTimeMillis()/1000
//				+ "&as=a1253b9340591c88354422&cp=b49cc45c0d5d3a80e1mkuo&mas=01a43906914533c787177f73ad0a03df3d4c4c2c2caccc1c1cc68c"
				;
		Map<String, String> map = new HashMap<String, String>();
		map.put("Host", "api.amemv.com");
//		map.put("Connection", "keep-alive");
//		map.put("x-Tt-Token", "00fbd07dcb49e3eec5808f9ef1dee1701b20e905333c672bfc08a8a1a95f9870d27f9e43776006a165a4ceb02a8da866814");
		map.put("sdk-version", "1");
		map.put("User-Agent", "Aweme 3.8.1 rv:38101 (iPhone; iOS 12.1.1; zh_CN) Cronet");
		map.put("X-SS-TC", "0");
//		map.put("Cookie", "_ga=GA1.2.1101443287.1534861534; "
//				+ "odin_tt=cfec22f6103bd3bcd8e959dccf08aea66eae3bf3fd5cf571e532914959dfebdee6c39e43bfe869e52d32f5bfed13bcf9; "
//				+ "sid_tt=fbd07dcb49e3eec5808f9ef1dee1701b; "
//				+ "sessionid=fbd07dcb49e3eec5808f9ef1dee1701b; "
//				+ "sid_guard=fbd07dcb49e3eec5808f9ef1dee1701b%7C1546756542%7C5184000%7CThu%2C+07-Mar-2019+06%3A35%3A42+GMT; "
//				+ "uid_tt=d70cdbd24d30a938c0bbd24b145643fb; "
//				+ "install_id=56260107973; "
//				+ "ttreq=1$11169e8a5bcf0624d4a5c3d4a55fed1e0f08ab0a");
//		map.put("", "");
		String html = HttpBase.get(url, "utf-8", map).getResult();
		System.out.println(html);
	}
}
