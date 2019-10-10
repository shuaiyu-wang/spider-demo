package com.bds.tokenTest.test.taobao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Tbao {
	public static void main(String[] args) throws Exception {
		String time = "1550828584";
		String sign = "ab20380040078cf86f7751a7981b226158a6a224f4db2b7405";
		String page = "1";
		String keyword = "三轮车";
		String data = "{\"apptimestamp\":\""+time+"\",\"countryCode\":\"CN\",\"countryNum\":\"156\",\"device\":\"HUAWEI MLA-AL10\","
				+ "\"filterEmpty\":\"true\",\"filterUnused\":\"true\",\"from\":\"input\",\"imei\":\"863064010081588\",\"imsi\":\"460070815801213\","
				+ "\"info\":\"wifi\",\"isEnterSrpSearch\":\"true\",\"itemfields\":\"commentCount,newDsr\","
				+ "\"latitude\":\"34.63243\",\"longitude\":\"108.605857\",\"n\":\"10\",\"needTabs\":\"true\",\"network\":\"wifi\","
				+ "\"new_shopstar\":\"true\",\"page\":\""+page+"\",\"q\":\""+keyword+"\",\"rainbow\":\"9272,10080,10378\","
				+ "\"search_action\":\"initiative\",\"search_wap_mall\":\"false\","
				+ "\"setting_on\":\"imgBanners,userdoc,tbcode,pricerange,localshop,smartTips,firstCat,dropbox,realsale,insertTexts,tabs\","
				+ "\"showspu\":\"true\",\"sputips\":\"on\",\"style\":\"list\",\"sversion\":\"3.5\",\"tab\":\"all\","
				+ "\"ttid\":\"700407@taobao_android_6.8.0\",\"utd_id\":\"W0R82MmFWGEDAChj9GRYNN8/\",\"vm\":\"nw\"}";
		String url = "https://acs.m.taobao.com/gw/mtop.taobao.wsearch.appsearch/1.0/?data="+URLEncoder.encode(data, "utf-8");
		String header = "x-umt=HCkIbFbPjzX9wgyWFCpR2qLMULsmXQE6, "
				+ "x-region-channel=CN, x-features=27, x-nettype=WIFI, "
				+ "x-utdid=W0R82MmFWGEDAChj9GRYNN8%2F, "
				+ "user-agent=MTOPSDK%2F3.0.2.1-AVMP+%28Android%3B4.4.2%3BHUAWEI+%3BHUAWEI+MLA-AL10%29, "
				+ "x-nq=WIFI, x-pv=5.1, "
				+ "x-mini-wua=HHnB_QHaDO8GcE1rTXFmF7tRDuBLrL0uVUg%2FSjDJI3eX4htz8NZUbXp5w75iAXoDkZj72AtQdsFasDHIk09wgpVF60xCzdbdARKNfMI8M0ZZU%2Fio%3D, "
				+ "x-location=108.605857%2C34.63243, cache-control=no-cache, x-devid=ArzvAPnzn9TN4pTmbILTYdGLru0ayfDS3paMYTf3cLBR, "
				+ "x-c-traceid=W0R82MmFWGEDAChj9GRYNN8%2F"+time+"886001316071, "
				+ "x-appkey=21646297, "
				+ "x-t="+time+", x-unitinfo=center, x-app-ver=6.8.0, x-ttid=700407%40taobao_android_6.8.0, "
				+ "x-page-url=http%3A%2F%2Fs.m.taobao.com%2Fh5entry, "
				+ "x-sign="+sign+", "
				+ "x-page-name=com.taobao.search.searchdoor.SearchDoorActivity, f-refer=mtop";
		url = "";
//		while(true){
//			try {
				String html = doGet(url, header);
				System.out.println(html);
//				Thread.sleep(2000);
//			} catch (Exception e) {
//				System.out.println(419);
//			}
		}
	
	public static String doGet(String url,String headers) throws Exception{
        URL localUrl = new URL(url);
        URLConnection connection = localUrl.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

        
		String[] headersarray = headers.split(", ");
		for (String string : headersarray) {
			httpURLConnection.setRequestProperty(string.split("=")[0], string.split("=")[1]);
		}

        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;

        if(httpURLConnection.getResponseCode() >=300){
            throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
        }

        try{
            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);

            while((tempLine = reader.readLine()) != null){
                resultBuffer.append(tempLine);
            }
        }finally {
            if(reader != null){
                reader.close();
            }
            if(inputStreamReader != null){
                inputStreamReader.close();
            }
            if(inputStream != null){
                inputStream.close();
            }
        }

        return resultBuffer.toString();
    }
}
