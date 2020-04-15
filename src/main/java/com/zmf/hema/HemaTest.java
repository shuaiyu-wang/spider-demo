package com.zmf.hema;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.bds.tokenTest.util.Util;

public class HemaTest {

	public static void main(String[] args) throws Exception {
		String page = "0";
		String keyword = "苹果";
		String lonLat = "116.410679,39.916502";
		String appKey = "23228014";
		String time = "1582016868";
		String sign = "ab22910090860021d9811df252753368443bfeb586cdbd7686";
		String s = "{\"order\":\"\",\"clientType\":\"hema\",\"needCatTree\":\"true\",\"isConfirm\":\"false\","
				+ "\"keyword\":\""+keyword+"\","
				+ "\"storeIds\":\"202554127,185016050,232747349,234340026,239693037,190417236\","
				+ "\"poi\":\""+lonLat+"\",\"searchType\":\"mainSearch\",\"extParam\":\"{\\\"st\\\":{\\\"fromType\\\":\\\"historyKeyWord\\\",\\\"wordType\\\":\\\"history\\\",\\\"position\\\":1,\\\"keyWordRn\\\":\\\"18f6ea63b14e41a387639e7af22e22cc\\\"},\\\"trackParamContext\\\":{\\\"isFromCenter\\\":\\\"0\\\"},\\\"searchFrom\\\":{\\\"from\\\":\\\"homepage\\\"}}\","
				+ "\"pageParam\":\"{\\\"index\\\":"+page+",\\\"pageSize\\\":30}\"}";
		String url = "https://acs.m.taobao.com/gw/mtop.wdk.search.item/2.0/?data="
				+ URLEncoder.encode(s,"utf-8");
		String headers = "content-type=application/x-www-form-urlencoded;charset=UTF-8, "
				+ "x-umt=YK9LKu9LOkygTDVwUVUyDeqC0tCyq67Y, "
				+ "x-app-conf-v=0, "
				+ "x-features=27, "
				+ "x-nettype=WIFI, "
				+ "x-utdid=Xkov2%2FurrhcDABz%2Bi1k6R0oC, "
				+ "user-agent=MTOPSDK%2F3.0.4.7+%28Android%3B5.1.1%3BHUAWEI%3BVOG-AL00%29, "
				+ "x-nq=WIFI, "
				+ "x-pv=5.1, "
				+ "x-mini-wua=HHnB_mxdZr5n%2FE9%2Bmpy1TIstRUm0%2FW2GJBWJkdPxb4dk7SRKEPG8a2U7G2%2FzyDpJNOkri91NfQ2rJ8BcVe1iqBVhm1hzSSmSH1wmXfto8Jhni3FuNUJ0QEwx16FdQKqQXtxmC, "
				+ "x-devid=Av2DpLwLXOXiuVsTBMwqgk5DukQbkgbDEbXUjiSJIRzT, "
				+ "x-c-traceid=Xkov2%2FurrhcDABz%2Bi1k6R0oC1581930853859001512245, "
				+ "x-appkey="+appKey+", "
				+ "x-shopid=202554127, "
				+ "x-t="+time+", "
				+ "x-app-ver=4.20.0, "
				+ "x-ttid=10004819%40hmxs_android_4.20.0, "
				+ "x-page-url=com.wudaokou.hippo.search.SearchResultActivity, "
				+ "x-sign="+sign+", "
				+ "f-refer=mtop";
		String[] ss = headers.split(", ");
		Map<String, String> map = new HashMap<String, String>();
		for (String str : ss) {
			System.out.println(str);
			if(str.split("=").length==1) {
				map.put(str.split("=")[0], "");
				continue;
			}
			map.put(str.split("=")[0], str.split("=")[1]);
		}
		String result = Util.doGet(url, map);
		System.out.println(result);
	}
}
