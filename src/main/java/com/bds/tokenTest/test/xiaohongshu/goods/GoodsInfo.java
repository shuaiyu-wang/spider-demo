package com.bds.tokenTest.test.xiaohongshu.goods;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bds.base.http.HttpBase;

public class GoodsInfo {
	public static void main(String[] args) throws Exception {
		//属于小棕瓶的神话
		String pid = "58ad34ab70e7524a9a5e453a";
//		//美国.....小棕瓶的传世之组.....5bd3f92fc0fbc50209d1dc8d
//		pid = "5bd3f92fc0fbc50209d1dc8d";
//		//美国.....遮瑕控油持妆力高.....582c743e3431071e2f1bf8d3
//		pid = "582c743e3431071e2f1bf8d3";
//		//用它不需遮瑕膏
//		pid = "56dea53032835214d03eb78d";
		String url = "https://www.xiaohongshu.com/api/store/jpd/"+pid+"/static";
		Map<String, String> headers = new HashMap<>();
		headers.put("Host", "www.xiaohongshu.com");
		headers.put("accept", "application/json, text/plain, */*");
		headers.put("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4.2; HUAWEI MLA-AL10 Build/HUAWEIMLA-AL10) Resolution/720*1280 Version/5.39.1 Build/5391017 Device/(HUAWEI ;HUAWEI MLA-AL10) NetType/WiFi");
//		headers.put("X-Tingyun-Id", "LbxHzUNcfig;c=2;r=1244939994;u=9acbb2b98e79c1b82db2919207a1479fa1c4d99bf66a926a49bf27e7a036a3dd7124097176454ad9b8338d4a8f844f8c::6A10FBA68B7524AE");
		String html = HttpBase.get(url, "utf-8", headers).getResult();
		System.out.println(html);
		parse(html);
	}
	
	public static void parse(String html){
		com.alibaba.fastjson.JSONObject json = JSON.parseObject(html);
		com.alibaba.fastjson.JSONObject data = json.getJSONObject("data");
		JSONArray array = data.getJSONArray("items");
		String skuJson = data.getString("sku_options");
		for (int i = 5;i<array.size();i++) {
			com.alibaba.fastjson.JSONObject item = array.getJSONObject(i);
			String sellingPoint = item.getString("feature");
			String productName = item.getString("short_name");
			JSONArray variants = item.getJSONArray("variants");
			//容量
			String volume = "";
			//版本
			String version = "";
			//色号
			String color = "";
			//组合数量
			String set = "";
			for (Object object : variants) {
				JSONObject obj = JSON.parseObject(object.toString());
				String value = obj.getString("value");
				if(obj.getString("name").equals("组合数量")){
					set = value;
				}else if(obj.getString("name").equals("色号")){
					color = value;
				}else if(obj.getString("name").equals("容量")){
					volume = value;
				}else if(obj.getString("name").equals("版本")){
					version = value;
				}
			}
			System.out.println("set="+set+",color="+color+",volume="+volume+",version="+version);
			JSONObject brand = item.getJSONObject("brand");
			String brandName = brand.getString("name");
			String brandCountry = brand.getString("country");
			String brandId = brand.getString("page_id");
			
			String introduction = item.getString("desc");
			
			JSONObject detail = item.getJSONObject("detail");
			JSONArray attributes = detail.getJSONArray("attributes");
			String volumeType = "";
			String function = "";
			for (Object object : attributes) {
				JSONObject obj = JSON.parseObject(object.toString());
				if(obj.getString("attribute_name").equals("规格类型")){
					volumeType = obj.getString("text");
				}else if(obj.getString("attribute_name").equals("功效")){
					function = obj.getString("text");
				}
			}
			String pid = item.getString("id");
			//优惠券信息json
			String couponJson = item.getString("coupon_text_overview");
			//店铺信息json
			String sellerJson = item.getString("seller");
			//政策json
			String policyJson = item.getString("policy");
			String splId = item.getString("spl_id");
			String category = item.getString("category");
			String name = item.getString("name");
		}
	}
}
