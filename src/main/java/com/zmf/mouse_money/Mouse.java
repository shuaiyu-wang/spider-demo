package com.zmf.mouse_money;

import java.util.Random;

import com.alibaba.fastjson.JSONArray;

public class Mouse {

	public static void main(String[] args)throws Exception{
		Random r = new Random();
		String s = "";
		while(true) {
			String url = "https://www.icbc.com.cn/ICBC/ICBCCOIN/coinBookData_Cache.js?"+r.nextInt(10000);
			
			String html = org.nutz.http.Http.get(url).getContent("GBK");
			html = html.replace("var bookArray_Cache =", "").replace(";", "");
			//FileUtils.write(new File("e:\\icbc.txt"), html, "utf-8");
			JSONArray list = JSONArray.parseArray(html);
			JSONArray as_23 = list.getJSONArray(0);
			JSONArray as_24 = list.getJSONArray(1);
			String ss = list(as_23,"23")+list(as_24,"24");
			if(!s.equals(ss)) {
				System.out.println(ss);
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				s = ss;
			}
			Thread.sleep(500);
		}
	}
	
	
	public static String list(JSONArray as_23,String c) {
		JSONArray zhi = as_23.getJSONArray(1).getJSONArray(3).getJSONArray(6);
		int size = zhi.size();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<size;i++) {
			JSONArray s = zhi.getJSONArray(i);
			String zh = s.getString(0);
			//System.out.println(">>>>>>>"+zh);
			JSONArray fh = s.getJSONArray(6);
			int ss = fh.size();
			for(int a=0;a<ss;a++) {
				JSONArray fhd = fh.getJSONArray(a);
				String name = fhd.getString(0);
				int count = fhd.getInteger(4);
				String code = fhd.getString(7);
				if(count > 0) {
					sb.append(zh+">>>"+name+">>>"+count+">>>>>>"+code+"\n");
					String u = "https://jnb.icbc.com.cn/ICBCCOIN/outer/iepa_area04/pages/coinorder?brzo="+code+"&cointype="+c;
					//HttpBase.getFirefoxDriver().get(u);
					//System.out.println(u);
					sb.append(u+"\n");
				}
			}
		}
		return sb.toString();
	}
	
}
