package com.zmf.hema;

import java.util.HashMap;
import java.util.Map;

import com.bds.tokenTest.util.Util;

public class HemaTest {

	public static void main(String[] args) throws Exception {
		String url = "https://acs.m.taobao.com/gw/mtop.wdk.search.item/2.0/?data=%7B%22poi%22%3A%22121.386556%2C31.271434%22%2C%22storeIds%22%3A%22160039352%2C232747349%2C234340026%2C239693037%2C190417236%22%2C%22pageParam%22%3A%22%7B%5C%22pageSize%5C%22%3A30%2C%5C%22index%5C%22%3A0%7D%22%2C%22order%22%3A%22%22%2C%22keyword%22%3A%22%E7%94%B5%E5%AD%90%E5%8D%A1%22%2C%22searchType%22%3A%22mainSearch%22%2C%22isConfirm%22%3A%22false%22%2C%22needCatTree%22%3A%22true%22%2C%22extParam%22%3A%22%7B%5C%22trackParamContext%5C%22%3A%7B%5C%22isFromCenter%5C%22%3A%5C%220%5C%22%7D%2C%5C%22st%5C%22%3A%7B%5C%22fromType%5C%22%3A%5C%22search_box%5C%22%7D%7D%22%2C%22clientType%22%3A%22hema%22%7D";
		String headers = "content-type=application/x-www-form-urlencoded;charset=UTF-8, x-umt=h7tLhGJLOpZLCzVwQ6pMjsB6qbpAgc5F, x-app-conf-v=0, x-features=27, x-nettype=WIFI, x-utdid=XkZ6w1upoBADAKlhF0DBJiXS, user-agent=MTOPSDK%2F3.0.4.7+%28Android%3B4.4.2%3BOPPO%3BOPPO+R17%29, x-nq=WIFI, x-pv=5.1, x-mini-wua=HHnB_MCZdl36QoNBMQlBkANVpPla54KIUdXX%2BghK1vwA17L4CKUbjTqVe%2F%2Bg904nKSfS5VZtSNPyZeTC0zut2QViu9U4%2BakEWziAT6zW7%2FdkZMNlb2i3LQsWyov2Vw0E3BPh7, cache-control=no-cache, x-devid=Avbc3VhOw-46Ya40Vm7JChmBVfdWWi6nVQWNHRhpMf4B, x-c-traceid=XkZ6w1upoBADAKlhF0DBJiXS1581686215860004011115, x-appkey=23228014, x-shopid=, x-t=1581686216, x-app-ver=4.10.0, x-ttid=700145%40hmxs_android_4.10.0, x-page-url=com.wudaokou.hippo.search.SearchResultActivity, x-sign=ab22910090bc67c49138e4f5127557fcecd30d5c05bb0a98df, f-refer=mtop";
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
