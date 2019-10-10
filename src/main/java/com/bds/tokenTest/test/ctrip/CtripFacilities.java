package com.bds.tokenTest.test.ctrip;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bds.base.http.HttpBase;
import com.bds.tokenTest.model.FacilitiesModel;

public class CtripFacilities {
	public static void main(String[] args) throws Exception {
		String key = "595d2781f17c5b2eec92f0be4b88faa1";
		//type	购物中心060101		地铁站150500
		String url = "https://restapi.amap.com/v3/place/around?key="+key+"&location=116.473168,39.993015&keywords=&types=150700&radius=3000&offset=20&page=1&extensions=all";
		String html = HttpBase.get(url, "utf-8").getResult();
		JSONObject jo = JSON.parseObject(html);
		
		int count = jo.getIntValue("count");
		System.out.println(count);
		
		int page = (count - 1) / 20 + 1;
		
		int c = 0;
		
		for(int i = 1;i <= page;i ++){
			url = "https://restapi.amap.com/v3/place/around?key="+key+"&location=116.473168,39.993015&keywords=&types=150700&radius=3000&offset=20&page="+i+"&extensions=all";
			html = HttpBase.get(url, "utf-8").getResult();
			jo = JSON.parseObject(html);
			JSONArray ja = jo.getJSONArray("pois");
			for (int j = 0; j < ja.size(); j++) {
				c ++;
				JSONObject poi = ja.getJSONObject(j); 
				String pois_id = poi.getString("id");
				String name = poi.getString("name");
				String type = poi.getString("type");
				String typecode = poi.getString("typecode");
				String address = poi.getString("address");
				String location = poi.getString("location");
				String pcode = poi.getString("pcode");
				String pname = poi.getString("pname");
				String citycode = poi.getString("citycode");
				String cityname = poi.getString("cityname");
				String adcode = poi.getString("adcode");
				String adname = poi.getString("adname");
				String shopinfo = poi.getString("shopinfo");
				String gridcode = poi.getString("gridcode");
				String distance = poi.getString("distance");
				String business_area = poi.getString("business_area");
				FacilitiesModel fm = new FacilitiesModel();
				fm.setAdcode(adcode);
				fm.setAddress(address);
				fm.setAdname(adname);
				fm.setBusiness_area(business_area);
				fm.setCitycode(citycode);
				fm.setCityname(cityname);
				fm.setDistance(distance);
				fm.setGridcode(gridcode);
				fm.setLocation(location);
				fm.setName(name);
				fm.setPcode(pcode);
				fm.setPname(pname);
				fm.setPois_id(pois_id);
				fm.setShopinfo(shopinfo);
				fm.setType(type);
				fm.setTypecode(typecode);
				System.out.println(c+"--->>>"+fm);
			}
		}
	}
}
