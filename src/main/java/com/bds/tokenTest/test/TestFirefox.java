package com.bds.tokenTest.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.openqa.selenium.WebDriver;

import com.bds.base.http.HttpBase;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class TestFirefox {
	static WebDriver webDriver;
	
	public static void main(String[] args) {
		
//		long time = System.currentTimeMillis() ;
//		WebDriver webDriver = HttpBase.getFirefoxDriver();
//		webDriver.get("file:///C:/token/token_new.html?/waimai/ajax/newm/shopinfo?shopId=18318651&orderPlatform=&mtWmPoiId=354992928055797&source=shoplist&address=&cityId=&channel=6&lng=121.391121&lat=31.267435&gpsLng=&gpsLat=");
//		String page = webDriver.getPageSource() ;
//		Document document = Jsoup.parse(page);
//		String token = document.getElementById("vue").text();
//		System.out.println(token);
//		webDriver.close();
//		System.out.println("耗时："+(System.currentTimeMillis()-time));
		try {
			String result = getCookiHtmlUnit("http://www.bubuko.com/infodetail-2152194.html");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		try {
//			String cookieUrl = "https://takeaway.dianping.com/waimai/newm?from=m_nav_5_waimai#!index/source=redir" ;
//			String userAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1" ;
//			String cookie = PhantomjsSelenium.phantomjsWaimaiListCookieSelenium(cookieUrl, userAgent);
//			MyConstant.MOBILE_MEITUAN_CONFIG.MOBILE_PRODUCT_SHOP_COOKIE = cookie ;
//		} catch (Exception e) {
//		}
//		try {
//			getCommentHtmlUnit("file:///C:/token/token_new.html?/waimai/ajax/newm/shopinfo?shopId=18318651&orderPlatform=&mtWmPoiId=354992928055797&source=shoplist&address=&cityId=&channel=6&lng=121.391121&lat=31.267435&gpsLng=&gpsLat=");
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	}
	
	public synchronized static String getNewToken(String url) throws IOException {
		String token = "" ;
		try {
			long time = System.currentTimeMillis() ;
			webDriver = HttpBase.getFirefoxDriver();
			webDriver.get(url);
			String page = webDriver.getPageSource() ;
			Document document = Jsoup.parse(page);
			token = document.getElementById("vue").text();
//			System.out.println(token);
//			System.out.println("获取token耗时："+(System.currentTimeMillis()-time));
		} catch (Exception e) {
			System.out.println();
		}finally {
			webDriver.close();
		}
		return token ;
		
		
	}
	
	public synchronized static String getHtmlUnit(String url)throws Exception{
		long time = System.currentTimeMillis() ;
		//String querying = "file:///C:/token/token_new.html?/waimai/ajax/weixin/menu?"+q ;
        final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);  
        final HtmlPage page = webClient.getPage(url);
        Document document = Jsoup.parse(page.asXml());
		String token = document.getElementById("vue").text();
        webClient.close();
        System.out.println("通过htmlunit获取token耗时："+(System.currentTimeMillis()-time));
        return token;
	}
	
	public synchronized static String getCommentHtmlUnit(String url)throws Exception{
		long time = System.currentTimeMillis() ;
		//String querying = "file:///C:/token/token_new.html?/waimai/ajax/weixin/menu?"+q ;
        final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);  
        final HtmlPage page = webClient.getPage(url);
        Document document = Jsoup.parse(page.asXml());
		String token = document.getElementById("vue").text();
        webClient.close();
        System.out.println("通过htmlunit获取***评论***token耗时："+(System.currentTimeMillis()-time));
        return token;
	}
	
	public synchronized static String getSimpleHtmlUnit(String url)throws Exception{
		long time = System.currentTimeMillis() ;
		//String querying = "file:///C:/token/token_new.html?/waimai/ajax/weixin/menu?"+q ;
        final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);  
        final HtmlPage page = webClient.getPage(url);
        Document document = Jsoup.parse(page.asXml());
		String token = document.getElementById("vue").text();
        webClient.close();
        System.out.println("通过htmlunit获取***simple***token耗时："+(System.currentTimeMillis()-time));
        return token;
	}
	
	public synchronized static String getCookiHtmlUnit(String url)throws Exception{
		long time = System.currentTimeMillis() ;
		//String querying = "file:///C:/token/token_new.html?/waimai/ajax/weixin/menu?"+q ;
        final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);  
        final HtmlPage page = webClient.getPage(url);
        System.out.println(page.asXml());
        webClient.close();
        System.out.println("通过htmlunit获取***simple***token耗时："+(System.currentTimeMillis()-time));
        return "ok";
	}
	

}
