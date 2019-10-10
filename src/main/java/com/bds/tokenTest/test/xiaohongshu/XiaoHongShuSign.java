package com.bds.tokenTest.test.xiaohongshu;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

public class XiaoHongShuSign {

	private static String CHARSET = "UTF-8";
	//public static String CHARSET = "GBK";
	//public static String CHARSET = "GB2312";
	
	public static void main(String[] args)throws Exception {
//		List<String> all = FileUtils.readLines(new File("C:\\test\\xhs\\all.txt"));
//		List<String> list = FileUtils.readLines(new File("C:\\test\\xhs\\id.txt"));
//		List<String> a =(List<String>) CollectionUtils.subtract(all, list);
//		for(String s : a) {
//			System.out.println(s);
//		}
		
		System.out.println(System.currentTimeMillis()/1000);
		//platform=Android&deviceId=fa8265c4-f929-3900-90bf-ac6d321cc6ab&device_fingerprint=20180705144829b2d01289b09f5de74eb538aa504475320139e69c689426dc&device_fingerprint1=20180705144829b2d01289b09f5de74eb538aa504475320139e69c689426dc&versionName=5.23.0&channel=Store360&lang=zh-Hans&t=1534752573&sign=5bab61c6342a2db879f0ddb96675c909
		String data = "start=5b8165d0808adf0001781eb9&num=20&show_priority_sub_comments=0&platform=Android&deviceId=fa8265c4-f929-3900-90bf-ac6d321cc6ab&device_fingerprint=20180705144829b2d01289b09f5de74eb538aa504475320139e69c689426dc&device_fingerprint1=20180705144829b2d01289b09f5de74eb538aa504475320139e69c689426dc&versionName=5.23.0&channel=Store360&sid=session.1219282677194667089&lang=zh-Hans&t=1536032383";
//		GET https://www.xiaohongshu.com/api/sns/v8/search/notes?keyword=%E9%9D%A2%E9%9C%9C&sort=time_descending&page=1&page_size=20&source=explore_feed&search_id=E43D9CD05FFF8CF3A7CEB2019D0C14DD&platform=Android&deviceId=fa8265c4-f929-3900-90bf-ac6d321cc6ab&device_fingerprint=20180705144829b2d01289b09f5de74eb538aa504475320139e69c689426dc&device_fingerprint1=20180705144829b2d01289b09f5de74eb538aa504475320139e69c689426dc&versionName=5.23.0&channel=Store360&sid=session.1219282677194667089&lang=zh-Hans&t=1535214065&sign=73fd1b868f7e6636dd738a63d55f7c8e HTTP/1.1
//			X-Tingyun-Id: LbxHzUNcfig;c=2;r=1010297407;
//			Authorization: session.1219282677194667089
//			device_id: fa8265c4-f929-3900-90bf-ac6d321cc6ab
//			User-Agent: Dalvik/1.6.0 (Linux; U; Android 4.4.2; MI 6  Build/NMF26X) Resolution/720*1280 Version/5.23.0 Build/5230179 Device/(Xiaomi ;MI 6 )
//			shield: 
//			Host: www.xiaohongshu.com
//			Connection: Keep-Alive
//			Accept-Encoding: gzip
//

		
		
		XiaoHongShuSign xhssign = new XiaoHongShuSign();
		//&sign=0a87fdb46369c6948f410d1a3f8253af
		data = "page=2&num=5&fetch_mode=3&source=search%26keyword%3D%E9%9D%A2%E8%86%9C&platform=android&deviceId=ad038991-1078-3b40-842d-389b0d6ab5a6&device_fingerprint=2019021318032049b973f3e0510d3621ea02c29d13117001a9cb7cd7d4f6ac&device_fingerprint1=2019021318032049b973f3e0510d3621ea02c29d13117001a9cb7cd7d4f6ac&versionName=5.39.1&channel=Store360&sid=session.1550052198553742928&lang=zh-Hans&t=1550744112";
		data = URLDecoder.decode(data, "utf-8");
		String sign = xhssign.sign(data);
		System.out.println("&sign=581ae6c430f05d7f0cf40644befa16a8");
		System.out.println("&sign="+sign);
		sign = xhssign.old_sign(data);
		System.out.println("&sign="+sign);
		

	}
	
