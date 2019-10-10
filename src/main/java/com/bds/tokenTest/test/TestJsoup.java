package com.bds.tokenTest.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TestJsoup {
	public static void main(String[] args) {
		String html = "<p>One <span>Two</span> Three <br> Four</p>";
		Document doc = Jsoup.parse(html);
		Element eles = doc.select("p").first();
		int size = eles.textNodes().size();
		String str = Jsoup.parse(html).html();
//		System.out.println(str);
		System.out.println(size);
		
		String ss = "<p>"
				+ "<span class=\"room_type_name\">(寻味礼遇)</span>"
				+ "<span data-role=\"jmp\" data-params=\"{'options':{'type':'jmp_table','template':'#jmpTempGift','content':{'gift':'T','giftinfo':'每房每晚人民币100元餐饮抵扣券，适用于酒店所有餐厅或客房用餐。此餐饮抵扣券可累计，需在离店前使用完毕，不能兑换现金或同其它促销同时使用。','ShadowGift':'F','package':'F'},'classNames':{'boxType':'jmp_table'},'css':{'maxWidth':500},'group':'gift'}}\">"
				+ "<span class=\"label_onsale_orange\" style=\"margin-right: 0px\">礼</span></span><input type=\"hidden\" id=\"spfrom\" class=\"spfrom\" value=\"-1\"></p>";
		
		Document docc = Jsoup.parse(ss);
		int i = docc.select("p").first().childNodeSize();
		System.out.println(i);
	}
}
