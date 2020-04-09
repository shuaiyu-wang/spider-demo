package com.zmf.gupiao;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.bds.tokenTest.util.Util;

public class Equities_jsoup {

	public static void main(String[] args) {
		try {
			String dir = System.getProperty("user.dir") + File.separator;
			String filePath = dir+"src\\main\\java\\com\\zmf\\gupiao\\equities.txt";
//			System.out.println(filePath);
			String html = Util.read(filePath);
			Document doc = Jsoup.parse(html);
			Elements es = doc.select("div#rrtable");
			Elements tr1 = es.get(0).select("tr");
			String name  = tr1.select("th").get(0).text();
			System.out.println(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
