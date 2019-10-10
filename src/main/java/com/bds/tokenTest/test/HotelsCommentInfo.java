package com.bds.tokenTest.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.bds.base.http.HttpBase;

public class HotelsCommentInfo {
	
	
	public static void main(String[] args) {
		
		try {
//			Map<String, String> headers = new HashMap<String, String>();
//			
//			headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8") ;
//			headers.put("Accept-Encoding", "gzip, deflate, br") ;
//			headers.put("Accept-Language", "en,zh-CN;q=0.9,zh;q=0.8") ;
//			headers.put("Cache-Control", "no-cache") ;
//			headers.put("Connection", "keep-alive") ;
//			headers.put("Host", "www.hotels.cn") ;
//			headers.put("Pragma", "no-cache") ;
//			headers.put("Upgrade-Insecure-Requests", "1") ;
//			headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36") ;

//			String html = HttpBase.get("https://www.hotels.cn/ho377504-tr-p4","utf-8",headers).getResult();

			Map<String, String> headers = getHeaders();
//			String url = "https://www.hotels.cn/ho622957280-tr-p1";
			String uurl = "https://www.hotels.cn/ho264699";
//			String html = getResult(url,headers);
			String html = HttpBase.get(uurl, "utf-8", headers).getResult();
			System.out.println(html);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static Map<String, String> getHeaders() {
//		Map<String, String> headers = new HashMap<String, String>();

//		headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//		headers.put("connection", "keep-alive");
//		headers.put("Accept-Encoding", "*");
//		headers.put("Accept-Language", "zh-CN,zh;q=0.9");
//		headers.put("Cache-Control", "max-age=0");
//		headers.put("Host", "www.hotels.cn");
//		headers.put("Upgrade-Insecure-Requests", "1");
//		headers.put("User-Agent",           
//				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.82 Safari/537.36");
//		headers.put("Cookie", 
//				"akacd_pr_7=1535698444~rv=18~id=b93f4ef4434bbf0f3820f9f117e00f88; guid=5eb09fff-2646-4c99-974c-c304cc7943ca; 13211=; _cc=AagyD5HJOfSMrrBUhRNlwlRK; __utma=183086905.33879591.1532933457.1532933457.1532933457.1; __utmz=183086905.1532933457.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); user=QSp6aF9DTnxIQ09NX0NO; _cls_v=4198d4ac-ab77-4014-9220-90e3893908a1; _ga=GA1.2.33879591.1532933457; ens_splitGroup=1; propertyReturningUser=true; __gads=ID=82a35a939abca4a0:T=1532933703:S=ALNI_MaUUpwttOAUwiVQv6-U4McxohwsiQ; VIQ_P1=1533278189329_4629639; asc=1; dr=B~1534133519~5AC61859DDAD9C7BF8BD16F778A0E04EEED60249A82FC9FA82029452C6934315; _gid=GA1.2.1157013616.1534133520; _cls_s=6887f3e4-bc94-46fb-ab1a-6e57f97ff2cf:1; AMCVS_C00802BE5330A8350A490D4C%40AdobeOrg=1; s_cc=true; AMCV_C00802BE5330A8350A490D4C%40AdobeOrg=-1330315163%7CMCIDTS%7C17757%7CMCMID%7C33787292866516603730506214064658872164%7CMCAAMLH-1534399555%7C11%7CMCAAMB-1534738322%7CRKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y%7CMCOPTOUT-1534140721s%7CNONE%7CMCAID%7CNONE; _cls_ready=; SESSID=7zryvu2RolRxBmNzhc48eZhwqB.pda-795dcf579c-7l6vj; _cls_di=6|E0; mvthistory=eJxNkjlyRDEIRG%2BkYmkEUjqJE9tHcDx38OGNBjTl6L%2FftBCLVow5aDyVt0wafBhb3BNoK1GFhTaWjaM%2BY1vKJxwar%2B%2BCvb5MtBoYF2zIObWSZ9QFspkz22VcM7jzQHSs1ccw0T%2BcIaMqLSEqsx7ue42rMnav0jikc4Zz%2Bf3wLHGhQCjWzSaqs2o7jMosOqkhtJw5MRMppyfPdlpYw%2BrkU1G2bEC81NO5RA9SybySSnJEi6vnZVtZtcT3arR7VtyQmRS4lgdEpYB7sjlh1EVIntqi020YvPqIoJNocFcvG5gdNu42%2BLD%2F4yjWw6vNKvdpwcAtAuWMZK8ngNnrxeRel224vh8L7sawoqrPxxgNUtM0qSJ%2FPx7fnz%2BPrz9JfZiy; 52950=2; 49997=Returning; 50105=Unknown; 13210=7zryvu2RolRxBmNzhc48eZhwqB.pda-795dcf579c-7l6vj; 49694=Direct; 50455=Returning; 53868=N; _cls_subs=e0395f36-1076-436b-9837-25da6f3eadfb");
//		return headers;
		
		Map<String, String> headers = new HashMap<String, String>();

		headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		headers.put("Accept-Encoding", "gzip, deflate, br");
		headers.put("Accept-Language", "zh-CN,zh;q=0.9");
		headers.put("Cache-Control", "max-age=0");
		headers.put("Host", "www.hotels.cn");
		headers.put("Upgrade-Insecure-Requests", "1");
		headers.put("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
		headers.put("Connection", "keep-alive");
		headers.put("Host", "www.hotels.cn");
		headers.put("Upgrade-Insecure-Requests", "1");
		headers.put("Cookie", "akacd_pr_7=1535698444~rv=18~id=b93f4ef4434bbf0f3820f9f117e00f88; guid=5eb09fff-2646-4c99-974c-c304cc7943ca; 13211=; _cc=AagyD5HJOfSMrrBUhRNlwlRK; __utma=183086905.33879591.1532933457.1532933457.1532933457.1; __utmz=183086905.1532933457.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); user=QSp6aF9DTnxIQ09NX0NO; _cls_v=4198d4ac-ab77-4014-9220-90e3893908a1; _ga=GA1.2.33879591.1532933457; ens_splitGroup=1; propertyReturningUser=true; __gads=ID=82a35a939abca4a0:T=1532933703:S=ALNI_MaUUpwttOAUwiVQv6-U4McxohwsiQ; VIQ_P1=1533278189329_4629639; asc=1; SESSID=it1xxwxJ2AW-dHuEDQ0-YaCa6B.pda-55cdb997cc-tfjgb; dr=B~1534904575~0AD959189B3B69A63440FE9A53AF9B884935A62FD16D9819BE2F25471F81B6F4; _gid=GA1.2.273720959.1534904576; _cls_s=cbd2e796-d624-4b57-bc30-f9679abbe4a3:1; AMCVS_C00802BE5330A8350A490D4C%40AdobeOrg=1; s_cc=true; AMCV_C00802BE5330A8350A490D4C%40AdobeOrg=-1330315163%7CMCIDTS%7C17766%7CMCMID%7C33787292866516603730506214064658872164%7CMCAAMLH-1535509376%7C11%7CMCAAMB-1535509377%7CRKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y%7CMCOPTOUT-1534911776s%7CNONE%7CMCAID%7CNONE; _cls_ready=; 53868=N; 52950=1; 49997=Returning; 50105=Unknown; 13210=it1xxwxJ2AW-dHuEDQ0-YaCa6B.pda-55cdb997cc-tfjgb; 49694=Direct; 50455=Returning; mvthistory=eJxNkjt2BCAIRXfk4fMQtJ0mTZIlpJ49ZPHBAeek8vpAfrJizEHjqbxl0uDD2OKeQFuJyiy0sWwc9RnbUj7m0Khzrjq99AV7nUy0GhgXbMiJspJnVELZzBn9Mq4zuONAdKzVzzDRF06TUZWaEBVZD3de46qI3atUDumY4Vz%2BfniWuFAgFOtGE2YukdPtVSTHFtW%2BpIei8olOagit9zlXEylPT%2B5RiYU1rE45FR09L17qmYdEj1vJvIJKckSLq6doW1m1xPcHak9CcU1mUuBaPiAqBdzzzrmjEiF5aotOt2Hw6ifStUHQ0ZS4Kvfk2W4a3L3JBq5q3E3yYf%2FHUayHVzur3PWEgVsEyjOSvdYGs1cCk%2FuLLfm24freNNzvxoqy5mZHg1RjJlXt78fj%2B%2FPn8fUHBCWoPA%3D%3D; _cls_di=5.6|E0; _cls_subs=9f955c8a-a41e-40e0-b347-f6d9f0d326bf");
		return headers;
	}
	
	public static String getResult(String urlStr,Map<String, String> headers) {
		
		String result = "" ;
		try {
			 // 1. 得到访问地址的URL
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setDoOutput(false);
//            connection.setDoInput(true);
//            connection.setRequestMethod("GET");
//            connection.setUseCaches(true);
//            connection.setInstanceFollowRedirects(true);
//            connection.setConnectTimeout(3000);
            for(String s : headers.keySet()){
            	connection.setRequestProperty(s, headers.get(s));
            }
//            connection.connect();
//            int code = connection.getResponseCode();
            
//			while(it.hasNext()){
//				Map.Entry entry =  (Map.Entry) it.next();
//				connection.setRequestProperty(entry.getKey().toString(), entry.getValue().toString());
//			}
//            connection.setRequestProperty("Accept-Charset", "utf-8");  
            String msg = "";
//            if (code == 200) { 
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream(),"utf-8"));
                String line = null;

                while ((line = reader.readLine()) != null) { 
                    msg += line + "\n";
                }
                reader.close(); 
//            }
//            connection.disconnect();
            System.out.println(msg);
            result = msg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result ;
	}

}
