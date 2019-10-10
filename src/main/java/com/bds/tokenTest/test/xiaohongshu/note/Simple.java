package com.bds.tokenTest.test.xiaohongshu.note;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bds.base.http.HttpBase;

public class Simple {
	public static void main(String[] args) throws Exception {
		String keyword = "粉水清滢柔肤水  · 女神节礼物 粉水清滢柔肤水  200ml";//雅诗兰黛 Estee Lauder 属于小棕瓶的神话  · 女神节礼物 特润修护肌透精华液  50ml 第六代
		int page = 1;
//		String search_id = jo.getString("search_id");
////		search_id = "C8BE5D4E255A4E2E1AC6C559A75C1F65";
//		String time = jo.getString("time");
////		time = "1551072934";
//		String sign = jo.getString("sign");
////		sign = "b3b2ed3016cabdef4060ceeca2b0a7b3";
//		
//		String shield = jo.getString("shield");
////		shield = "61483df7cb9bbf6a4a7281058965fbe64ccc26d5cd4395f5f9eb969847039985";
//		
////		String url = "https://www.xiaohongshu.com/api/sns/v9/search/notes?keyword="+URLEncoder.encode(keyword, "utf-8")
////				+ "&filters=&sort="
////				+ "&page="+page+"&page_size=20"
////				+ "&source=explore_feed"
////				+ "&search_id="+search_id
////				+ "&api_extra=&platform=android"
////				+ "&deviceId=ad038991-1078-3b40-842d-389b0d6ab5a6"
////				+ "&device_fingerprint=2019021318032049b973f3e0510d3621ea02c29d13117001a9cb7cd7d4f6ac"
////				+ "&device_fingerprint1=2019021318032049b973f3e0510d3621ea02c29d13117001a9cb7cd7d4f6ac"
////				+ "&versionName=5.39.1&channel=Store360"
////				+ "&sid=session.1550052198553742928"
////				+ "&lang=zh-Hans"
////				+ "&t="+time
////				+ "&sign="+sign;
//		String url = "https://www.xiaohongshu.com/api/sns/v9/search/notes?keyword="+URLEncoder.encode(keyword, "utf-8")
//				+ "&filters=&sort="+sort
//				+ "&page="+page
//				+ "&page_size=20&source=explore_feed"
//				+ "&search_id="+search_id
//				+ "&api_extra=&platform=android"
//				+ "&deviceId=ad038991-1078-3b40-842d-389b0d6ab5a6"
//				+ "&device_fingerprint=2019021318032049b973f3e0510d3621ea02c29d13117001a9cb7cd7d4f6ac"
//				+ "&device_fingerprint1=2019021318032049b973f3e0510d3621ea02c29d13117001a9cb7cd7d4f6ac&versionName=5.39.1"
//				+ "&channel=Store360&sid=session.1550052198553742928&lang=zh-Hans"
//				+ "&t="+time
//				+ "&sign="+sign;
//		Map<String, String> headers = new HashMap<>();
//		headers.put("Host", "www.xiaohongshu.com");
//		headers.put("shield", "3c58bc08d33d9ae65f3c43b05d3bf718686e418edde326462f7cb4f850707924");
//		headers.put("device_id", "31748f62-7b7d-33f7-84d6-9b8959e393fa");
//		headers.put("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4.2; HUAWEI MLA-AL10 Build/HUAWEIMLA-AL10) Resolution/720*1280 Version/5.39.1 Build/5391017 Device/(HUAWEI ;HUAWEI MLA-AL10) NetType/WiFi");
//		headers.put("Authorization", "session.1551153484940003692");
//		headers.put("X-Tingyun-Id", "LbxHzUNcfig;c=2;r=1244939994;u=9acbb2b98e79c1b82db2919207a1479fa1c4d99bf66a926a49bf27e7a036a3dd7124097176454ad9b8338d4a8f844f8c::6A10FBA68B7524AE");
		
		String html = getSimpleJson(page, keyword);
		com.alibaba.fastjson.JSONObject json = JSON.parseObject(html);
		com.alibaba.fastjson.JSONObject data = json.getJSONObject("data");
		int totalCount = data.getIntValue("total_count");
		int pageCount = totalCount /20 + 1;
		for(int i = page;i<pageCount;i++){
			System.out.println("page="+i);
			html = getSimpleJson(i, keyword);
			parse(html);
		}
	}
	
	public static void parse(String html){
		
		com.alibaba.fastjson.JSONObject json = JSON.parseObject(html);
		com.alibaba.fastjson.JSONObject data = json.getJSONObject("data");
		JSONArray notes = data.getJSONArray("notes");
		for (Object object : notes) {
			com.alibaba.fastjson.JSONObject note = JSON.parseObject(object.toString());
			String noteId = note.getString("id");
			String title = note.getString("title");
			String desc = note.getString("desc");
			String likedCount = note.getString("liked_count");
			JSONArray imageList = note.getJSONArray("images_list");
			String images = "";
			for (int i = 0 ; i<imageList.size();i++) {
				images += imageList.getJSONObject(i).getString("url");
				if(i<imageList.size()-1){
					images += ",";
				}
			}
			System.out.println(desc+"....."+images);
		}
	}
	
	public static String getSimpleJson(int page,String keyword) throws Exception{
		//默认综合，sort=popularity_descending最热
		String result = HttpBase.get("http://127.0.0.1:8890/header?sort=&page="+page+"&keyword="+URLEncoder.encode(keyword,"utf-8")+"&type=simple", "utf-8").getResult();
		JSONObject jo = new JSONObject(result);
		
		Map<String,String> map = new HashMap<String, String>();
		String url = jo.getString("url");
		JSONObject header = new JSONObject(jo.getString("header"));
		Iterator<String> it = header.keys();
		while(it.hasNext()){
			String key = it.next();
			map.put(key, header.getString(key));
		}
		String html = HttpBase.get(url,"utf-8", map).getResult();
		System.out.println(html);
		return html;
	}
	
	public static String doGet(String url,Map<String,String> headers) throws Exception{
        URL localUrl = new URL(url);
        URLConnection connection = localUrl.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
        
        if(headers != null){
        	for(String key:headers.keySet()){
        		httpURLConnection.setRequestProperty(key, headers.get(key));
        	}
        }
        
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;

        if(httpURLConnection.getResponseCode() >=300){
            throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
        }

        try{
            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream,"utf-8");
            reader = new BufferedReader(inputStreamReader);

            while((tempLine = reader.readLine()) != null){
                resultBuffer.append(tempLine);
            }
        }finally {
            if(reader != null){
                reader.close();
            }
            if(inputStreamReader != null){
                inputStreamReader.close();
            }
            if(inputStream != null){
                inputStream.close();
            }
        }

        return resultBuffer.toString();
    }
}
