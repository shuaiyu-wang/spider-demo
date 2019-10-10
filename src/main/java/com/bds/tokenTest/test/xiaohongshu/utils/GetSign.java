package com.bds.tokenTest.test.xiaohongshu.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class GetSign {
	
	private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
	
	public static void main(String[] args) throws Exception {
		
		String url = "https://www.xiaohongshu.com/api/sns/v1/note/5c14b934000000000a01a162/feed?page=1&num=5&fetch_mode=3&source=search%26keyword%3D%E9%9D%A2%E8%86%9C&platform=android&deviceId=d3328933-a752-35c2-bc0b-f6932fd7f891&device_fingerprint=201903041136396d72e8dedf5e4f8167d1a2d6d3bca25001459d0190673848&device_fingerprint1=201903041136396d72e8dedf5e4f8167d1a2d6d3bca25001459d0190673848&versionName=5.39.1&channel=Store360&sid=session.1551670607680425770880&lang=zh-Hans&t=1552457284&sign=be654e2690a39c9514894ede73d4d944";
		
		//noteInfo
		Map<String, String> map = new HashMap<String, String>();
		String deviceId = "d3328933-a752-35c2-bc0b-f6932fd7f891";
		String fingerprint = "201903041136396d72e8dedf5e4f8167d1a2d6d3bca25001459d0190673848";
		String sid = "1551670607680425770880";
		String time = "1552457284";
		String keyword = "面膜";
		
		map.put("page", "1");
		map.put("num", "5");
		map.put("fetch_mode", "3");
		map.put("source", "search&keyword="+keyword);
		map.put("platform", "android");
		map.put("deviceId", deviceId);
		map.put("device_fingerprint", fingerprint);
		map.put("device_fingerprint1", fingerprint);
		map.put("versionName", "5.39.1");
		map.put("channel", "Store360");
		map.put("sid", "session."+sid);
		map.put("lang", "zh-Hans");
		map.put("t", time);
		
		String maps = "page=1&num=5&fetch_mode=3"
				+ "&source=search%26keyword%3D%E9%9D%A2%E8%86%9C&platform=android&deviceId=d3328933-a752-35c2-bc0b-f6932fd7f891&device_fingerprint=201903041136396d72e8dedf5e4f8167d1a2d6d3bca25001459d0190673848&device_fingerprint1=201903041136396d72e8dedf5e4f8167d1a2d6d3bca25001459d0190673848&versionName=5.39.1&channel=Store360&sid=session.1551670607680425770880&lang=zh-Hans&t=1552457284";
//		String[] s = maps.split("&");
//		for (String string : s) {
//			String str = "";
//			if(string.split("=",-1)[0].equals("source")){
//				str = URLDecoder.decode(string.split("=",-1)[1],"utf-8");
//				map.put(string.split("=",-1)[0], str);
//				continue;
//			}
//			map.put(string.split("=",-1)[0], string.split("=",-1)[1]);
//		}
		System.out.println(getSign(maps));
		
	}
	
	public static String getSign(String mapStr){
		String str = "d3328933-a752-35c2-bc0b-f6932fd7f891";//deviceId
		
		String[] mapArr = mapStr.split("&");
		Map<String, String> map = new HashMap<String, String>();
		for (String string : mapArr) {
			String[] kv = string.split("=",2);
			if(kv[0].equals("source")){
				map.put(kv[0], "search&keyword=面膜");
				continue;
			}
			map.put(kv[0], kv[1]);
		}
		List<String> list = new ArrayList<>();
		list.addAll(map.keySet());
		Collections.sort(list);
		Iterator<String> itor = list.iterator();
		StringBuilder sb = new StringBuilder();
		while(itor.hasNext()){
			String str2 = itor.next();
			sb.append(str2);
			sb.append("=");
			sb.append(map.get(str2));
		}
		
		byte[] paramMap = new byte[1];
		try {
			//
			String localObject1 = xhsUtils.handleSb(sb.toString(), "UTF-8");
//			System.out.println(sb.toString());
//			System.out.println("channel=Store360deviceId=d3328933-a752-35c2-bc0b-f6932fd7f891device_fingerprint=201903041136396d72e8dedf5e4f8167d1a2d6d3bca25001459d0190673848device_fingerprint1=201903041136396d72e8dedf5e4f8167d1a2d6d3bca25001459d0190673848fetch_mode=3lang=zh-Hansnum=5page=1platform=androidsid=session.1551670607680425770880source=search&keyword=面膜t=1552457284versionName=5.39.1");
			System.out.println(localObject1);
//			System.out.println("channel%3DStore360deviceId%3Dd3328933-a752-35c2-bc0b-f6932fd7f891device_fingerprint%3D201903041136396d72e8dedf5e4f8167d1a2d6d3bca25001459d0190673848device_fingerprint1%3D201903041136396d72e8dedf5e4f8167d1a2d6d3bca25001459d0190673848fetch_mode%3D3lang%3Dzh-Hansnum%3D5page%3D1platform%3Dandroidsid%3Dsession.1551670607680425770880source%3Dsearch%26keyword%3D%E9%9D%A2%E8%86%9Ct%3D1552457284versionName%3D5.39.1");
			//
			Charset localObject2 = Charset.forName("UTF-8");
//			
			byte[] localObjec4 = localObject1.getBytes(localObject2);
//          map = localObject4;
			paramMap = localObjec4;
			
			
			byte[] localObject3 = str.getBytes(localObject2);
	        StringBuilder localObject4 = new StringBuilder();
	        int i3 = paramMap.length;
	        int i1 = 0;
	        int i2 = 0;
	        while (i1 < i3)
	        {
	          localObject4.append(Byte.valueOf((byte)(paramMap[i1] ^ localObject3[i2])));
	          i2 = (i2 + 1) % localObject3.length;
	          i1 += 1;
	        }
	        StringBuilder paramMap2 = new StringBuilder();
	        String localObject5 = localObject4.toString();
	        String localObject6 = a(localObject5);
	        if (localObject6 != null)
	        {
	          localObject6 = localObject6.toLowerCase();
	          paramMap2.append(localObject6);
	          paramMap2.append(str);
	          String paramMap3 = a(paramMap2.toString());
	          if (paramMap3 != null)
	          {
	            paramMap3 = paramMap3.toLowerCase();
	            return paramMap3;
	          }
//	          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
	        }
		} catch (UnsupportedEncodingException e) {
//			Charset localObject2 = Charset.forName("UTF-8");
//			byte[] localObject3 = str.getBytes(localObject2);
//	        StringBuilder localObject4 = new StringBuilder();
//	        int i3 = paramMap.length;
//	        int i1 = 0;
//	        int i2 = 0;
//	        while (i1 < i3)
//	        {
//	          localObject4.append(Byte.valueOf((byte)(paramMap[i1] ^ localObject3[i2])));
//	          i2 = (i2 + 1) % localObject3.length;
//	          i1 += 1;
//	        }
//	        StringBuilder paramMap2 = new StringBuilder();
//	        String localObject5 = localObject4.toString();
//	        String localObject6 = a(localObject5);
//	        if (localObject6 != null)
//	        {
//	          localObject6 = localObject6.toLowerCase();
//	          paramMap2.append(localObject6);
//	          paramMap2.append(str);
//	          String paramMap3 = a(paramMap2.toString());
//	          if (paramMap3 != null)
//	          {
//	            paramMap3 = paramMap3.toLowerCase();
//	            return paramMap3;
//	          }
//	          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
//	        }
		}
		return "";
	}
	
	public static final String a(String paramString)
	  {
	      Charset localCharset = Charset.forName("utf-8");
	      byte[] paramString2 = paramString.getBytes(localCharset);
	      paramString = a(paramString2);
	      return paramString;
	  }
	
	
	private static String a(byte[] paramArrayOfByte){
	      try
	      {
	    	MessageDigest localObject = MessageDigest.getInstance("MD5");
	        localObject.update(paramArrayOfByte);
	        paramArrayOfByte = localObject.digest();
	        if (paramArrayOfByte != null)
	        {
	          int k = paramArrayOfByte.length;
	          char[] localObject2 = new char[k * 2];
	          for(int x = 0 ;x<paramArrayOfByte.length;x++){
	              int o = paramArrayOfByte[x];
	              int m = x * 2;
	              localObject2[m] = a[(o >>> 4 & 0xF)];
	              localObject2[(m + 1)] = a[(o & 0xF)];
	          }
	          return new String(localObject2);
	        }
	        else
	        {
	          return "";
	        }
	      }
	      catch (NoSuchAlgorithmException e)
	      {
	        e.printStackTrace();
	        return "";
	      }
	}
	
	
	

}
