package com.bds.tokenTest.test.ctrip;

import java.net.ConnectException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang.StringUtils;

import com.bds.base.http.HttpBase;

public class CtripTest02 {
	public static void main(String[] args) throws Exception {
		Map<String,String> headers = new HashMap<String,String>();
    	String n = e(15);
		String url = "http://hotels.ctrip.com/domestic/cas/oceanball?callback=" + n + "&_=" + new Date().getTime();
		headers.put("Host", "hotels.ctrip.com");
		headers.put("Referer", "http://hotels.ctrip.com/hotel/"+"4984476"+".html");
		headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
    	String result = HttpBase.get(url,"utf-8", headers).getResult();
    	int begin = result.indexOf("(")+1;
		int end = result.lastIndexOf(")");
		result = result.substring(begin, end);
		String js = result.replace(n, "callback");
		String callback = n;
		String curl = "http://211.152.47.69:9999/ctrip_token";
		//String eleven = HttpBase.get(curl,"UTF-8",new HashMap<String,String>()).getResult();
		Map<String,String> header = new HashMap<String,String>();
		header.put("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
		header.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
		header.put("Accept-Language", "zh-CN,en-US;q=0.8");
		Map<String,String> params = new HashMap<String,String>();
		params.put("id","4984476");
		params.put("callback",callback);
		params.put("js",js);
		String eleven = HttpBase.post(curl, header, params);
		if(StringUtils.isEmpty(eleven) || eleven.length() != 64 || eleven.contains("`")) {
			return;
		}
		CtripTest.getCtripHtml(4984476+"", "2018-09-30", "2018-10-01", eleven);
	}
	
	public static String e(int e) {
		String t[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		String o = "CAS";
		java.util.Random r = new Random();
		for(int n=0;n<e;n++) {
			int i = r.nextInt(51);
			o += t[i];
		}
		return o;
	}
}
