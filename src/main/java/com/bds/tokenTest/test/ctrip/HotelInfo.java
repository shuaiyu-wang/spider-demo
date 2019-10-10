package com.bds.tokenTest.test.ctrip;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.bds.base.http.HttpBase;
import com.bds.tokenTest.util.Util;

public class HotelInfo {

	public static void main(String[] args) throws Exception {
		String hotel_url = "http://hotels.ctrip.com/hotel/345002.html";
		Map<String , String> header = new HashMap<String, String>();
		header.put("Host", "hotels.ctrip.com");
		header.put("Upgrade-Insecure-Requests", "1");
		header.put("Content-Type", "application/x-www-form-urlencoded");
		header.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
		header.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		header.put("Accept-Language", "zh-CN,zh;q=0.9");
		String html = HttpBase.get(hotel_url, "utf-8", header).getResult();
//		System.out.println(html);
		parse(html);
	}
	public static void parse(String html){
		Document doc = Jsoup.parse(html);
		Elements tagEms = doc.select("div.grade>div.special_label>i");
		String tags = "";
		for(int i = 0;i<tagEms.size();i++){
			tags += tagEms.get(i).text();
			if(i < tagEms.size()-1){
				tags += ",";
			}
		}
		System.out.println(tags.replace(" ", ""));
		String name_en = doc.select("h2.en_n").text();
		System.out.println(name_en);
		String info = doc.select("div#htlDes").text();
		String decoration = "";
		String openTime = "";
		String rooms = "";
		if(info.contains("年开业")){
			openTime = Util.parseNumberBefore(info, "年开业");
		}
		System.out.println(openTime);
		if(info.contains("间房")){
			rooms = Util.parseNumberBefore(info, "间房");
		}
		System.out.println(rooms);
		if(info.contains("年装修")){
			decoration = Util.parseNumberBefore(info, "年装修");
		}
		System.out.println(decoration);
	}
}
