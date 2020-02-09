package com.zmf.booking;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bds.tokenTest.util.Util;

public class jsoup {

	public static void main(String[] args) {
		try {
			String dir = System.getProperty("user.dir") + File.separator;
			String filePath = dir+"src\\main\\java\\com\\zmf\\booking\\booking.txt";
			System.out.println(filePath);
			String html = Util.read(filePath);
			System.out.println(html);
			Document doc = Jsoup.parse(html);
			Elements es = doc.select("li.review_list_new_item_block");
			for (Element e : es) {
				System.out.println(e);
				String text = e.select("div.c-review-block__room-info__name>div.room_info_heading").text();
				System.out.println(text);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
