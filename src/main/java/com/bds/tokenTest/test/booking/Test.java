package com.bds.tokenTest.test.booking;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.bds.base.http.HttpBase;
import com.bds.tokenTest.util.Util;


public class Test {

	public static void main(String[] args) throws Exception {
		
		String label = Util.replaceCharRandomly("gen173nr-1DCAsoMUIkcWluZy1kYW8taG9uZy1zaHUtbGluLWR1LWppYS1zaGktamllSCtYBGgxiAEBmAEruAEXyAEM2AED6AEB-AECiAIBqAIDuAL8wZjkBcACAQ");
		String time = System.currentTimeMillis() / 1000 + ""; 
		String uid = Util.replaceCharRandomly("5b39a2c2.1a15f441");
		String uuid = UUID.randomUUID().toString().toLowerCase();
		String uf = Util.replaceCharRandomly("19127451a4515780");
		String vid = Util.replaceCharRandomly("01680d7a9c670091f2a2ac498ef003072004f06a00978");
		String url = "http://www.booking.com/reviewlist.zh-cn.html?pagename=qing-dao-hong-shu-lin-du-jia-shi-jie;cc1=cn;type=total;score=;dist=1;rows=10;r_lang=;rurl=;sort=f_recent_desc&_=1552289650323";
		url = "https://www.booking.com/reviewlist.zh-cn.html?label="+label+";sid=59e92e83bc48553ac6c1dbd08b13a49e;cc1=cn&pagename=qing-dao-hong-shu-lin-du-jia-shi-jie&r_lang=&review_topic_category_id=&dist=1&offset=&rows=10&rurl=&score=&sort=f_recent_desc&type=total&_=1552294142416";
		url = "https://www.booking.com/reviewlist.zh-cn.html?label=gen173nr-1DCAsoMUIhaHlhdHQtcGxhY2Utc2hhbmdoYWktaG9uZ3FpYW8tY2JkSCtYBGgxiAEBmAEruAEXyAEM2AED6AEB-AECiAIBqAIDuAKw65jkBcACAQ;sid=59e92e83bc48553ac6c1dbd08b13a49e;cc1=cn&pagename=hyatt-place-shanghai-hongqiao-cbd&r_lang=&review_topic_category_id=&dist=1&offset=&rows=10&rurl=&score=&sort=f_recent_desc&type=total&_=1552299442090";
		Map<String, String> header = new HashMap<String, String>();
		header.put("Host", "www.booking.com");
		header.put("Referer", "https://www.booking.com/hotel/cn/hyatt-place-shanghai-hongqiao-cbd.zh-cn.html");
		header.put("X-Booking-Language-Code", "zh-cn");
		header.put("Accept-Language", "zh-CN,zh;q=0.9");
		header.put("X-Booking-AID", "304142");
		header.put("X-Booking-Label", "gen173nr-1DCAsoMUIkcWluZy1kYW8taG9uZy1zaHUtbGluLWR1LWppYS1zaGktamllSCtYBGgxiAEBmAEruAEXyAEM2AED6AEB-AECiAIBqAIDuAL8wZjkBcACAQ");
		header.put("Accept", "*/*");
		header.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
		header.put("X-Booking-Session-Id", "59e92e83bc48553ac6c1dbd08b13a49e");//cda3054913693632efe5acb47ef5b15e
		header.put("X-Requested-With", "XMLHttpRequest");
//		header.put("X-Booking-Pageview-Id", "fee148583a40041c");
//		header.put("X-Partner-Channel-Id", "3");
//		header.put("X-Booking-SiteType-Id", "1");
//		header.put("X-Booking-Client-Info", "TUSLQQFZDDUWe,adUTWVNNLTQFLBRCDLfOFNZJScC|1,adUAVYCdKNKNKZaFFEJZMHaT|1,adUAVYCdKNKNKPZZaeaLDdCMSXe|1,adUAVYCdKNKNKPZZaeaLDdCMSXe|2,adUAVYCdCMFdRWSdLfdQcaNYCLC|1,adUAVYCdCMFdRWSdLdQCXHe|1");
//		header.put("X-Booking-CSRF", "PFmGXAAAAAA=HesxAzfeDBW1jl9RhCRJR4-3tAevmvy8QRjRh6wEr62LzkJ6ghHX-uE1kftPQ0aOVEbx6T5oEBWc40_wjYS6ItPHmxd9f8nmt20u33xYndWxaPFroxZqBusgsT3a3vrsd0DxHxzB4Yi_guVgKrEPH_GHK1SYBAgdfWRo0h8KgoP4M_icswv6JZhjNRcUEllIqRmowN-awu3FBI5X");
//		header.put("X-Booking-Info", "391823,566947,661987,753880,758330,760550,761510,776990,780460,788340,788580,789540,789810,792440,792490,798190,798240,799370,799730,800820,801410,802340,802450,802510,803880,805640,805740,806120,806140,806160,806510,807270,807890,809210,810870,811840,812130,812450,814620,815070,TUSLQQFZDDUWe,adUTWVNNLTQFLBRCDLfOFNZJScC|1,661987|1,806120|2,812450|1,566947|3,788340|5,806120|1,814620|1,800820|1,adUAVYCdKNKNKZaFFEJZMHaT|1,adUAVYCdKNKNKPZZaeaLDdCMSXe|1,adUAVYCdKNKNKPZZaeaLDdCMSXe|2,adUAVYCdCMFdRWSdLfdQcaNYCLC|1,adUAVYCdCMFdRWSdLdQCXHe|1");
//		header.put("Cookie", "zz_cook_tms_seg1=2; zz_cook_tms_ed=1; _ga=GA1.2.2044322352."+time
//				+ "; _smt_uid="+uid
//				+ "; _jc_uid="+uid
//				+ "; cors_js=1; cto_lwid="+uuid
//				+ "; vpmss=1; zz_cook_tms_seg3=5; b=%7B%22uF%22%3A%22"+uf+"%22%7D; _gid=GA1.2.1309084713."+time
//				+ "; BJS=-; has_preloaded=1; utag_main=v_id:"+vid
//				+ "$_sn:19$_ss:0$_st:"+new Long(time)*1000
//				+ "$4split:1$4split2:0$ses_id:"+new Long(time)*1000+"%3Bexp-session$_pn:2%3Bexp-session; zz_cook_tms_hlist=381204; lastSeen=1552294140984; _gat=1; bkng=11UmFuZG9tSVYkc2RlIyh9YfDNyGw8J7nzPnUG3Pr%2Bfv5HU0R4ojrxuf2FaTzB5T86lp%2FZFDHqYr44hhVd0VvG9XrgFww3Plq%2F1gI4lHF7FrGgzhS8a3Vm3Z%2B8spPrwvtrx6otsg%2F1IvKgtfGmtX%2BSl1hP%2BjIA27IT9e3D%2F7bK8l%2FN%2FT06T5DCaT%2BuE5xLzyI17%2ByOzWPSZxdecRMyzdvKLg%3D%3D");
//		header.put("Cookie", "zz_cook_tms_seg1=2; zz_cook_tms_ed=1; _ga=GA1.2.2044322352.1530503874; _smt_uid=5b39a2c2.1a15f441; _jc_uid=5b39a2c2.1a15f441; cors_js=1; cto_lwid=48c73de0-8e28-4432-894a-e0e7810413ab; vpmss=1; zz_cook_tms_seg3=5; b=%7B%22uF%22%3A%2219127451a4515780%22%7D; _gid=GA1.2.1309084713.1552275059; BJS=-; has_preloaded=1; utag_main=v_id:01680d7a9c670091f2a2ac498ef003072004f06a00978$_sn:19$_ss:0$_st:1552290359716$4split:1$4split2:0$ses_id:1552288227204%3Bexp-session$_pn:2%3Bexp-session; zz_cook_tms_hlist=381204; lastSeen=1552294140984; _gat=1; bkng=11UmFuZG9tSVYkc2RlIyh9YfDNyGw8J7nzPnUG3Pr%2Bfv5HU0R4ojrxuf2FaTzB5T86lp%2FZFDHqYr44hhVd0VvG9XrgFww3Plq%2F1gI4lHF7FrGgzhS8a3Vm3Z%2B8spPrwvtrx6otsg%2F1IvKgtfGmtX%2BSl1hP%2BjIA27IT9e3D%2F7bK8l%2FN%2FT06T5DCaT%2BuE5xLzyI17%2ByOzWPSZxdecRMyzdvKLg%3D%3D");
		String html = HttpBase.get(url, "utf-8").getResult();
		html = HttpBase.get(url, "utf-8", header).getResult();
		System.out.println(html);
	}
}
