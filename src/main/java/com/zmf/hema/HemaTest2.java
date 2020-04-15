package com.zmf.hema;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class HemaTest2 {
	public static void main(String[] args) {
		JSONObject json = JSON.parseObject("");
		JSONArray scenes = json.getJSONObject("data").getJSONArray("scenes");
		if (scenes == null) {
			return;
		}
		for (int i = 0; i < scenes.size(); i++) {
			JSONArray contents = scenes.getJSONObject(i).getJSONArray("content");
			if(contents==null) {
				return;
			}
			for (int j = 0; j < contents.size(); j++) {
				JSONArray resources = contents.getJSONObject(i).getJSONArray("resources");
				if(resources==null) {
					return;
				}
				for (int k = 0; k < resources.size(); k++) {	
					
				}
			}
		}
	}
	public void test() {}
}