	 public String a(Map<String, String> map) throws Exception
	  {
	    int i = 0;
	    if ((map == null) || (map.isEmpty())) {
	      return "";
	    }
	    String str1 = (String)map.get("deviceId");
	    List<String> list = new ArrayList<String>();
	    list.addAll(map.keySet());
	    Collections.sort(list);
	    StringBuilder localObject1 = new StringBuilder();
	    Iterator<String> it = list.iterator();
	    while (it.hasNext())
	    {
	      String str2 = it.next();
	      localObject1.append(str2);
	      localObject1.append("=");
	      localObject1.append((String)map.get(str2));
	    }
	    byte[] paramMap = new byte[1];
	    try
	    {
	    	paramMap = java.net.URLEncoder.encode(localObject1.toString(), "UTF-8").getBytes();
	    }
	    catch (UnsupportedEncodingException localUnsupportedEncodingException)
	    {
	      for (;;)
	      {
	        int j;
	        localUnsupportedEncodingException.printStackTrace();
	      }
	    }
	    byte[] sbs = str1.getBytes();
	    StringBuilder sb2 = new StringBuilder();
	    int j = 0;
	    while (i < paramMap.length)
	    {
	    	sb2.append(paramMap[i] ^ sbs[j]);
	      j = (j + 1) % sbs.length;
	      i += 1;
	    }
	    return MD5Util.a(MD5Util.a(sb2.toString()).toLowerCase() + str1).toLowerCase();
	  }
	 
	 
	 public String sign(String s) throws Exception {
		 String[] ss = s.split("&");
		 Map<String,String> map = new HashMap<String,String>();
		 for(String as : ss) {
			String[] aa = as.split("=");
			if(aa.length == 1) {
				map.put(aa[0],"");
			}else {
				map.put(aa[0], aa[1]);
			}
		 }
		 return a(map);
	 }
	
	public String old_sign(String pass) throws Exception {

		String total = "";
		String[] ss = pass.split("&");
		 Map<String,String> map = new HashMap<String,String>();
		 for(String as : ss) {
			String[] aa = as.split("=");
			if(aa.length == 1) {
				map.put(aa[0],"");
			}else {
				map.put(aa[0], aa[1]);
			}
		 }
		String devid = map.get ("deviceId");
		String[] pass数组 = new String[map.keySet().size()];
		int a=0;
		for(String k :map.keySet()) {
			pass数组[a++]=k;
		}
		Arrays.sort(pass数组);
		for(String s : pass数组) {
			total = total + s+"="+map.get(s);
		}
		total = java.net.URLEncoder.encode(total,"UTF-8");
		//total = total.replaceAll("%5F", "_");
		byte[] 字节  = total.getBytes(CHARSET);
		byte[] 字节2  = devid.getBytes(CHARSET);
		int i=0;
		int j=0;
		total = "";
		do {
		   int 结果 = 字节[i] ^ 字节2[j];
		   total=total + 结果;
		    j =(j+1) %  字节2.length;
		    i = i+1;
		}while(i < 字节.length);
		String sign = DigestUtils.md5Hex((DigestUtils.md5Hex((total).getBytes(CHARSET))+devid).getBytes(CHARSET));
		//System.out.println(sign);
		return sign;
	}
	
//	private String subString(String content,String begin, String end) {
//		if (content == null || content.equals("")) {
//			return content;
//		}
//		int index_s = 0;
//		if (begin != null) {
//			index_s = content.indexOf(begin) + begin.length();
//		}
//		String _end = content.substring(index_s, content.length());
//		int index_e = 0;
//
//		if (end == null) {
//			index_e = content.length();
//		} else {
//			index_e = _end.indexOf(end);
//		}
//		return _end.substring(0, index_e);
//	}
	
	
}
