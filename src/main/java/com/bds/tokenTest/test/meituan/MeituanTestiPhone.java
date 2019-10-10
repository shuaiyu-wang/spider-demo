package com.bds.tokenTest.test.meituan;

import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bds.base.http.HttpBase;
import com.bds.tokenTest.test.TestFirefox;
import com.bds.tokenTest.util.Util;


public class MeituanTestiPhone {
	public static void main(String[] args) throws Exception {
		//meituan微信钱包 产品
		String poi_id = "474685092745663";
		poi_id = "312550077374066";
		String wm_visitid = UUID.randomUUID().toString().toLowerCase();
		long req_time = System.currentTimeMillis();
		String gpsLat = "30578775";
		String gpsLng = "120381488";
		String uuid = UUID.randomUUID().toString().toLowerCase();
		int userId =Integer.parseInt(Util.replaceCharRandomly("919823055"));
		String requestId = Util.replaceCharRandomly("32155326240681004");
		String openId = Util.replaceCharRandomly("oOpUI0UK2bx7Kj8aX2VvHSkHsCfs-DI");
		String loginToken = Util.replaceCharRandomly("nt14hcE5UflC6xghhdnR-jrEYHwAAAAAlAcAAIIXT6Y5-dfWyA-ED5UGtrZi88eIwfNwalXYsXM-B6mxBAyRhT_WiMKGVWQxXI_aaQ");
		
		String tag = "{\"req_time\":"+req_time+","
				+ "\"visitid\":\""+wm_visitid+"\",\"src_page\":\"p_category\",\"src_block\":\"b_poilist\",\"src_item_index\":0,"
				+ "\"src_item_id\":"+poi_id+",\"src_item_type\":\"poi\",\"tgt_page\":\"p_poi\",\"extra\":{\"poi_id\":"+poi_id+"},\"action\":\"click\","
				+ "\"wm_actual_longitude\":"+gpsLng+",\"wm_actual_latitude\":"+gpsLat+",\"longitude\":"+gpsLng+",\"latitude\":"+gpsLat+","
				+ "\"ctype\":\"wxapp\",\"uuid\":\""+uuid+"\",\"customerid\":\""+userId+"\",\"appversion\":\"3.4.7\",\"appname\":\"wxapp\",\"dversion\":\"6.7.4\",\"dtype\":\"iPhone 8 (GSM+CDMA)<iPhone10,1>\",\"request_id\":\"0."+requestId+"\",\"tgt_block\":\"b_food\"}";
		
		String params = "role_type=0"
				+ "&wm_poi_id="+poi_id
				+ "&trace_tag="+java.net.URLEncoder.encode(tag,"utf-8")
				+ "&open_id="+openId
				+ "&uuid="+uuid
				+ "&platform=13"
				+ "&partner=4"
				+ "&riskLevel=1"
				+ "&lch=1089"
				+ "&user_id="+userId
				+ "&userid="+userId
				+ "&wm_actual_latitude="+gpsLat+"&wm_actual_longitude="+gpsLng
				+ "&waimai_sign=%2F"
				+ "&req_time="+req_time
				+ "&userToken="+loginToken
				+ "&wm_logintoken="+loginToken
				+ "&wm_appversion=3.4.7"
				+ "&wm_visitid="+wm_visitid
				+ "&wm_latitude="+gpsLat+"&wm_longitude="+gpsLng
				+ "&wm_uuid="+uuid
				+ "&wm_dplatform=ios"
				+ "&wm_dversion=6.7.4"
				+ "&wm_dtype=iPhone%208%20(GSM%2BCDMA)%3CiPhone10%2C1%3E"
				+ "&wm_ctype=wxapp";
		String token = "";
//		token = "eJxVU8mOo1gQ%2FBeueAoe8PygboDB7DvYuNUHMDs2mM0Lrfn3cc3UoUZKKSIyQxGn%2FIONaoZ9ApIkwXaDzdObQ4aBLCC3zJajN9j5545FFAc2WDpGO%2BzzF70lNxAwv78W3lv%2FQhS5ASTF%2Ft78oBTzni%2BP%2BrZgt6TMJ2LMpzlZxqSbf1Bs8309V0nX5Ze%2FvtT%2FBPaOuQbvmDe235h8IUaR4AMBjqVpGjEkRTPMBrDcB%2BIggwDgAENuKbi51%2Fnj3UKzHxwDORJBjkLoXy8gP1iIAIMosEXclmX%2F877z5%2B%2BeqS477BPLtRcXWfJyXfmQOIW33fqyVjOJH6JLtEY6TOMh24%2FReGgPL0UR1YjdmVfxdAJHvDi7lr5cgoTEdxqET1TkLDeXGZxq1a00qdEB9FvPgPd0yEr7eAd8VtSE0Ap3ZUcZd%2FUJHDqztTCwr76Oqyg6IzIcBtG13Z7o5yE88uKUEw2pu2keoVaXJeJ457uucnpdu6zDeI40dufVdXR9BMbLEThyKhwBMk7fEI7QbmtZHi4VLE335i48ER%2FQThAeRcyhtKoqyKdC3Lse94wZM1SDSF%2BkqF4baxhqMTPZlhrTMzOftR4%2FHC1Bry9ruCy5BMswOp172it5%2B2HEuszzD%2FcqSYXq8k9nZimuG5uLEWe7McCpiDQtPIYlTaVapJCIiffhQrb6wQqOhgeudz4LJYsexTMcDbPaQ99eXaefRUUNqtC0SE1yAtOR5R53iroZluA%2BdKC6HKIxkW9ZB%2FnSllSm4mWlbMS2uAqy71nj4SiAkDk8%2FIaUzF3c1qkhgQyAZ5%2Fgk%2BV50J9yYz4tNWtXk2x3zgkEx0tS8xye7uW1FW55wvXZVVReqpmq4roWEV8KrDI33ETwYdsHrK2SVnSm2dv%2BeLMC9%2FiKOlxJTt3DT1Mj0l%2FbDoWQzgrQKehUKL73dLTRThlhi7aFtuzR3N2IhjrqkyLFJ3a6wHyMWnzZct0FZxh9lzb5bs7ojEfn4v1bZpFxh5jq42dGPegU5xLnJepKqbWUHWi3Ewukh%2BvPXpT4AYuK%2BebY3lKovb%2FnuFM6O75yaJ7JulbW6BmziaO7%2Fbp4WhuNbtL0imEZlylKwMuSX%2BfbVQvvhONns9WsKZGXhXZ93mNzwZ37IKKM6dgXnEictzg4qgP29z8Ds2lR";
		token = TestFirefox.getHtmlUnit("file:///C:/token/token_new.html?/weapp/v1/poi/food?"+params);
		String dataStr = "_token=" + token + "&" + params;
		
		HashMap<String, String> headerProduct = new HashMap<String, String>();
		String referer = "https://servicewechat.com/wx2c348cf579062e56/1523/page-frame.html" ;
		headerProduct.put("Host", "wx.waimai.meituan.com");
		headerProduct.put("content-type", "application/x-www-form-urlencoded");
		headerProduct.put("uuid", uuid);
		headerProduct.put("Accept","*/*");
		headerProduct.put("User-Agent","Mozilla/5.0 (iPhone; CPU iPhone OS 11_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15G77 MicroMessenger/6.7.4(0x1607042c) NetType/WIFI Language/zh_CN");
		headerProduct.put("Referer", referer);
		headerProduct.put("Accept-Language", "zh-cn");
		String url = "https://wx.waimai.meituan.com/weapp/v1/poi/food?ui="+userId+"&region_id=1000310100&region_version="+System.currentTimeMillis();
		Map<String, String> data = new HashMap<String, String>();
		String[] s = dataStr.split("&");
		for(int i = 0;i < s.length;i ++){
			data.put(s[i].split("=")[0], s[i].split("=")[1]);
		}
		try {
			String html = MeituanPost.post(url, headerProduct, data);
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
