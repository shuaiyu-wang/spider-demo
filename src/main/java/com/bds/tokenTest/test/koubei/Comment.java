package com.bds.tokenTest.test.koubei;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.bds.base.http.HttpBase;
import com.bds.tokenTest.util.Util;

public class Comment {
	public static void main(String[] args) throws Exception {
		String spanner = Util.replaceCharRandomly("gqUJ1i9ewPBpraYdVqmOINTluWOunbJX4EJoL7C0n0A=");
		String zone = Util.replaceCharRandomly("RZ11B");
		String data = "[{\"hasShowNumber\":0,\"objectId\":\"2016012200077000000014429603\",\"objectType\":\"SHOP\",\"option\":[\"DIGEST\",\"TAG\",\"VOUCHER\",\"CRAFTSMAN\",\"ITEM_INFO\"],\"tagId\":\"\"}]";
		data = URLEncoder.encode(data, "utf-8");
		String url = "https://mobilegw.alipay.com/mgw.htm?operationType=alipay.kbcomment.comment.commentListExternal&requestData="+data
				+ "&disableLimitView=true&callback=kobe_callback_0";
		Map<String, String> header = new HashMap<String, String>();
		header.put("Host", "mobilegw.alipay.com");
		header.put("Accept", "*/*");
		header.put("Cookie", "zone="+zone+"; spanner="+spanner);
		header.put("User-Agent", "iPhone10,1(iOS/12.1.1) AliApp(TB/8.4.0) Weex/0.20.0 750x1334");
		header.put("Accept-Language", "zh-cn");
		String html = HttpBase.get(url, "utf-8", header).getResult();
		System.out.println(html);
	}
	
}
