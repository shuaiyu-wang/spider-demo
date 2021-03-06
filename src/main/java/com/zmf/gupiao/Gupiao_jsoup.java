package com.zmf.gupiao;

import java.io.File;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bds.tokenTest.util.Util;

public class Gupiao_jsoup {
	public static void main(String[] args) {
		try {
			String dir = System.getProperty("user.dir") + File.separator;
			String filePath = dir+"src\\main\\java\\com\\zmf\\gupiao\\gupiao.txt";
			System.out.println(filePath);
			String html = Util.read(filePath);
//			System.out.println(html);
			Document doc = org.jsoup.Jsoup.parse(html);
			Elements es = doc.select("table#fundamental>tbody>tr");
			for (Element e : es) {
				Elements ee = e.select("td");
				//定义参数
				//<span title="美国" class="ceFlags USA">
				System.out.println("title.................."+ee.get(0).select("span").attr("title"));
				//<a href="/equities/3m-co" title="3M公司">
				System.out.println("href.................."+ee.get(1).select("a").attr("href"));
				//<span class="alertBellGrayPlus js-plus-icon genToolTip oneliner" data-tooltip="创建提醒" data-name="3M公司" data-id="277"></span>
				System.out.println("id.................."+ee.get(1).select("span").attr("data-id"));
				System.out.println(ee.get(1).text());
				System.out.println(ee.get(2).text());
				System.out.println(ee.get(3).text());
				System.out.println(ee.get(4).text());
				System.out.println(ee.get(5).text());
				System.out.println(ee.get(6).text());
				//赋值
				//插表
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
