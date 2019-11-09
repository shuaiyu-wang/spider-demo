package com.zmf.mcd;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 麦当劳定制套餐排列组合问题（例如：某套餐里有鸡翅，可乐，汉堡，每样又有大中小可选，求所有组合）
 * 
 * @author wsy
 *
 */
public class McdTest {
	public static void main(String[] args) {
		String s = "{'groupList':[" + "{'groupDetail':[]},"
				+ "{'groupDetail':[{'str':'b','price':0},{'str':'c','price':1}]},"
//				+ "{'groupDetail':[{'str':'d','price':1},{'str':'e','price':2},{'str':'f','price':1}]},"
//				+ "{'groupDetail':[{'str':'g','price':2},{'str':'h','price':1},{'str':'i','price':1},{'str':'k','price':1}]},"
//				+ "{'groupDetail':[{'str':'l','price':1},{'str':'m','price':0}]}"
				+ "]}";
		JSONObject jo = JSON.parseObject(s);
		JSONArray groupList = jo.getJSONArray("groupList");
		System.out.println(groupList);
		Stack<List<JSONObject>> stack = new Stack<List<JSONObject>>();
		for (int i = 0; i < groupList.size(); i++) {
			JSONObject groupDetail = groupList.getJSONObject(i);
//			System.out.println(groupDetail);
			List<JSONObject> list = new ArrayList<JSONObject>();
			// 去掉中间为空的
			if (groupDetail.getJSONArray("groupDetail").size() == 0) {
				continue;
			}
			for (int j = 0; j < groupDetail.getJSONArray("groupDetail").size(); j++) {
//				System.out.println(groupDetail.getJSONArray("groupDetail").get(j));
				list.add(groupDetail.getJSONArray("groupDetail").getJSONObject(j));
			}
//			System.out.println("---"+list);
			stack.push(list);
//			stack.push(groupList.getJSONArray(i));
		}
//		System.out.println(stack.pop());//def
//		System.out.println(stack.pop());//bc
//		System.out.println(stack.pop());//a
//		System.out.println(stack.peek());
		List<JSONObject> newlist = null;
		if (stack.size() == 1) {
			System.out.println(stack.pop());
			return;
		}
		while (stack.size() >= 2) {
			newlist = new ArrayList<JSONObject>();
			List<JSONObject> list1 = stack.pop();
//			 System.out.println(list1);
			List<JSONObject> list2 = stack.pop();
//			 System.out.println(list2);
			for (int i = 0; i < list1.size(); i++) {
				for (int j = 0; j < list2.size(); j++) {
//            		 System.out.println(list1.get(i));
					JSONObject joo = new JSONObject();
					joo.put("str", list1.get(i).getString("str") + "," + list2.get(j).getString("str"));
					joo.put("price", list1.get(i).getDouble("price") + list2.get(j).getDouble("price"));
					newlist.add(joo);
				}
			}
//             newlist.add(jaa);
			stack.push(newlist);
		}
		System.out.println(newlist);
	}
}
