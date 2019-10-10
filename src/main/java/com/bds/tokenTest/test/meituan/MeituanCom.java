package com.bds.tokenTest.test.meituan;

import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.bds.base.http.HttpBase;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class MeituanCom {
	public static void main(String[] args) throws ConnectException {
//		String url2 = "https://wx.waimai.meituan.com/weapp/v1/poi/food?"
//				+ "ui="+(int)(Math.random()*10*Math.pow(10, 9))
//				+ "&region_id="+(int)(Math.random()*10*Math.pow(10, 10))
//				+ "&region_version="+(int)(Math.random()*10*Math.pow(10, 7));
//		Map<String, String> header = new HashMap<String, String>();
//		header.put("charset", "utf-8");
////		header.put("Accept-Encoding", "gzip");
////		header.put("referer", "https://servicewechat.com/wx2c348cf579062e56/90/page-frame.html");
////		header.put("content-type", "application/x-www-form-urlencoded");
////		header.put("uuid", "af6b4788-42c9-439c-a955-2bc5d6b6ea92");
////		header.put("User-Agent", "Mozilla/5.0 (Linux; Android 7.0; PIC-AL00 Build/HUAWEIPIC-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.143 Crosswalk/24.53.595.0 XWEB/155 MMWEBSDK/21 Mobile Safari/537.36 MicroMessenger/6.6.7.1321(0x26060739) NetType/WIFI Language/zh_CN MicroMessenger/6.6.7.1321(0x26060739) NetType/WIFI Language/zh_CN");
////		header.put("Content-Length", "765");
//		header.put("Host", "wx.waimai.meituan.com");
//		header.put("Connection", "Keep-Alive");
//		
//		Map<String, String> data = new HashMap<String, String>();
//		String token2 = 
////				"_token=eJxdkN1qwkAQhd9lLnq1uH8mMYEgoSnFtiuNJAVbRNSsuiYmaZKqKH33TlBvysKeM98OzJy9QD1KweOMMSEJHHQNHvAe69lAoG3wxZLClcyymGs5BFb/mMMJLOuPELwvpDZxpJh1ZILgSgZ2f0ZuVqAVfdIJLEfYAmuTa49S+ujRtsx0cb3nhT72tu0+Hx71oqrogdOqNHRdlunwx/jc5tzlfYeLh1pvTFnMTep3ESRnePidYpoG1e/2tRwhMRLg5H2Mk1Gzmy5u2t5rhX+AvY3ZFOj0yyl+zarxeXB+NwNXNXHCVBgcx7soiDLFv5+3n4v86ZS9Tfk4TITaJVLl0/q8jLBWrA0jpuIVSzajYBJmkzTwffj9A5Gyank="
//					"wm_poi_id=42217052000995"
////					+"&trace_tag=%7B%22req_time%22%3A1532923358717%2C%22visitid%22%3A%22beec3714-410b-4fd6-a2b4-1fbc79ce752d%22%2C%22src_page%22%3A%22p_homepage%22%2C%22src_block%22%3A%22b_poilist%22%2C%22src_item_index%22%3A0%2C%22src_item_id%22%3A422170520006995%2C%22src_item_type%22%3A%22poi%22%2C%22tgt_page%22%3A%22p_poi%22%2C%22extra%22%3A%7B%22poi_id%22%3A422170520006995%7D%2C%22action%22%3A%22click%22%2C%22wm_actual_longitude%22%3A121384210%2C%22wm_actual_latitude%22%3A31272150%2C%22longitude%22%3A121384210%2C%22latitude%22%3A31272150%2C%22ctype%22%3A%22wxapp%22%2C%22uuid%22%3A%22af6b4788-42c9-439c-a955-2bc5d6b6ea92%22%2C%22customerid%22%3A161191471%2C%22appversion%22%3A%222.8.4%22%2C%22appname%22%3A%22wxapp%22%2C%22dversion%22%3A%226.6.7%22%2C%22dtype%22%3A%22PIC-AL00%22%2C%22request_id%22%3A%220.1627911117779699%22%2C%22tgt_block%22%3A%22b_food%22%7D"
////					+"&open_id=oOpUI0UK2bx7Kj8aX2VvHSkHsCfs"
////					+"&uuid=af6b4788-42c9-439c-a955-2bc5d6b6ea92"
//					+"&platform=13"
//					+"&partner=4"
//					+"&riskLevel=1"
////					+"&user_id=161191471"
////					+"&userid=161191471"
////					+"&wm_actual_latitude=31272150"
////					+"&wm_actual_longitude=121384210"
//					+"&waimai_sign=%2F"
//					+"&req_time=1532923358717"
////					+"&userToken=5h0F1SWui7qsGMf1tLaV51k52yIAAAAAKQYAAAnYwNK_1KwjxixD8_lky2FmJlc04W_e-vCp3m7QRWaQYPJ0seTQ8dG68uKtzaJimA"
////					+"&wm_logintoken=5h0F1SWui7qsGMf1tLaV51k52yIAAAAAKQYAAAnYwNK_1KwjxixD8_lky2FmJlc04W_e-vCp3m7QRWaQYPJ0seTQ8dG68uKtzaJimA"
//					+"&wm_appversion=2.8.4"
////					+"&wm_visitid=beec3714-410b-4fd6-a2b4-1fbc79ce752d"
//					+"&wm_latitude=31272150"
//					+"&wm_longitude=121384210"
////					+"&wm_uuid=af6b4788-42c9-439c-a955-2bc5d6b6ea92"
//					+"&wm_dversion=6.6.7"
//					+"&wm_dtype=PIC-AL00"
//					+"&wm_ctype=wxapp";
//		String[] s = token2.split("&");
//		for(int i = 0;i < s.length;i ++){
//			data.put(s[i].split("=")[0], s[i].split("=")[1]);
//		}
//		String html2 = HttpBase.post(url2, header, data);
//		System.out.println("caidan ---"+html2);
//		
//		//评价
//		String url = "https://wx.waimai.meituan.com/weapp/v1/comment/poi";
//				+ "?"
//				+ "ui=161191"
//				+ "&region_id=10003101"
//				+ "&region_version=1532572324";
//		Map<String, String> header2 = new HashMap<String, String>();
//		header2.put("charset", "utf-8");
//		header2.put("referer", "https://servicewechat.com/wx2c348cf579062e56/89/page-frame.html");
//		header2.put("content-type", "application/x-www-form-urlencoded");
//		header2.put("uuid", "af6b4788-42c9-439c-a955-2bc5d6b6ea92");
//		header2.put("User-Agent", "Mozilla/5.0 (Linux; Android 7.0; PIC-AL00 Build/HUAWEIPIC-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.143 Crosswalk/24.53.595.0 XWEB/155 MMWEBSDK/21 Mobile Safari/537.36 MicroMessenger/6.6.7.1321(0x26060739) NetType/WIFI Language/zh_CN MicroMessenger/6.6.7.1321(0x26060739) NetType/WIFI Language/zh_CN");
//		header2.put("Content-Length", "765");
//		header2.put("Host", "wx.waimai.meituan.com");
//		header2.put("Connection", "Keep-Alive");
//		
//		Map<String, String> data2 = new HashMap<String, String>();
//		String token = "wmpoiid=531464552899861"
//				+ "&comment_score_type=0"
//				+ "&label_id=0"
//				+ "&page_size=20"
//				+ "&page_offset=0"
//				+ "&open_id=oOpUI0UK2bx7Kj8aX2VvCSkHsCfs"
//				+ "&uuid=af6b4788-42c9-439c-a955-2bc5d6b6ea92"
//				+ "&platform=13&partner=4&riskLevel=1"
//				+ "&user_id=161191571&userid=161191571"
//				+ "&wm_actual_latitude=31272171&wm_actual_longitude=121384240"
//				+ "&waimai_sign=%2F&req_time=1532929222750"
//				+ "&userToken=5h0F1SWui7qsGMf1tLaV51k52yIAAAAAKZXCAAnYwNK_1KwjxixD8_lky2FmJlc04W_e-vCp3m7QRWaQYPJ0seTQ8dG68uKtzaJimA"
//				+ "&wm_logintoken=5h0F1SWui7qsGMf1tLaV51k52yICVBABKQYAAAnYwNK_1KwjxixD8_lky2FmJlc04W_e-vCp3m7QRWaQYPJ0seTQ8dG68uKtzaJimA"
//				+ "&wm_appversion=2.8.4"
//				+ "&wm_visitid=705ef194-73e6-4502-81cb-598530710668"
//				+ "&wm_latitude=31272171&wm_longitude=121384240"
//				+ "&wm_uuid=af6b4788-42c9-439c-a954-2bc5d6b6ea92"
//				+ "&wm_dversion=6.6.7&wm_dtype=PIC-AL00&wm_ctype=wxapp";
//		String[] s1 = token.split("&");
//		for(int i = 0;i < s1.length;i ++){
//			data2.put(s1[i].split("=")[0], s1[i].split("=")[1]);
//		}
//		data2.put("_token", "eJxdkF1PwjAUhv9LL7xa6Me6MpYsZBGzgEIEAWMMIR0UqKNr3YYjGP+7B4Ebb/qcPj3p6dtvVPbXKKKEEOZ76EuVKEK0RVoCeaiu4CTwWdAJBOeEcQ+t/jlfeCgr5z0UvYMVXttni7OZgLiYUPCFdy0ZlHDLGSjrQwva6L2KMMb3Ea5trorLuixU09rVZt/FjZLO4S+KndVYFxvbPeiYCko7lLfpXam22hZLvY7PEXxKADcJYSpg/PfcNvMZ5yGFWAimmylMB+ZXyivr234I/wC9ld4WUKnBcfqYu9EpPD3rsDOspjMy7CXN6GOczIwbN9nTzJr+NnutrTTHXJogz9KJfjOpnTvnJNsZme6cTAeHz2ScKLF6eWjiGP38AhlGb0E=");
//		String html = HttpBase.post(url, header2, data2);
//		System.out.println("pingjia"+html);
//		
//		String url3 = "https://wx.waimai.meituan.com/weapp/v1/poi/info";
//				+ "?ui=1611914"
//				+ "&region_id=100031"
//				+ "&region_version=1532572";
//		Map<String, String> header3 = new HashMap<String, String>();
//		header3.put("charset", "utf-8");
//		header3.put("referer", "https://servicewechat.com/wx2c348cf579062e56/89/page-frame.html");
//		header3.put("content-type", "application/x-www-form-urlencoded");
//		header3.put("uuid", "af6b4788-42c9-439c-a955-2bc5d6b6ea92");
//		header3.put("User-Agent", "Mozilla/5.0 (Linux; Android 7.0; PIC-AL00 Build/HUAWEIPIC-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.143 Crosswalk/24.53.595.0 XWEB/155 MMWEBSDK/21 Mobile Safari/537.36 MicroMessenger/6.6.7.1321(0x26060739) NetType/WIFI Language/zh_CN MicroMessenger/6.6.7.1321(0x26060739) NetType/WIFI Language/zh_CN");
//		header3.put("Content-Length", "765");
//		header3.put("Host", "wx.waimai.meituan.com");
//		header3.put("Connection", "Keep-Alive");
//		
//		Map<String, String> data3 = new HashMap<String, String>();
//		String token3 = 
//				"_token=eJx1UNuOmzAU%2FBdeQYuNDdgr9SEkECBLEnIPVR8gAcKdcE2o%2Bu8l6qqtVFWyPGfOmTny%2BDtTGVfmHQIAoMQxTT3WIhKoQGRABTC2Ln96FBFBooRjvOowY96%2FIglwWCbfXo3NyL9CQAAHMcLfuL9rAY%2FnpTJGEVO6oV%2FzlV83blu5efNXyXCf0yi%2F%2Bo9fNzMas91oHDH5RPeFDKTwTZJkAGSMJYHQ8bUQSG8IoVcagiAQscx1kd%2BPeyF9TYXflNB%2FveB%2FXkHgKPzNIB61%2BA9F4yaJUkqgRCgW0TiF%2F90kc5hIv%2BgYpPkMVEdhzrwzvvmk%2B1naCcPkzG%2BJ0yz1NLD7y0y5mt5H2uRWB01tshV3hmTA%2BRYdaPDczxWljrblpje61TrGvN9KtXNM9g3k3aV4rFe5al1y1RMN8rD4mXxZs0cBPat7aLlC5y2aEii7uYMOnptsp7AS56g8HA3g9n1RGsM6VdunHAi1epyHB%2BrQTl9V%2FsGp%2BHB5qs7j15FrHARWu0Vimd3ylT74cRZcdP8st0UfhCTWDNyZKJAWdytas%2BvqklpJssLxFDsHG9wfLWU95GvtZOjk1lyXM%2BdKJZ314m17Soki6hd7sy%2BiRfNkickXZlYM%2BkENzYWK94Vqp%2F00nk8MvEu7xfkoLXtLKU%2Fz2xXKaVx%2BEO28ibxHt82iu73OWbq5h9Vs4urVoEtCG2ck6oubEUUZuatgED6c4eqeHnYkF8P0xCItpHnkNLc20dAdns4fmZZKOpD7W0CM4zmz2V3EV8WiI%2FxRltSginOTFE1BNDgklJ04%2BTJZmBPVqhVnM5lFjnG2pnsntE1laE%2BJJxQos3M91qalZhgLA%2BVQgaTCpvqF%2BfETufgU%2BQ%3D%3D"
//				"wmpoiid=2319731";
//				+ "&open_id=oOpUI0UK2bx7Kj8aX2VvHSkHsCfs"
//				+ "&uuid=af6b4788-42c9-439c-a955-2bc5d6b6ea92"
//				+ "&platform=13"
//				+ "&partner=4"
//				+ "&riskLevel=1"
//				+ "&user_id=161191471"
//				+ "&userid=161191471"
//				+ "&wm_actual_latitude=31272171"
//				+ "&wm_actual_longitude=121384240"
//				+ "&waimai_sign=%2F&req_time=1532929382663"
//				+ "&userToken=5h0F1SWui7qsGMf1tLaV51k52yIAAAAAKQYAAAnYwNK_1KwjxixD8_lky2FmJlc04W_e-vCp3m7QRWaQYPJ0seTQ8dG68uKtzaJimA"
//				+ "&wm_logintoken=5h0F1SWui7qsGMf1tLaV51k52yIAAAAAKQYAAAnYwNK_1KwjxixD8_lky2FmJlc04W_e-vCp3m7QRWaQYPJ0seTQ8dG68uKtzaJimA"
//				+ "&wm_appversion=2.8.4"
//				+ "&wm_visitid=705ef194-73e6-4502-81cb-598530710668"
//				+ "&wm_latitude=31272171"
//				+ "&wm_longitude=121384240"
//				+ "&wm_uuid=af6b4788-42c9-439c-a955-2bc5d6b6ea92"
//				+ "&wm_dversion=6.6.7&wm_dtype=PIC-AL00"
//				+ "&wm_ctype=wxapp";
//		String[] s4 = token3.split("&");
//		for(int i = 0;i < s4.length;i ++){
//			data3.put(s4[i].split("=")[0], s4[i].split("=")[1]);
//		}
//		String html4 = HttpBase.post(url3, header3, data3);
//		System.out.println("pingjia"+html4);
		
		String url = "https://wx.waimai.meituan.com/weapp/v2/poi/homepage?ui=2147483647&region_id=2147483647&region_version=2147483647";
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("charset", "utf-8");
//		headers.put("Accept-Encoding", "gzip");
		headers.put("referer", "https://servicewechat.com/wx2c348cf579062e56/93/page-frame.html");
		headers.put("content-type", "application/x-www-form-urlencoded");
		headers.put("uuid", "af6b4788-42c9-439c-a955-2bc5d6b6ea92");
		headers.put("User-Agent", "Mozilla/5.0 (Linux; Android 7.0; PIC-AL00 Build/HUAWEIPIC-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.143 Crosswalk/24.53.595.0 XWEB/155 MMWEBSDK/21 Mobile Safari/537.36 MicroMessenger/6.6.7.1321(0x26060739) NetType/WIFI Language/zh_CN MicroMessenger/6.6.7.1321(0x26060739) NetType/WIFI Language/zh_CN");
		headers.put("Host", "wx.waimai.meituan.com");
		headers.put("Connection", "Keep-Alive");
		String params2 = "_token=" + "eJxtkNtKw0AQht9lLrxassnu5mCglGCqNJIiNVZFSknNmi45rUlsNeK7O6URRLzZ759vBobZT2jnGfiWaZqME9jLFnywDNNwgEDfYcfm3LNM27Zc5hJ4/uOERWDbrkLwn9A6xOVsfTRLFCfjOWJNxsgwMkGOgO0cR+BFldKnlF74tG8KWZ/eTS0Pxq6vyik9yFRrumdUN4rumkrqNJfTNzVhlnCFxx3hnrUyV029Udk/Ei/qkL86eBjg/irB/chiZDqy/6lj/Amc7VReY5LRe3Jd6MXgDTfKO4+75O5jEc54lwQsHi4f8sPrvV4+rgJWFlUWxVEkboOrsJvJYgJf35PxZZc="
				+ "&page_index=0"
				+ "&page_size=20"
				+ "&load_type=1"
//				+ "&trace_tag=%7B%22req_time%22%3A1533802063715%2C%22visitid%22%3A%226892b3db-cc8a-46ff-bcdb-22f85d6079b8%22%2C%22src_page%22%3A%22p_outer%22%2C%22src_block%22%3A%22b_outer%22%2C%22tgt_page%22%3A%22p_homepage%22%2C%22action%22%3A%22click%22%2C%22wm_actual_longitude%22%3A121384230%2C%22wm_actual_latitude%22%3A31272186%2C%22longitude%22%3A%22%22%2C%22latitude%22%3A%22%22%2C%22ctype%22%3A%22wxapp%22%2C%22uuid%22%3A%22af6b4788-42c9-439c-a955-2bc5d6b6ea92%22%2C%22customerid%22%3A161191471%2C%22appversion%22%3A%222.9.1%22%2C%22appname%22%3A%22wxapp%22%2C%22dversion%22%3A%226.6.7%22%2C%22dtype%22%3A%22PIC-AL00%22%2C%22request_id%22%3A%220.22429999433730097%22%2C%22tgt_block%22%3A%22b_poilist%22%7D"
//				+ "&slider_select_data=%22%22&sort_type=0"
//				+ "&category_type=0"
//				+ "&navigate_type=0"
//				+ "&open_id=oOpUI0UK2bx7Kj8aX2VvHSkHsCfs"
//				+ "&uuid=af6b4788-42c9-439c-a955-2bc5d6b6ea92"
//				+ "&platform=13"
//				+ "&partner=4"
//				+ "&riskLevel=1"
//				+ "&user_id=161191471"
//				+ "&userid=161191471"
//				+ "&wm_actual_latitude=31272186"
//				+ "&wm_actual_longitude=121384230"
//				+ "&waimai_sign=%2F&req_time=1533802063717"
//				+ "&userToken=5h0F1SWui7qsGMf1tLaV51k52yIAAAAAKQYAAAnYwNK_1KwjxixD8_lky2FmJlc04W_e-vCp3m7QRWaQYPJ0seTQ8dG68uKtzaJimA"
//				+ "&wm_logintoken=5h0F1SWui7qsGMf1tLaV51k52yIAAAAAKQYAAAnYwNK_1KwjxixD8_lky2FmJlc04W_e-vCp3m7QRWaQYPJ0seTQ8dG68uKtzaJimA"
				+ "&wm_appversion=2.9.1"
				+ "&wm_visitid=6892b3db-cc8a-46ff-bcdb-22f85d6079b8"
				+ "&wm_latitude=26020736"
				+ "&wm_longitude=119398506"
				+ "&wm_uuid=af6b4788-42c9-439c-a955-2bc5d6b6ea92"
				+ "&wm_dversion=6.6.7&wm_dtype=PIC-AL00&wm_ctype=wxapp";
//		while(true){
			
			String paramsTest = "_token=eJxdkN1ugkAQhd9lL3q1cf9YWEiIMZImtkKqorYxxihucasCBSqWpu/eMbVN07mYb+bMuZiZD1QOtshjlFIuMDrpEnmIdWjHRhjVFUyksDinlEklJEbJP01RjDblLEDegnFpY5vK5UUZg7BglFvYsdUS/ymB3Lp4BmBBz+agPUJI3yN1vtfZd15luuns6uOhSxq9Lgpy4qTIDdnlR12sU919M750BIQj+E2pU5NnK7P1uVK2lMKVvyIcVAF9KW1FBbNcRl0FpyHY4BjDBsD9lesr658+hF+AtzJpBpW+O8f3+yJqVftglBtW8fy9CnptFM95FMwmafM6L8ZPsx4/bKYsbPtN9DI6R8NREw37zuMkvq3jhIdpGCR8mg56u8SaTBvfR59f+JlvVw=="
					+ "&page_index=1&page_size=20&load_type=1"
//				+ "&trace_tag=%7B%22req_time%22%3A1533802063715%2C%22visitid%22%3A%229de96c7a-a94f-4dba-ae06-68538a3787ba%22%2C%22src_page%22%3A%22p_outer%22%2C%22src_block%22%3A%22b_outer%22%2C%22tgt_page%22%3A%22p_homepage%22%2C%22action%22%3A%22click%22%2C%22wm_actual_longitude%22%3A118779033%2C%22wm_actual_latitude%22%3A32049693%2C%22longitude%22%3A%22%22%2C%22latitude%22%3A%22%22%2C%22ctype%22%3A%22wxapp%22%2C%22uuid%22%3A%22daa4f8ac-9f1f-470e-8efe-0ca24a306d10%22%2C%22customerid%22%3A161191471%2C%22appversion%22%3A%222.9.1%22%2C%22appname%22%3A%22wxapp%22%2C%22dversion%22%3A%226.6.7%22%2C%22dtype%22%3A%22PIC-AL00%22%2C%22request_id%22%3A%220.22429999433730097%22%2C%22tgt_block%22%3A%22b_poilist%22%7D"
//				+ "&slider_select_data=%22%22"
//				+ "&sort_type=0&category_type=0&navigate_type=0"
//				+ "&open_id=nZyGG7SH7fz1Hh6rO7SxPPeNkXtk"
//				+ "&uuid=daa4f8ac-9f1f-470e-8efe-0ca24a306d10"
//				+ "&platform=13"
//				+ "&partner=4"
//				+ "&riskLevel=1"
//				+ "&user_id=573333732&userid=573333732"
//				+ "&wm_actual_latitude=32049693"
//				+ "&wm_actual_longitude=118779033"
//				+ "&waimai_sign=%2F"
//				+ "&req_time=1533802063717"
//				+ "&userToken=1e4Q4NPrn1ciFFc3nKpC71q34mGFMQPAONJZOAiNpRT_1EumrimE8_ffe8XzQia87H_a-sTr1z2XBIbQLAX6hxJA8tI46qKoadVrsL"
//				+ "&wm_logintoken=1e4Q4NPrn1ciFFc3nKpC71q34mGFMQPAONJZOAiNpRT_1EumrimE8_ffe8XzQia87H_a-sTr1z2XBIbQLAX6hxJA8tI46qKoadVrsL"
				+ "&wm_appversion=2.9.1"
//				+ "&wm_visitid=9de96c7a-a94f-4dba-ae06-68538a3787ba"
//				+ "&wm_latitude=32049693"
//				+ "&wm_longitude=118779033"
				+ "&wm_latitude=30018931"
				+ "&wm_longitude=122122277"
				+ "&wm_uuid=" + UUID.randomUUID().toString()
//				+ "&wm_dversion=6.6.7"
//				+ "&wm_dtype=PIC-AL00"
//				+ "&wm_ctype=wxapp"
				;
			
			HashMap<String, String> data =  new HashMap<String, String>();
			String[] s4 = paramsTest.split("&");
//			for(int i = 0;i < s4.length;i ++){
//				data.put(s4[i].split("=")[0], s4[i].split("=")[1]);
//			}
//			String html = HttpBase.post(url, headers, data);
//			System.out.println("-===-"+html);
			long regionVersion = System.currentTimeMillis()-10*24*60*60*1000;
			System.out.println(regionVersion);
//		}
	}
}
