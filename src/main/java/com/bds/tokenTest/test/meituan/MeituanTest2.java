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


public class MeituanTest2 {
	public static void main(String[] args) throws Exception {
		//meituan微信钱包 产品
//		String poi_id = "474685092745663";
//		poi_id = "312550077374066";
//		String wm_visitid = UUID.randomUUID().toString().toLowerCase();
//		long req_time = System.currentTimeMillis();
//		String gpsLat = "30578775";
//		String gpsLng = "120381488";
//		String uuid = "1"+Util.replaceCharRandomly("0517")+"158362068"+Util.replaceCharRandomly("78780") ;
//		int userId =Integer.parseInt(Util.replaceCharRandomly("919823055"));
//		String requestId = Util.replaceCharRandomly("32155326240681004");
//		String openId = Util.replaceCharRandomly("oOpUI0UK2bx7Kj8aX2VvHSkHsCfs-DI");
//		String loginToken = Util.replaceCharRandomly("nt14hcE5UflC6xghhdnR-jrEYHwAAAAAlAcAAIIXT6Y5-dfWyA-ED5UGtrZi88eIwfNwalXYsXM-B6mxBAyRhT_WiMKGVWQxXI_aaQ");
		
//		String tag = "{\"req_time\":"+req_time+","
//				+ "\"visitid\":\""+wm_visitid+"\",\"src_page\":\"p_category\",\"src_block\":\"b_poilist\",\"src_item_index\":0,"
//				+ "\"src_item_id\":"+poi_id+",\"src_item_type\":\"poi\",\"tgt_page\":\"p_poi\",\"extra\":{\"poi_id\":"+poi_id+"},\"action\":\"click\","
//				+ "\"wm_actual_longitude\":"+gpsLng+",\"wm_actual_latitude\":"+gpsLat+",\"longitude\":"+gpsLng+",\"latitude\":"+gpsLat+","
//				+ "\"ctype\":\"wxapp\",\"uuid\":\""+uuid+"\",\"customerid\":\""+userId+"\",\"appversion\":\"3.4.7\",\"appname\":\"wxapp\",\"dversion\":\"6.6.7\",\"dtype\":\"Redmi 4A\",\"request_id\":\"0."+requestId+"\",\"tgt_block\":\"b_food\"}";
		
		String params = "role_type=0"
				+ "&wm_poi_id=389094984533019"
				+ "&open_id=oOpUI0fzd40Jm8CX15ZB2LlBR-DI"
				+ "&uuid=1051715836206878780"
				+ "&platform=13&partner=4&riskLevel=1"
				+ "&lch=1019"
				+ "&user_id=919823055&userid=919823055"
				+ "&wm_actual_latitude=31272236&wm_actual_longitude=121384170"
				+ "&waimai_sign=%2F"
				+ "&req_time=1544671507613"
				+ "&userToken=UwW1iId8iVIlrkOZz0vQY2GnwZoAAAAAlAcAAB_3WmGhRCsCA1x5HNCuMZmzyTEvH50eZz-nVua28bF-z8PMA8Xf6N_0CP-uB_l7Tg"
				+ "&wm_logintoken=UwW1iId8iVIlrkOZz0vQY2GnwZoAAAAAlAcAAB_3WmGhRCsCA1x5HNCuMZmzyTEvH50eZz-nVua28bF-z8PMA8Xf6N_0CP-uB_l7Tg"
				+ "&wm_appversion=3.4.7"
				+ "&wm_visitid=c2d53ee1-3a8f-441c-91c7-b7690055baa7"
				+ "&wm_latitude=31272236&wm_longitude=121384170"
				+ "&wm_uuid=1051715836206878780"
				+ "&wm_dplatform=android"
				+ "&wm_dversion=6.6.7"
				+ "&wm_dtype=Redmi%206"
				+ "&wm_ctype=wxapp";
		String token = "";
//		token = "eJxVU8mOo1gQ%2FBeueAoe8PygboDB7DvYuNUHMDs2mM0Lrfn3cc3UoUZKKSIyQxGn%2FIONaoZ9ApIkwXaDzdObQ4aBLCC3zJajN9j5545FFAc2WDpGO%2BzzF70lNxAwv78W3lv%2FQhS5ASTF%2Ft78oBTzni%2BP%2BrZgt6TMJ2LMpzlZxqSbf1Bs8309V0nX5Ze%2FvtT%2FBPaOuQbvmDe235h8IUaR4AMBjqVpGjEkRTPMBrDcB%2BIggwDgAENuKbi51%2Fnj3UKzHxwDORJBjkLoXy8gP1iIAIMosEXclmX%2F877z5%2B%2BeqS477BPLtRcXWfJyXfmQOIW33fqyVjOJH6JLtEY6TOMh24%2FReGgPL0UR1YjdmVfxdAJHvDi7lr5cgoTEdxqET1TkLDeXGZxq1a00qdEB9FvPgPd0yEr7eAd8VtSE0Ap3ZUcZd%2FUJHDqztTCwr76Oqyg6IzIcBtG13Z7o5yE88uKUEw2pu2keoVaXJeJ457uucnpdu6zDeI40dufVdXR9BMbLEThyKhwBMk7fEI7QbmtZHi4VLE335i48ER%2FQThAeRcyhtKoqyKdC3Lse94wZM1SDSF%2BkqF4baxhqMTPZlhrTMzOftR4%2FHC1Bry9ruCy5BMswOp172it5%2B2HEuszzD%2FcqSYXq8k9nZimuG5uLEWe7McCpiDQtPIYlTaVapJCIiffhQrb6wQqOhgeudz4LJYsexTMcDbPaQ99eXaefRUUNqtC0SE1yAtOR5R53iroZluA%2BdKC6HKIxkW9ZB%2FnSllSm4mWlbMS2uAqy71nj4SiAkDk8%2FIaUzF3c1qkhgQyAZ5%2Fgk%2BV50J9yYz4tNWtXk2x3zgkEx0tS8xye7uW1FW55wvXZVVReqpmq4roWEV8KrDI33ETwYdsHrK2SVnSm2dv%2BeLMC9%2FiKOlxJTt3DT1Mj0l%2FbDoWQzgrQKehUKL73dLTRThlhi7aFtuzR3N2IhjrqkyLFJ3a6wHyMWnzZct0FZxh9lzb5bs7ojEfn4v1bZpFxh5jq42dGPegU5xLnJepKqbWUHWi3Ewukh%2BvPXpT4AYuK%2BebY3lKovb%2FnuFM6O75yaJ7JulbW6BmziaO7%2Fbp4WhuNbtL0imEZlylKwMuSX%2BfbVQvvhONns9WsKZGXhXZ93mNzwZ37IKKM6dgXnEictzg4qgP29z8Ds2lR";
//		token = TestFirefox.getHtmlUnit("file:///C:/token/token_new.html?/weapp/v1/poi/food?"+"role_type=0&wm_poi_id=389094984533019&open_id=oOpUI0fzd40Jm8CX15ZB2LlBR-DI&uuid=1051715836206878780&platform=13&partner=4&riskLevel=1&lch=1019&user_id=919823055&userid=919823055&wm_actual_latitude=31272236&wm_actual_longitude=121384170&waimai_sign=%2F&req_time=1544671507613&userToken=UwW1iId8iVIlrkOZz0vQY2GnwZoAAAAAlAcAAB_3WmGhRCsCA1x5HNCuMZmzyTEvH50eZz-nVua28bF-z8PMA8Xf6N_0CP-uB_l7Tg&wm_logintoken=UwW1iId8iVIlrkOZz0vQY2GnwZoAAAAAlAcAAB_3WmGhRCsCA1x5HNCuMZmzyTEvH50eZz-nVua28bF-z8PMA8Xf6N_0CP-uB_l7Tg&wm_appversion=3.4.7&wm_visitid=c2d53ee1-3a8f-441c-91c7-b7690055baa7&wm_latitude=31272236&wm_longitude=121384170&wm_uuid=1051715836206878780&wm_dplatform=android&wm_dversion=6.6.7&wm_dtype=Redmi%204A&wm_ctype=wxapp");
		String dataStr = "_token=eJxVkF2PqkgQhv8Lt7pDN003zSR7ASKCHyAgCJ6cCz4VBQRBEDf735fZTDazSSf1vtVPVVf1X8xDT5hPCACAZM507aQxjwFECAiUw3Mm%2FpnDiJApFz08hfn8hQiYY8j%2F%2FkrYk%2F8lcGAOAUd%2Fz39Ijp%2FOF6NPCFOH57RlH2nbhc9HWHU%2FJDP%2Fvo0vYVWlxR9f7n%2BGmdqUh6nNFG%2FfMfyKDMejD0IgFgEWCBQgpXMogA8EARFFnnBUBISb93k6TK9wHPiAIg8pQrxIgIgmmHATTEQeTHtPDf5jEf6YVhcIEgCHRA5P6FQ91QkI8jxGcPqjf9FplO57pDY%2FV8wnk65H0VO7vnxLAeu0B%2BU9dGXA4UOvK2HSFP6prUly6jznsN1ZBEp1vhhDz2PZ5%2B4IlbBONqmci8O7r6gf4G7DGWil60Nb%2BuvFqDvb7czbU0EmufoaXDet%2BnGBnkh%2Fxq8VpRqPFriurToNkvi5I%2FWxbe8vW4tUgb85ZpxZ8RtIy2xjKURNcr8Wx0NMB7aOTvV4z%2BLbq1U9tczIZePj%2BKiiduhrupLAbNuMRqO7Tn4Mjt7FeUrnSISBjKHM8dunpZSt4gVmsVxIvkTR%2B74dh8RT012hHIp1c79dF006lo8spt2ufbiXgjiufjEhuZaXdImXt2yRqHfZD9RWpeel7sq5PEjJDMtojI7ZfhW6w0gKVztF9uCPVSlmwR0uUz87rcfxcrAuQVmUx%2FzhpQqHX%2Fd%2BszyNR8dedO7tVJ5Ne7PcWqwcWp5bWYa01naJUla0Fx55KLqwSwSrPVjQoDNdk2V%2Bd5fjHA3qbGWe%2FZWkPsLce%2FvVkRucC7htI%2B2mNZ4Sss3j6oJETy72ywIZblvTPggWosF%2BZ4i%2Bb6bY3CirVxdExFlBvqEn6aS8huKMzauDDEk9nHOK6quyjxaOe44p5yKjmYnj2%2BppkpEiDCNDWKRRapiiuUzXV8CX8TbsO6QJJ2W15UXjnmmRdirr3aOdcTofG%2Fz16KD%2BipTTTRByLtouk%2FFZpG8UI1FMC8AiyY7SQDAjOrunPHk%2BmpAa51u0E6P9uFF6KQLdfmU7SRdtKr1xFsiRqtnICkGSvKPQfgeG0AAUmXRtVASU2jJdjfsQEYslgq1v8psjvWoD87L8rI47z4Fjt37t6mZtsWjvrJ%2BVjWt2r2v4LRV9ySZahU0vHXpxXMOClfah19r3P5m%2F%2FwHiTnPq"
				+ "&role_type=0"
				+ "&wm_poi_id=360073890760695"
				+ "&trace_tag=%7B%22req_time%22%3A1545013353611%2C%22visitid%22%3A%2298f7c16f-c5a4-441e-ad1f-b29337055616%22%2C%22src_page%22%3A%22p_category%22%2C%22src_block%22%3A%22b_poilist%22%2C%22src_item_index%22%3A0%2C%22src_item_id%22%3A360073890760695%2C%22src_item_type%22%3A%22poi%22%2C%22tgt_page%22%3A%22p_poi%22%2C%22extra%22%3A%7B%22poi_id%22%3A360073890760695%7D%2C%22action%22%3A%22click%22%2C%22wm_actual_longitude%22%3A121384180%2C%22wm_actual_latitude%22%3A31272253%2C%22longitude%22%3A121384180%2C%22latitude%22%3A31272253%2C%22ctype%22%3A%22wxapp%22%2C%22uuid%22%3A%221051715836206878780%22%2C%22customerid%22%3A%22919823055%22%2C%22appversion%22%3A%223.4.8%22%2C%22appname%22%3A%22wxapp%22%2C%22dversion%22%3A%226.6.7%22%2C%22dtype%22%3A%22Redmi%204A%22%2C%22request_id%22%3A%220.22719278748402805%22%2C%22tgt_block%22%3A%22b_food%22%7D"
				+ "&open_id=oOpUI0fzd40Jm8CX15ZB2LlBR-DI"
				+ "&uuid=1051715836206878780"
				+ "&platform=13&partner=4&riskLevel=1&lch=1089"
				+ "&user_id=919823055"
				+ "&userid=919823055"
				+ "&wm_actual_latitude=31272253&wm_actual_longitude=121384180"
				+ "&waimai_sign=%2F"
				+ "&req_time=1545013353612"
				+ "&userToken=KRGuuFuCKcH5NyiI3d63CH1QyswAAAAAlAcAAE9DFhcQtD_SFwB2c-Ak3o5DYV_R24ZcHbBoNytQxVqSENyzJ9vRxoRSCa4k9MMHeA"
				+ "&wm_logintoken=KRGuuFuCKcH5NyiI3d63CH1QyswAAAAAlAcAAE9DFhcQtD_SFwB2c-Ak3o5DYV_R24ZcHbBoNytQxVqSENyzJ9vRxoRSCa4k9MMHeA"
				+ "&wm_appversion=3.4.8"
				+ "&wm_visitid=98f7c16f-c5a4-441e-ad1f-b29337055616"
				+ "&wm_latitude=31272253&wm_longitude=121384180"
				+ "&wm_uuid=1051715836206878780&wm_dplatform=android"
				+ "&wm_dversion=6.6.8&wm_dtype=Redmi%204A&wm_ctype=wxapp";
		HashMap<String, String> headerProduct = new HashMap<String, String>();
		String referer = "https://servicewechat.com/wx2c348cf579062e56/153/page-frame.html" ;
		headerProduct.put("charset", "utf-8");
		headerProduct.put("Referer", referer);
		headerProduct.put("content-type", "application/x-www-form-urlencoded");
		headerProduct.put("uuid", "1051715836206878780");
		headerProduct.put("Host", "wx.waimai.meituan.com");
		headerProduct.put("User-Agent","Mozilla/5.0 (Linux; Android 6.0.1; Redmi 4A Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044403 Mobile Safari/537.36 MicroMessenger/6.6.7.1321(0x26060736) NetType/WIFI Language/zh_CN MicroMessenger/6.6.7.1321(0x26060736) NetType/WIFI Language/zh_CN");
		String url = "https://wx.waimai.meituan.com/weapp/v1/poi/food?ui=919823055&region_id=1000310100&region_version=1544523034281";
		Map<String, String> data = new HashMap<String, String>();
		String[] s = dataStr.split("&");
		for(int i = 0;i < s.length;i ++){
			data.put(s[i].split("=")[0], s[i].split("=")[1]);
		}
		try {
			String html = HttpBase.post(url, headerProduct, data);
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
