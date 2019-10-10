package com.bds.tokenTest.httpserver;

import java.lang.reflect.Method;


public class Test {
	public String test(){
		System.out.println("aa");
		return "bb";
	}
	
	public static void main(String[] args) throws Exception {
		Class<?> cla = Test.class;
		Method method = cla.getDeclaredMethod("getUserInfo", int.class,String[].class,String[].class,String.class);
		int paramInt = (int) System.currentTimeMillis();
		String paramString = "aweme_id, 6637028597020232974, cursor, 0, count, 20, ts, 1545359071, js_sdk_version, , app_type, normal, openudid, a276804fa6f697e9, version_name, 3.8.0, device_type, iToolsAVM_T0025642S, ssmix, a, iid, 55000717301, os_api, 19, mcc_mnc, 46000, device_id, 60902514577, resolution, 405*720, device_brand, generic, aid, 1128, manifest_version_code, 380, app_name, aweme, _rticket, 1545359077514, os_version, 4.4.4, device_platform, android, version_code, 380, update_version_code, 3802, ac, wifi, dpi, 168, uuid, 352284040667051, language, zh, channel, wandoujia_aweme";
		String[] paramArray = paramString.split(", ");
		Object o = method.invoke(null, paramInt,paramArray,null,"");
		System.out.println(o.toString());
	}
	
	public static native String getUserInfo(int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString);
}
