package com.bds.tokenTest.test.douyin;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class Test {
	public static void main(String[] args) {
		List<String> paramList = new ArrayList<String>();
		//aweme_id, 6637028597020232974, cursor, 0, count, 20, ts, 1545359071, js_sdk_version, , app_type, normal, openudid, a276804fa6f697e9, version_name, 3.8.0, device_type, iToolsAVM_T0025642S, ssmix, a, iid, 55000717301, os_api, 19, mcc_mnc, 46000, device_id, 60902514577, resolution, 405*720, device_brand, generic, aid, 1128, manifest_version_code, 380, app_name, aweme, _rticket, 1545359077514, os_version, 4.4.4, device_platform, android, version_code, 380, update_version_code, 3802, ac, wifi, dpi, 168, uuid, 352284040667051, language, zh, channel, wandoujia_aweme
		paramList.add("aweme_id");
		paramList.add("6637028597020232974");
		int paramInt = (int) System.currentTimeMillis();
		String localObject1 = "";
		String paramListString = getUserInfo(paramInt, (String[])paramList.toArray(new String[paramList.size()]), null, localObject1);
		paramListString = "a1b51df227e87c15e14877d58cce51761f235be1ukco";
//		while(true){
			paramInt = paramListString.length();
			System.out.println(paramListString);
			if(StringUtils.isNotEmpty(paramListString)){
				if(paramInt % 2 == 0){
					localObject1 = paramListString.substring(0, paramInt >> 1);
					paramListString = paramListString.substring(paramInt >> 1, paramInt);
					String localObject2 = a(a2(localObject1.getBytes()));
				}
			}
//		}
	}
	
	public static String a(byte[] paramArrayOfByte){
		char[] localObject = "0123456789abcdef".toCharArray();
		char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
	    int i = 0;
	    while (i < paramArrayOfByte.length)
	    {
	      int j = paramArrayOfByte[i] & 0xFF;
	      arrayOfChar[(i * 2)] = localObject[(j >>> 4)];
	      arrayOfChar[(i * 2 + 1)] = localObject[(j & 0xF)];
	      i += 1;
	    }
	    return new String(arrayOfChar);
	}
	
	public static String getUserInfo(int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString){
		return "";
	}
	
	public static byte[] a2(byte[] paramArrayOfByte){
		return null;
	}
	
	
}
