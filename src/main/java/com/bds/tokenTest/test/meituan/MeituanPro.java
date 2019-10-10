package com.bds.tokenTest.test.meituan;

import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bds.base.http.HttpBase;
import com.bds.tokenTest.test.TestFirefox;
import com.bds.tokenTest.util.Util;


public class MeituanPro {
	public static void main(String[] args) throws Exception {
		String avatarUrl = "https%3A%2F%2Fwx.qlogo.cn%2Fmmopen%2Fvi_32%2FTzRlHKricVQIKnko78ZZaqiaicmFfBYAZicQhXM84psWxjIJcCMr7vSokEwiaINaEnnn1kgXe6AicNRWajN9qjMgE6dg%2F132";
		int userId =Integer.parseInt(Util.replaceCharRandomly("203100917"));
		String url = "https://wx.waimai.meituan.com/weapp/v1/poi/food?ui="+userId+"&region_id=1000110100&region_version="+System.currentTimeMillis();
		String uuid = "1"+Util.replaceCharRandomly("0517")+"158362068"+Util.replaceCharRandomly("78780") ;
		String loginToken = Util.replaceCharRandomly("1_hvPCMCOqnJzcvmS1h48reEHIgAAAAAlAcAAMwRh10uqgZPAnBZMhs9VxeVrSNwFtr3Gw-jmHrF_OW9-yU0qSIjkOIN23LHLs1btQ");
//		uuid = "1073399093365288960";
		String poi_id = "455009847688064";
		String gpsLat = "31272255";
		String gpsLng = "121384149";
		String wm_visitid = UUID.randomUUID().toString().toLowerCase();
		long req_time = System.currentTimeMillis();
		String requestId = Util.replaceCharRandomly("9776331586235172");
		String openId = Util.replaceCharRandomly("oOpUI0WRzJA322yKKZRI22uqAe_U");
		String tag = "{\"req_time\":"+req_time+",\"visitid\":\""+wm_visitid+"\","
				+ "\"src_page\":\"p_category\",\"src_block\":\"b_poilist\","
				+ "\"src_item_index\":0,"
				+ "\"src_item_id\":"+poi_id+",\"src_item_type\":\"poi\",\"tgt_page\":\"p_poi\","
				+ "\"extra\":{\"poi_id\":"+poi_id+"},\"action\":\"click\","
				+ "\"wm_actual_longitude\":"+gpsLng+",\"wm_actual_latitude\":"+gpsLat+","
				+ "\"longitude\":"+gpsLng+",\"latitude\":"+gpsLat+",\"ctype\":\"wxapp\","
				+ "\"uuid\":\""+uuid+"\",\"customerid\":0,\"appversion\":\"3.4.8\",\"appname\":\"wxapp\","
				+ "\"dversion\":\"6.7.3\",\"dtype\":\"PAFM00\",\"request_id\":\"0."+requestId+"\",\"tgt_block\":\"b_food\"}";
		
		HashMap<String, String> headerProduct = new HashMap<String, String>();
		String referer = "https://servicewechat.com/wx2c348cf579062e56/154/page-frame.html" ;
		headerProduct.put("charset", "utf-8");
		headerProduct.put("Referer", referer);
		headerProduct.put("content-type", "application/x-www-form-urlencoded");
		headerProduct.put("uuid", uuid);
		headerProduct.put("Host", "wx.waimai.meituan.com");
		headerProduct.put("User-Agent","Mozilla/5.0 (Linux; Android 8.1.0; PAFM00 Build/OPM1.171019.026; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/62.0.3202.84 Mobile Safari/537.36 MicroMessenger/6.7.3.1360(0x2607033C) NetType/WIFI Language/zh_CN Process/appbrand0");
		
		String params = "role_type=0"
				+ "&wm_poi_id="+poi_id
				+ "&trace_tag="+URLEncoder.encode(tag, "utf-8")
				+ "&open_id="+openId
				+ "&uuid="+uuid
				+ "&platform=13&partner=4&riskLevel=1"
				+ "&nickName= "
				+ "&avatarUrl=http://wx.qlogo.cn/mmopen/zhK3MN44IcibtzxZibicddSyp4qVX3rTtfMZsXQwa5mArMmI4A44uJgQyevo9VhePyUbv6MwhsWTzrqttXsUdzJL0LcT5I9reGA/0"
				+ "&gender=0"
				+ "&city=Wenzhou"
				+ "&province=Zhejiang"
				+ "&country=China"
				+ "&lch=1089"
				+ "&user_id="+userId
				+ "&userid="+userId
				+ "&wm_actual_latitude="+gpsLat
				+ "&wm_actual_longitude="+gpsLng
				+ "&waimai_sign=%2F"
				+ "&req_time="+req_time
				+ "&userToken="+loginToken
				+ "&wm_logintoken="+loginToken
				+ "&wm_appversion=3.4.8"
				+ "&wm_visitid="+wm_visitid
				+ "&wm_latitude="+gpsLat
				+ "&wm_longitude="+gpsLng
				+ "&wm_uuid="+uuid
				+ "&wm_dplatform=android&wm_dversion=6.7.3"
				+ "&wm_dtype=PAFM00&wm_ctype=wxapp";
		String token = TestFirefox.getHtmlUnit("file:///C:/token/token_new.html?/weapp/v1/poi/food?"+params);
		
		String dataStr = "_token="+token
				+ "&"
				+ params;
		
		Map<String, String> data = new HashMap<String, String>();
		String[] s = dataStr.split("&");
		for(int i = 0;i < s.length;i ++){
			data.put(s[i].split("=")[0], s[i].split("=")[1]);
		}
		
		try {
			String html = HttpBase.post(url, headerProduct, data);
			html = "";
			System.out.println(html);
			JSONObject jsonObject = JSONObject.parseObject(html);
			JSONArray tagArray = JSONArray.parseArray(jsonObject.getJSONObject("data").getString("food_spu_tags"));
			int size = tagArray.size();
			System.out.println(size);
			for (int i = 0; i < size; i++) {
				JSONObject tagJson = tagArray.getJSONObject(i);
				JSONArray proArray = JSONArray.parseArray(tagJson.getString("spus"));
				if (proArray.size() == 0) {
					System.out.println(i+"---抓取产品时某些分类的产品数为0，稍后将查明原因");
				}
			}
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
