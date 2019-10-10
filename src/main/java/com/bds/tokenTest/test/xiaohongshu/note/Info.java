package com.bds.tokenTest.test.xiaohongshu.note;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bds.base.http.HttpBase;
import com.bds.tokenTest.test.httpclient.Http;

public class Info {
	public static void main(String[] args) throws Exception {
		int page = 1;
		String keyword = "面膜";
//		keyword = "春季流行色";
		String noteId = "5c14b934000000000a01a162";
//		noteId = "5c6bb307000000000e036f5e";
		while(true){
			String result = HttpBase.get("http://127.0.0.1:8890/header?type=info&page="+page+"&keyword="+URLEncoder.encode(keyword, "utf-8")+"&noteId="+noteId, "utf-8").getResult();
			JSONObject jo = new JSONObject(result);
			
			Map<String,String> map = new HashMap<String, String>();
			String url = jo.getString("url");
			System.out.println(url);
			JSONObject header = new JSONObject(jo.getString("header"));
			Iterator<String> it = header.keys();
			while(it.hasNext()){
				String key = it.next();
				map.put(key, header.getString(key));
			}
			String html = HttpBase.get(url, "utf-8", map).getResult();
			System.out.println(html);
			parse(html);
			if(page++ > 50){
				break;
			}
		}
		
	}
	
	public static void parse(String html){
		com.alibaba.fastjson.JSONObject json = JSON.parseObject(html);
		JSONArray data = json.getJSONArray("data");
		for (Object object : data) {
			com.alibaba.fastjson.JSONObject obj = JSON.parseObject(object.toString());
			JSONArray noteList = obj.getJSONArray("note_list");
			for (Object object2 : noteList) {
				com.alibaba.fastjson.JSONObject note = JSON.parseObject(object2.toString());
				String nodeId = note.getString("id");
				String title = note.getString("title");
				String desc = note.getString("desc");
				long time = note.getLong("time");
				Date noteDate = new Date(time*1000);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String noteTime = sdf.format(noteDate);
				String topicsJson = note.getString("topics");
				JSONArray images = note.getJSONArray("images_list");
				String imageUrl = "";
				for (int i = 0;i<images.size();i++) {
					com.alibaba.fastjson.JSONObject image = images.getJSONObject(i);
					imageUrl += image.getString("url");
					if(i < images.size()-1){
						imageUrl += ",";
					}
				}
//				System.out.println(imageUrl);
				String likedCount = note.getString("liked_count");
				String collectedCount = note.getString("collected_count");
				String commentsCount = note.getString("comments_count");
				String sharedCount = note.getString("shared_count");
			}
			
		}
	}
	
}
