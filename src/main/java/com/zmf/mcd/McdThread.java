package com.zmf.mcd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

import org.json.JSONArray;
import org.json.JSONObject;

import com.bds.base.http.HttpBase;
import com.bds.base.http.HttpsBase;

public class McdThread {

	public static void main(String[] args) {
		try {
			String url_two = "https://mcddel.sandload.cn/GetPackageDish?StoreId=1450047&dishId=123470498&dishType=5&timeStamp="
					+ getTime();
			String result = HttpBase.get(url_two, "utf-8", getHeaderTwo()).getResult();
			JSONObject json = new JSONObject(result);
//			System.out.println(json);
			if (json.getInt("msgCode") == 100 && json.getJSONObject("data") != null) {
				JSONObject packageDish = json.getJSONObject("data").getJSONObject("packageDishVo");
				String price_lowest = packageDish.getString("price");
				String productName = packageDish.getString("name");
				String pid = packageDish.getString("id");

				JSONArray groupList = packageDish.getJSONArray("groupList");
				System.out.println(groupList);
				Stack<List<JSONObject>> stack = new Stack<List<JSONObject>>();
				for (int i = 0; i < groupList.length(); i++) {
					JSONObject groupD = groupList.getJSONObject(i);
					List<JSONObject> list = new ArrayList<JSONObject>();
					JSONArray groupDetail = groupD.getJSONArray("groupDeatil");
					// 去掉中间为空的
					if (groupDetail.length() == 0) {
						continue;
					}
					for (int j = 0; j < groupDetail.length(); j++) {
						list.add(groupDetail.getJSONObject(j));
					}
					stack.push(list);
//					System.out.println("====="+list);
//					System.out.println("===***"+stack.size());

				}
				List<JSONObject> newlist = null;
				if (stack.size() == 1) {
					System.out.println(stack.pop());
					return;
				}
				while (stack.size() >= 2) {
					newlist = new ArrayList<JSONObject>();
					List<JSONObject> list1 = stack.pop();
					List<JSONObject> list2 = stack.pop();
					for (int i = 0; i < list1.size(); i++) {
						for (int j = 0; j < list2.size(); j++) {
							JSONObject joo = new JSONObject();
							joo.put("name", list1.get(i).getString("name") + "," + list2.get(j).getString("name"));
							joo.put("price", list1.get(i).getString("price") + list2.get(j).getString("price"));
							newlist.add(joo);
						}
					}
					stack.push(newlist);
				}
				System.out.println("/****" + newlist);
				System.out.println("/****" + newlist.size());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static long getTime() {
		return System.currentTimeMillis();
	}

	public synchronized static String replaceCharRandomly(String str) {
		StringBuffer result = new StringBuffer();
		char[] cs = str.toCharArray();
		Random random = new Random();
		int num = 0;
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] >= 48 && cs[i] <= 57) {
				// 数字
				// 第一位数字不为0
				int ran = random.nextInt(10);
				if (num == 0) {
					if (ran == 0) {
						ran += 1;
					}
				}
				result.append(ran);
			} else if (cs[i] >= 65 && cs[i] <= 90) {
				// 大写字母
				result.append((char) (65 + random.nextInt(26)));
			} else if (cs[i] >= 97 && cs[i] <= 122) {
				// 小写字母
				result.append((char) (97 + random.nextInt(26)));
			} else {
				// 特殊符号返回本身
				result.append(cs[i]);
			}
		}
		return result.toString();
	}

	public static Map<String, String> getHeaderTwo() {
		Map<String, String> header = new HashMap<String, String>();
		header.put("charset", "utf-8");
		header.put("Accept-Encoding", "gzip");
		header.put("referer", "https://servicewechat.com/wx5b7e52da9b9c8ade/41/page-frame.html");
		header.put("channel", "delivery");
		header.put("pi", "F8538588-C692-4958-A591-A4C71D976209");
		header.put("content-type", "application/json");
		header.put("User-Agent",
				"Mozilla/5.0 (Linux; Android 6.0.1; Redmi 4A Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/67.0.3396.87 XWEB/992 MMWEBSDK/21 Mobile Safari/537.36 MicroMessenger/6.6.7.1321(0x26060736) NetType/WIFI Language/zh_CN MicroMessenger/6.6.7.1321(0x26060736) NetType/WIFI Language/zh_CN");
		header.put("Host", "mcddel.sandload.cn");
		header.put("Connection", "Keep-Alive");
		return header;
	}
}
