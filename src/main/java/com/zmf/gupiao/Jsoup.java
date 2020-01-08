package com.zmf.gupiao;

import java.io.File;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bds.tokenTest.util.Util;

public class Jsoup {
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
				String id = e.attr("id");
				System.out.println(".................."+id);
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
