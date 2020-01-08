package com.bds.tokenTest.test;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class TestJson {
	public static void main(String[] args) throws JSONException {
//		String s = "{data:false}";
//		org.json.JSONObject jo= new JSONObject(s);
//		boolean b= jo.getBoolean("data2");
//		System.out.println(b);
		
		String s2 = "{data:\"\"}";
		com.alibaba.fastjson.JSONObject alijson = JSON.parseObject(s2);
		com.alibaba.fastjson.JSONObject arr = alijson.getJSONObject("data");
		System.out.println(arr);
		List<?> list= new ArrayList<>();
		System.out.println(list);
		
//		com.alibaba.fastjson.JSONObject jo2 = JSON.parseObject(s);
//		boolean b2  = jo2.getBoolean("data2");
//		System.out.println(b2);
		
		
//		JSONObject js = new JSONObject();
//		String a = null;
//		js.put("a", a);
//		System.out.println(js.toString());
		
		JSONArray ja = JSON.parseArray("");
		ja.get(0).toString().concat("参数错误");
	}
}
