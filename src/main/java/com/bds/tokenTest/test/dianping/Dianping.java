package com.bds.tokenTest.test.dianping;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.entity.Record;

import com.bds.base.dao.BIDataSource;
import com.bds.base.http.HttpBase;
import com.bds.tokenTest.model.Dishimg;

public class Dianping {
	public static void main(String[] args) {
		
		Dao dao = BIDataSource.getBiDataSource("dianping", "Disneyland", "get_restaurant_info").getBiDao();
		
		List<Record> r = dao.query("dianping_restaurant_dish_img_task", Cnd.where("status", "=", 0));
		for (Record record : r) {
			int id = record.getInt("RID");
			dao.update("dianping_restaurant_dish_img_task", Chain.make("status", 1), Cnd.where("RID", "=", id));
			String shopId = record.getString("shop_id");
			String requestId = record.getString("request_id");
			
			String uuid = UUID.randomUUID().toString();
			
			String url = "http://www.dianping.com/shop/"+shopId+"/dishlist";
			Map<String, String> headers = new HashMap<String, String>();
			headers.put("Cache-Control", "max-age=0");
			headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
			headers.put("Accept-Encoding", "gzip, deflate");
			headers.put("Accept-Language", "zh-CN,zh;q=0.9");
			headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
//			headers.put("Referer", "http://www.dianping.com/shop/"+shopId+"/dishlist");
			headers.put("Upgrade-Insecure-Requests", "1");
			headers.put("Connection", "keep-alive");
			headers.put("Host", "www.dianping.com");
			headers.put("Cookie", "cityid=1; "
					+ "_lxsdk_cuid="+uuid+"; "
					+ "_lxsdk="+uuid+"; "
					+ "switchcityflashtoast=1; "
					+ "_hc.v=db81602c-2332-d985-0c3c-6cf35f5776b2.1532403932; "
					+ "ta.uuid=1021602270518882337; "
					+ "isUuidUnion=true; "
					+ "iuuid="+uuid+"; "
					+ "_lxsdk_s=165c2d23113-7a8-5cf-a62%7C%7C2");
			
			try {
				String html = HttpBase.get(url, "utf-8", headers).getResult();
//				System.out.println(html);
				//获取总页数
				Document doc = Jsoup.parse(html);
				Elements es = doc.select("div.shop-food-list-page>a");
				int demp = es.size() - 2;
				String page = doc.select("div.shop-food-list-page>a").get(demp).attr("data-ga-page");
				System.out.println("===="+shopId+">>>>>>>page="+page);
				for(int i = 1;i <= Integer.parseInt(page);i ++){
					if(i == 1){
						parse(html,requestId,shopId);
					}else{
						url = "http://www.dianping.com/shop/"+shopId+"/dishlist/p"+i;
						html = HttpBase.get(url, "utf-8", headers).getResult();
						parse(html,requestId,shopId);
					}
				}
				dao.update("dianping_restaurant_dish_img_task", Chain.make("status", 2), Cnd.where("RID", "=", id));
//			System.out.println(html);
//			parse(html);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				dao.update("dianping_restaurant_dish_img_task", Chain.make("status", 3), Cnd.where("RID", "=", id));
			}
		}
		
	}
	
	public static void parse(String html,String	requestId, String shopId){
		Dao dao = BIDataSource.getBiDataSource("dianping", "Disneyland", "get_restaurant_info").getBiDao();
		Document doc = Jsoup.parse(html);
		Elements e = doc.select("div.list-desc>ul>a");
//		String page = doc.select("div.shop-food-list-page>a").get(4).attr("data-ga-page");
//		System.out.println(page);
		for (Element element : e) {
			String name = element.select("div.shop-food-con>div.shop-food-name").text();
			String recommendCount = element.select("div.shop-food-con>div.recommend-count").text().replace("人推荐", "");
			String price = element.select("div.shop-food-con>div.shop-food-money").text().replace("￥", "");
			String dishurl = element.select("div.shop-food-img>img").attr("src");
//			System.out.println(dishurl);
			if(dishurl.indexOf("%") != -1){
				dishurl = dishurl.substring(0, dishurl.indexOf("%"));
			}
			Dishimg d = new Dishimg();
			d.setCreate_time(new Date());
			d.setDish_name(name);
			d.setPic_url(dishurl);
			d.setPrice(price);
			d.setRecommend_cnt(recommendCount);
			d.setRequest_id(requestId);
			d.setShop_id(shopId);
			System.out.println(d);
			dao.fastInsert(d);
//			System.out.println(url.substring(0, url.indexOf("%")));
//			System.out.println(name);
		}
		
//		System.out.println(e);
	}
	
	public String replaceCharRandomly(String str) {
//		System.out.println("传入的字符串为："+str);
		StringBuffer result = new StringBuffer();
		char[] cs = str.toCharArray();
		Random random = new Random();
		int num = 0 ;
		for (int i = 0; i < cs.length; i++) {

			if (cs[i] >= 48 && cs[i] <= 57) {
				//数字
				//第一位数字不为0
				int ran = random.nextInt(10);
				if (num == 0) {
					if (ran == 0 ) {
						ran += 1 ;
					}
				}
				result.append(ran);
			}else if (cs[i] >= 65 && cs[i] <= 90) {
				//大写字母
				result.append((char)(65 + random.nextInt(26)));
			}else if (cs[i] >= 97 && cs[i] <= 122) {
				//小写字母
				result.append((char)(97 + random.nextInt(26)));
			}else {
				//特殊符号返回本身
				result.append(cs[i]);
			}
		}
//		System.out.println("传出的字符串为："+result.toString());
		return result.toString() ;
	}
}
