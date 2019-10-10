package com.bds.tokenTest.test.ctrip;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.alibaba.fastjson.JSON;
import com.bds.base.http.HttpBase;
import com.bds.tokenTest.model.CtripModel;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class CtripTest {
	//428365 2018-09-18 7762a0d8c177b3510a34b00e85e281b43a8837c238d90125f79acde27e6a4231
	public static String getCtripHtml(String hotelId,String startDate,String depDate,String eleven) throws Exception {
		String url =  "psid=&MasterHotelID="+hotelId+"&hotel="+hotelId+"&EDM=F&roomId=&IncludeRoom="
				+ "&supplier=&showspothotel=T&IsDecoupleSpotHotelAndGroup=F&contrast=0&brand=0"
				+ "&startDate="+java.net.URLEncoder.encode(startDate, "utf-8")+"&depDate="+java.net.URLEncoder.encode(depDate, "utf-8")+"&IsFlash=F&RequestTravelMoney=F&hsids=&IsJustConfirm="
				+ "&contyped=0&priceInfo=-1&equip="
				+ "&filter="+java.net.URLEncoder.encode("bed|0,bf|0,network|0,policy|0,hourroom|0,reserve|0,pay|0,triple|0,addbed|0,chooseroom|0,ctrip|0,hotelinvoice|0,CtripService|0", "utf-8")
				+ "&productcode=&couponList=&abForHuaZhu=&defaultLoad=F&esfiltertag=&estagid=&RoomGuestCount=1,1,0&promotionf=null,"
				+ "&eleven="+eleven+"&callback=CASUaFvuskHQxWLROSV&_="+System.currentTimeMillis();
		url = "http://hotels.ctrip.com/Domestic/tool/AjaxHote1RoomListForDetai1.aspx?"+url;
		//System.out.println(url);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept", "*/*");
		headers.put("Accept-Encoding", "gzip, deflate");
		headers.put("Accept-Language", "zh-CN,zh;q=0.9");
		headers.put("Cache-Control", "max-age=0");
		headers.put("Connection", "keep-alive");
		headers.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
		//headers.put("Cookie", "_ga=GA1.2.662657886.1531727652; _RSG=pIKby_dtLv8DFj1l3hvit8; _RDG=28e1156baa08502e961d900607f6e11dea; _RGUID=8e55de7f-fc95-44b3-8dec-e6b0ef06d3cd; _abtest_userid=8aea9549-c5c2-44c6-a1db-5d632bc6da84; Session=SmartLinkCode=U155952&SmartLinkKeyWord=&SmartLinkQuary=&SmartLinkHost=&SmartLinkLanguage=zh; traceExt=campaign=CHNbaidu81&adid=index; _RF1=116.231.90.95; Union=SID=155952&AllianceID=4897&OUID=baidu81|index|||; MKT_Pagesource=PC; _gid=GA1.2.682710590.1537152694; HotelCityID=2split%E4%B8%AD%E6%96%87%2F%E6%8B%BC%E9%9F%B3%2F%E8%8B%B1%E6%96%87splitshanghaisplit2018-9-17split2018-09-18split0; ASP.NET_SessionId=mc4w444edathaumtwg11yzse; OID_ForOnlineHotel=15317276461182n93qd1537152701090102002; HotelDomesticVisitedHotels1=428365=0,0,4.7,6497,/hotel/373000/372135/c3028fa548b34dd883e187498a1fe26e.jpg,&8052290=0,0,4.6,6149,/20060j000000affyp70DC.jpg,&393916=0,0,4.6,6633,/hotel/1000/634/2a64c0ee313240dba434abd1942c91e1.jpg,&5485352=0,0,4.6,8232,/200s0o000000fgdxb7316.jpg,&434152=0,0,4.6,2423,/hotel/56000/55059/0d04cea1ef6d4ef39a5f5778fcf2fe36.jpg,; appFloatCnt=30; manualclose=1; _bfa=1.1531727646118.2n93qd.1.1536544082067.1537152689587.17.136; Mkt_UnionRecord=%5B%7B%22aid%22%3A%224897%22%2C%22timestamp%22%3A1537153031691%7D%5D; _jzqco=%7C%7C%7C%7C1537152703691%7C1.1420739956.1531727657553.1537152708679.1537153031710.1537152708679.1537153031710.undefined.0.0.103.103; __zpspc=9.18.1537152703.1537153031.3%231%7Cbaidu%7Ccpc%7Cbaidu81%7C%25E6%2590%25BA%25E7%25A8%258B%7C%23; _bfi=p1%3D102003%26p2%3D102003%26v1%3D136%26v2%3D135");
		headers.put("Host", "hotels.ctrip.com");
		headers.put("If-Modified-Since", "Thu, 01 Jan 1970 00:00:00 GMT");
		headers.put("Referer", "http://hotels.ctrip.com/hotel/"+hotelId+".html");
		headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
		String html = HttpBase.get(url, "utf-8",headers).getResult();
		//System.out.println(html);
		JSONObject jo = new JSONObject(html);
		String ASYS = jo.getString("ASYS");
		String ComplexHtml = jo.getString("ComplexHtml");
//		String a = "file:///C:/token/ctrip.html?a="+ComplexHtml+"&&&b=";
//		String b = Base64.encodeBase64String(ASYS.getBytes());
//		String s = getHtmlUnit(a+b);
		String s = getHtml(ComplexHtml, ASYS);
//		System.out.println(s);
		return s;
	}
	
//	public synchronized static String getHtmlUnit(String url)throws Exception{
//		long time = System.currentTimeMillis() ;
//        final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);  
//        final HtmlPage page = webClient.getPage(url);
//        Document document = Jsoup.parse(page.asXml());
//		String token = document.getElementById("vue").html();
//        webClient.close();
//        System.out.println("通过htmlunit获取token耗时："+(System.currentTimeMillis()-time));
//        return token;
//	}
	
	public static String getHtml(String n,String t){
			
		int r;
		char o;
		String c = "";
		for (r = 0; r < n.length(); r++){
			 o = t.charAt(n.charAt(r) - 21760);
			 c += o;
		}
		return c;
	}
	
	public static void main(String[] args) throws Exception {
		String hotelid = "5052325";
		
		Map<String,String> headers = new HashMap<String,String>();
    	String n = e(15);
		String url = "http://hotels.ctrip.com/domestic/cas/oceanball?callback=" + n + "&_=" + new Date().getTime();
		headers.put("Host", "hotels.ctrip.com");
		headers.put("Referer", "http://hotels.ctrip.com/hotel/"+hotelid+".html");
		headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
    	String result = HttpBase.get(url,"utf-8", headers).getResult();
    	int begin = result.indexOf("(")+1;
		int end = result.lastIndexOf(")");
		result = result.substring(begin, end);
		String js = result.replace(n, "callback");
		String callback = n;
		String curl = "http://211.152.47.69:9999/ctrip_token";
		//String eleven = HttpBase.get(curl,"UTF-8",new HashMap<String,String>()).getResult();
		Map<String,String> header = new HashMap<String,String>();
		header.put("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
		header.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
		header.put("Accept-Language", "zh-CN,en-US;q=0.8");
		Map<String,String> params = new HashMap<String,String>();
		params.put("id",hotelid);
		params.put("callback",callback);
		params.put("js",js);
		String eleven = HttpBase.post(curl, header, params);
//		System.out.println(eleven);
		if(StringUtils.isEmpty(eleven) || eleven.length() != 64 || eleven.contains("`")) {
			return;
		}
		String html=CtripTest.getCtripHtml(hotelid, "2018-10-08", "2018-10-09", eleven);
		
		if(StringUtils.isEmpty(html)){
			System.out.println("html为空");
			return;
		}
		
//		String html = CtripTest.getCtripHtml(16197084, "2018-09-18", "2018-09-19", "7762a0d8c177b3510a34b00e85e281b43a8837c238d90125f79acde27e6a4231");
		Document doc = Jsoup.parse(html);
		Elements elements = doc.select("tbody>tr");
		int endrow = 5;
		String houseType = "";
		String area = "";
		String floor = "";
		String bed = "";
		String window = "";
		String addBed = "";
		String yan = "";
		for (int i = 5;i<elements.size();i++) {//符合条件的房型
			
			if(elements.get(i).select("tr>td").get(0).hasAttr("rowspan")){//获取该类房间的品种数
				String rowspan = elements.get(i).select("tr>td").get(0).attr("rowspan");
				int row = Integer.parseInt(rowspan);
				endrow = i + row;
				houseType=elements.get(i).select("tr>td>a").get(1).text().replace(" 查看详情", "");
				String imgurl = elements.get(i).select("tr>td>a").get(0).select("img").attr("_src");
				System.out.println(">>>>>>"+imgurl);
				////详细信息在endRow
				Elements detailes = elements.get(endrow).select("tr>td>div>div.hrd-info>div.hrd-info-base>ul");
				area = detailes.get(0).select("itemtemplate>li").get(0).text().replace("建筑面积:", "");
				floor = detailes.get(0).select("itemtemplate>li").get(1).text().replace("楼层:", "");
				bed = detailes.get(0).select("itemtemplate>li").get(2).text().replace("床型：", "");
				window = detailes.get(0).select("itemtemplate>li").get(3).text().replace("窗户：", "");
				addBed = detailes.get(0).select("itemtemplate>li").get(4).text().replace("可加床：", "");
				yan = detailes.get(0).select("itemtemplate>li").get(5).text().replace("无烟：", "");
			}
			if(i < endrow){
				
				int tdSize = elements.get(i).select("tr>td").size();
				if(tdSize == 9){//第一个有9个td
					//优惠
					String favourable = elements.get(i).select("tr>td").get(1).select("span.room_type_name").text();
					String bedType = elements.get(i).select("tr>td").get(2).text();
					String breakfast = elements.get(i).select("tr>td").get(3).text();
					String network = elements.get(i).select("tr>td").get(4).select("span").text();
					String personNum = elements.get(i).select("tr>td").get(5).select("span").attr("title");
					String policy = elements.get(i).select("tr>td").get(6).text();
					String policy2 = elements.get(i).select("tr>td").get(6).select("span").attr("data-params");//不可取消
					String base_price = elements.get(i).select("tr>td").get(7).select("div>span.base_price").text().replace("¥", "");
					String discount = elements.get(i).select("tr>td").get(7).select("div>div.text-grayMiddle").text();//text-grayMiddle
					System.out.println("++++++++>>>"+discount);
					String payType = elements.get(i).select("tr>td").get(8).select("div>a>div").text();
					CtripModel cm = new CtripModel();
					cm.setBase_price(base_price);
					cm.setBedType(bedType);
					cm.setBreakfast(breakfast);
					cm.setFavourable(favourable);
					cm.setHouseType(houseType);
					cm.setNetwork(network);
					cm.setPayType(payType);
					cm.setPersonNum(personNum);
					cm.setPolicy(policy);
					cm.setAddBed(addBed);
					cm.setArea(area);
					cm.setBed(bed);
					cm.setFloor(floor);
					cm.setWindow(window);
					cm.setYan(yan);
					System.out.println(cm);
				}else{
					String favourable = elements.get(i).select("tr>td").get(0).select("span.room_type_name").text();
					String bedType = elements.get(i).select("tr>td").get(1).text();
					String breakfast = elements.get(i).select("tr>td").get(2).text();
					String network = elements.get(i).select("tr>td").get(3).select("span").text();
					String personNum = elements.get(i).select("tr>td").get(4).select("span").attr("title");
					String policy = elements.get(i).select("tr>td").get(5).text();
					String base_price = elements.get(i).select("tr>td").get(6).select("div>span.base_price").text().replace("¥", "");
					String discount = elements.get(i).select("tr>td").get(6).select("div>div.text-grayMiddle").text();//text-grayMiddle
					System.out.println("++++++++>>>"+discount);
					String payType = elements.get(i).select("tr>td").get(7).select("div>a>div").text();
					CtripModel cm = new CtripModel();
					cm.setBase_price(base_price);
					cm.setBedType(bedType);
					cm.setBreakfast(breakfast);
					cm.setFavourable(favourable);
					cm.setHouseType(houseType);
					cm.setNetwork(network);
					cm.setPayType(payType);
					cm.setPersonNum(personNum);
					cm.setPolicy(policy);
					cm.setAddBed(addBed);
					cm.setArea(area);
					cm.setBed(bed);
					cm.setFloor(floor);
					cm.setWindow(window);
					cm.setYan(yan);
					System.out.println(cm);
				}
			}
		}
	}
	
	public static String e(int e) {
		String t[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		String o = "CAS";
		java.util.Random r = new Random();
		for(int n=0;n<e;n++) {
			int i = r.nextInt(51);
			o += t[i];
		}
		return o;
	}
}
