package com.bds.tokenTest.test.xiaohongshu.goods;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bds.base.http.HttpBase;
import com.bds.tokenTest.test.xiaohongshu.Comment;
import com.bds.tokenTest.util.Util;

public class GoodsSimple {
	public static void main(String[] args) throws Exception {
		String keyword = "雅诗兰黛";
		int page = 1;
		
		String html = getProductJson2(page,keyword);
		
		com.alibaba.fastjson.JSONObject json = JSON.parseObject(html);
		com.alibaba.fastjson.JSONObject data = json.getJSONObject("data");
		Integer totalCount = data.getInteger("total_count");
		int pageNum = totalCount / 20 + 1;
		for(int i = page;i<=pageNum;i++){
			System.out.println("page="+i);
			html = getProductJson(i,keyword);
			
			parse(html);
		}
	}
	
	public static void parse(String html){
		com.alibaba.fastjson.JSONObject json = JSON.parseObject(html);
		com.alibaba.fastjson.JSONObject data = json.getJSONObject("data");
		
		JSONArray array = data.getJSONArray("items");
		for (int i = 0;i<array.size();i++) {
			com.alibaba.fastjson.JSONObject item = array.getJSONObject(i);
			String title = item.getString("title");
			String sellingPoint = item.getString("feature");
			com.alibaba.fastjson.JSONObject brand = item.getJSONObject("brand");
			String brandCountry = brand.getString("area");
			String brandName = brand.getString("name");
			String productName = item.getString("desc");
			String price = item.getString("price");
			String promotionPrice = item.getString("discount_price");
			String pic = item.getString("image");
			String pid = item.getString("id");
			String sellerId = item.getString("seller_id");
			//限时特价
			String promotion_text = item.getString("promotion_text");
			//小红书福利社
			String vendorName = item.getString("vendor_name");
			long time = item.getLong("time");
			String pTime = Comment.parseTime(time);
			JSONArray tagsArray = item.getJSONArray("tags");
			String tags = "";
			for (int j=0;j<tagsArray.size();j++) {
				com.alibaba.fastjson.JSONObject tagObj = tagsArray.getJSONObject(j);
				tags += tagObj.getString("name");
				if(j<tagsArray.size()-1){
					tags+= ",";
				}
			}
			//种草
			String favCount = item.getJSONObject("fav_info").getString("fav_count");
			System.out.println(i+"....."+brandCountry+"....."+sellingPoint+"....."+pid+"....."+tags+"....."+promotion_text+"....."+vendorName);
			
		}
	}
	
	public static String getProductJson(int page,String keyword) throws Exception{
		//按销量sort = "sales_qty"，filters = URLEncoder.encode("[]", "utf-8")
		String result = HttpBase.get("http://127.0.0.1:8889/sign?sort=&filters=&page="+page+"&keyword="+URLEncoder.encode(keyword,"utf-8")+"&type=goodsimple", "utf-8").getResult();
		JSONObject jo = new JSONObject(result);
		Map<String,String> map = new HashMap<String, String>();
		String url = jo.getString("url");
		JSONObject header = new JSONObject(jo.getString("header"));
		Iterator<String> it = header.keys();
		while(it.hasNext()){
			String key = it.next();
			map.put(key, header.getString(key));
		}
		
		String html = HttpBase.get(url, "utf-8", map).getResult();
		System.out.println(html);
		return html;
	};
	
	public static String getProductJson2(int page,String keyword) throws Exception{
		//按销量sort = "sales_qty"，filters = URLEncoder.encode("[]", "utf-8")
		
		String sort = "";
		String filters = "";
		String deviceId = Util.replaceCharRandomly("ad038991-1078-3b40-842d-389b0d6ab5a6");
		String fingerprint = Util.replaceCharRandomly("2019021318032049b973f3e0510d3621ea02c29d13117001a9cb7cd7d4f6ac");
		String sid = Util.replaceCharRandomly("1551238908850149822858");//1550052198553742928
		String time = System.currentTimeMillis() / 1000 + "";
		String sign = Util.replaceCharRandomly("d7097393c0d2b4fdaad7965396cd1968");
		String search_id = UUID.randomUUID().toString().replace("-", "").toUpperCase();
		String shield = Util.replaceCharRandomly("ef36f6d8421464c3e574c9f1099e38d53449e7cc0302fce0f5be0681ab795f48");
		
//		String result = HttpBase.get("http://127.0.0.1:8889/sign?sort=&filters=&page="+page+"&keyword="+URLEncoder.encode(keyword,"utf-8")+"&type=goodsimple", "utf-8").getResult();
//		JSONObject jo = JSON.parseObject(result);
//		Map<String,String> map = new HashMap<String, String>();
//		String url = jo.getString("url");
		String url = "https://www.xiaohongshu.com/api/store/ps/products/v2?keyword="+URLEncoder.encode(keyword,"utf-8")
				+ "&filters="+URLEncoder.encode(filters, "utf-8")
				+ "&page="+page
				+ "&size=20"
				+ "&sort="+sort
				+ "&source=store_feed"
				+ "&search_id="+search_id
				+ "&platform=Android&deviceId="+deviceId
				+ "&device_fingerprint="+fingerprint
				+ "&device_fingerprint1="+fingerprint
				+ "&versionName=5.39.1"
				+ "&channel=Store360"
				+ "&sid=session."+sid
				+ "&lang=zh-Hans"
				+ "&t="+time
				+ "&sign="+sign;
//		JSONObject header = JSON.parseObject(jo.getString("header"));
//		Iterator<String> it = header.keySet().iterator();
//		while(it.hasNext()){
//			String key = it.next();
//			map.put(key, header.getString(key));
//		}
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("X-Tingyun-Id", "LbxHzUNcfig;c=2;r=1757170341;u=9e7aeebd434cd9783e6e074f087183a88c4a01f1627a1ab93a7abf84f1bf8c99aa333299d86ee822185f005d27194bc5::B8003062EB2CFACC");
		map.put("Authorization", "session."+sid);
		map.put("device_id", deviceId);
		map.put("User-Agent", "Dalvik/2.2.0 (Linux; U; Android 6.0.1; Redmi 4A MIUI/V9.6.1.0.MCCCNFD) Resolution/720*1280 Version/5.27.0 Build/5270002 Device/(Xiaomi;Redmi 4A) NetType/WiFi");
		map.put("shield", shield);
		map.put("Host", "www.xiaohongshu.com");
		
		String html = HttpBase.get(url, "utf-8", map).getResult();
//		System.out.println(html);
		return html;
	};
}
