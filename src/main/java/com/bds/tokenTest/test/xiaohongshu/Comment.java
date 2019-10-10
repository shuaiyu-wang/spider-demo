package com.bds.tokenTest.test.xiaohongshu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.bds.base.http.HttpBase;

public class Comment {
	
	public static void main(String[] args) throws Exception {
		
		String noteId = "5c14b934000000000a01a162";
//		noteId = "5b6b177a910cf638c7b981fe";
		String startId = "";
		int i = 2;
		do{
			String result = HttpBase.get("http://127.0.0.1:8889/sign?type=comment&startId="+startId+"&noteId="+noteId, "utf-8").getResult();
			JSONObject jo = new JSONObject(result);
			
//			String deviceId = jo.getString("deviceId");
//			String fingerprint = jo.getString("fingerprint");
//			String sid = jo.getString("sid");
//			String time = jo.getString("time");
//	//		time = "1550729953";
//			//36f36d36442b355f4612d81add6b31cb
//			String sign = jo.getString("sign");
//			//a582441db5ed46d164fb66ff336cb524febc7e0c17f94239304e4adea184b2db
//			String shield = jo.getString("shield");
//			String start = "";
//			if(i == 1){
//				start = "start="+startId+"&";
//			}
//			
//			String url = "https://www.xiaohongshu.com/api/sns/v5/note/"+noteId+"/comment/list?"+start
//					+ "num=20"
//					+ "&show_priority_sub_comments=0"
//					+ "&platform=android"
//					+ "&deviceId="+deviceId
//					+ "&device_fingerprint="+fingerprint
//					+ "&device_fingerprint1="+fingerprint
//					+ "&versionName=5.39.1"
//					+ "&channel=Store360"
//					+ "&sid=session."+sid
//					+ "&lang=zh-Hans"
//					+ "&t="+time
//					+ "&sign="+sign;
//			
//			Map<String, String> headers = new HashMap<>();
//			headers.put("Host", "www.xiaohongshu.com");
//			headers.put("shield", shield);
//			headers.put("device_id", deviceId);
//			headers.put("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4.2; HUAWEI MLA-AL10 Build/HUAWEIMLA-AL10) Resolution/720*1280 Version/5.39.1 Build/5391017 Device/(HUAWEI ;HUAWEI MLA-AL10) NetType/WiFi");
//			headers.put("Authorization", "session."+sid);
//			headers.put("X-Tingyun-Id", "LbxHzUNcfig;c=2;r=1244939994;u=9acbb2b98e79c1b82db2919207a1479fa1c4d99bf66a926a49bf27e7a036a3dd7124097176454ad9b8338d4a8f844f8c::6A10FBA68B7524AE");
			
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
			
			parse(html);
			
			JSONObject jobj = new JSONObject(html);
			JSONObject data = jobj.getJSONObject("data");
			JSONArray comment = data.getJSONArray("comments");
			startId = comment.getJSONObject(comment.length()-1).getString("id");
			i--;
		}while(i>0);
	}
	
	public static void parse(String html){
		com.alibaba.fastjson.JSONObject json = JSON.parseObject(html);
		com.alibaba.fastjson.JSONObject data = json.getJSONObject("data");
		com.alibaba.fastjson.JSONArray comments = data.getJSONArray("comments");
		for (Object object : comments) {
			com.alibaba.fastjson.JSONObject comment = JSON.parseObject(object.toString());
			String commentId = comment.getString("id");
			String content = comment.getString("content");
			String likeCount = comment.getString("like_count");
			String noteId = comment.getString("note_id");
			String commentCount = comment.getString("sub_comment_count");
			long time = comment.getLong("time");
			String commentTime = parseTime(time);
			com.alibaba.fastjson.JSONArray subComments = comment.getJSONArray("sub_comments");
			for (Object object2 : subComments) {
				com.alibaba.fastjson.JSONObject subComment = JSON.parseObject(object2.toString());
				String replyId = subComment.getString("id");
				String replyContent = subComment.getString("content");
				String replyLikeCount = subComment.getString("like_count");
				noteId = subComment.getString("note_id");
				long replyTime = subComment.getLong("time");
				String rTime = parseTime(replyTime);
			}
		}
	}
	
	public static String parseTime(long time){
		Date date = new Date(time*1000);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String commentTime = sdf.format(date);
		return commentTime;
	}
	

}
