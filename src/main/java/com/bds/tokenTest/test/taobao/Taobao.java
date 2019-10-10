package com.bds.tokenTest.test.taobao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.bds.base.http.HttpBase;

public class Taobao {
	public static void main(String[] args) throws Exception {
		
		String page = "1";
		String keyword = "三轮车";
//		String cat = "50031311";
		String sort = "&sort=false";
		String type = "&type=tmall";
		//211.152.47.81
		
		//查看后台进程
//		Process process = Runtime.getRuntime().exec("cmd /c adb shell ps | findstr taobao");
//		Thread.sleep(3000);
//		process.destroy();
//		InputStreamReader si = new InputStreamReader(process.getInputStream(),"utf-8");
//		BufferedReader br = new BufferedReader(si);
//		String brline = null;
//		StringBuffer sb = new StringBuffer();
//		while((brline = br.readLine())!=null){
//			sb.append(brline);
//		}
//		System.out.println(sb);
//		if(!sb.toString().contains("taobao")){
//			//不存在则启动
//			process = Runtime.getRuntime().exec("cmd /c adb shell am start -n com.taobao.taobao/com.taobao.tao.homepage.MainActivity3");
//			Thread.sleep(10000);//等待andserver
//		}
//		process.destroy();
//		
//		if(si!=null){
//			si.close();
//		}
//		if(br!=null){
//			br.close();
//		}
		
		
		String u = "http://211.152.47.81:8888/hello?p=1&k="+URLEncoder.encode(keyword, "utf-8")+sort+type;
		String htm = HttpBase.get(u, "utf-8").getResult();
		JSONObject jo = new JSONObject(htm);
		String url = jo.getString("url");
		String header = jo.getString("header");
		System.out.println(url);
		System.out.println(header);
		
		try {
			String html = doGet(url,header);
			System.out.println(html);
		} catch (Exception e) {
			for(int i = 0;i<2;i++){
				try {
					String html = doGet(url,header);
					System.out.println(html);
					break;
				} catch (Exception e1) {
					if(i==1){
						System.out.println(419);
					}
				}
			}
		}
	}
	
//	public static String doPost(String url,String param) throws Exception{
//        String parameterData = param;
//
//        URL localUrl = new URL(url);
//        URLConnection connection = localUrl.openConnection();
//        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
//
//        httpURLConnection.setDoOutput(true);
//        httpURLConnection.setRequestMethod("POST");
//        
//        String headers = "x-umt=HCkIbFbPjzX9wgyWFCpR2qLMULsmXQE6, x-region-channel=CN, x-features=27, x-nettype=WIFI, x-utdid=W0R82MmFWGEDAChj9GRYNN8%2F, user-agent=MTOPSDK%2F3.0.2.1-AVMP+%28Android%3B4.4.2%3BHUAWEI+%3BHUAWEI+MLA-AL10%29, x-nq=WIFI, x-pv=5.1, x-mini-wua=HHnB_YLiAEu19YRXAnz%2FLnhLixMslMVREXQVMBmUYbWj0ywzcbtgIMPjr1i7kv7TyiFPVF3c3f05rHpdjNKz8cKqi7yBMBcw5BmUVk7b%2FII78toU%3D, x-location=108.605285%2C34.632517, cache-control=no-cache, x-devid=ArzvAPnzn9TN4pTmbILTYdGLru0ayfDS3paMYTf3cLBR, x-c-traceid=W0R82MmFWGEDAChj9GRYNN8%2F15474557538820017128662, x-appkey=21646297, x-t=1547455753, x-unitinfo=unsz, x-app-ver=6.8.0, x-ttid=700407%40taobao_android_6.8.0, x-page-url=http%3A%2F%2Fs.m.taobao.com%2Fsearch.htm, x-sign=ab2038004055330f0b6e04ad615691036a0172d3d1ac9937b0, x-page-name=com.taobao.search.mmd.SearchResultActivity, f-refer=mtop";
//		String[] headersarray = headers.split(", ");
//		for (String string : headersarray) {
//			httpURLConnection.setRequestProperty(string.split("=")[0], string.split("=")[1]);
//		}
////        httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
////        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
////        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(parameterData.length()));
////        httpURLConnection.setRequestProperty("Host", "acs.m.taobao.com");
//
//        OutputStream outputStream = null;
//        OutputStreamWriter outputStreamWriter = null;
//        InputStream inputStream = null;
//        InputStreamReader inputStreamReader = null;
//        BufferedReader reader = null;
//        StringBuffer resultBuffer = new StringBuffer();
//        String tempLine = null;
//
//        try{
//            outputStream = httpURLConnection.getOutputStream();
//            outputStreamWriter = new OutputStreamWriter(outputStream);
//
//            outputStreamWriter.write(parameterData.toString());
//            outputStreamWriter.flush();
//
//            if(httpURLConnection.getResponseCode() >=300){
//                throw  new Exception("HTTP Response is not sucess, Response code is " + httpURLConnection.getResponseCode());
//            }
//
//            inputStream = httpURLConnection.getInputStream();
//            inputStreamReader = new InputStreamReader(inputStream);
//            reader = new BufferedReader(inputStreamReader);
//
//            while((tempLine = reader.readLine()) != null){
//                resultBuffer.append(tempLine);
//            }
//
//        }finally{
//            if(outputStreamWriter != null){
//                outputStreamWriter.close();
//            }
//            if(outputStream != null){
//                outputStream.close();
//            }
//            if(reader != null){
//                reader .close();
//            }
//            if(inputStreamReader != null){
//                inputStreamReader.close();
//            }
//            if(inputStream != null){
//                inputStream.close();
//            }
//        }
//        return resultBuffer.toString();
//    }
	
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
            inputStreamReader = new InputStreamReader(inputStream,"utf-8");
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
