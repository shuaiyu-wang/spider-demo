package com.bds.tokenTest.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;
import org.nutz.dao.impl.NutDao;

public class Util {
	
	public static void contentToTxt(String filePath, String content) {
        try{
        	FileWriter fw = new FileWriter(new File(filePath),true);//true:续写;false:覆盖
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(content+"\r\n");
            writer.flush();
            writer.close();
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
	
	public static NutDao getMysqlDao() {
		org.apache.commons.dbcp.BasicDataSource dataSource = new org.apache.commons.dbcp.BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://rou1.bds-analytics.com:13003/h_ctrip_adhoc?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
		dataSource.setUsername("new_root");
		dataSource.setPassword("@Hyipsos");
		NutDao dao = new NutDao(dataSource);
		return dao;
	}
	
	public synchronized static String replaceCharRandomly(String str) {
//		System.out.println("传入的字符串为："+str);
		StringBuffer result = new StringBuffer();
		char[] cs = str.toCharArray();
		Random random = new Random();
		int num = 0 ;
		for (int i = 0; i < cs.length; i++) {

			if (cs[i] >= 48 && cs[i] <= 57) {
				//数字
				//第一位数字不为0
				int ran = random.nextInt(10);
				if (num == 0) {
					if (ran == 0 ) {
						ran += 1 ;
					}
				}
				result.append(ran);
			}else if (cs[i] >= 65 && cs[i] <= 90) {
				//大写字母
				result.append((char)(65 + random.nextInt(26)));
			}else if (cs[i] >= 97 && cs[i] <= 122) {
				//小写字母
				result.append((char)(97 + random.nextInt(26)));
			}else {
				//特殊符号返回本身
				result.append(cs[i]);
			}
		}
//		System.out.println("传出的字符串为："+result.toString());
		return result.toString() ;
	}
	
	public static String doGet(String url,Map<String,String> headers) throws Exception{
        URL localUrl = new URL(url);
        URLConnection connection = localUrl.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
        
        if(headers != null){
        	for(String key:headers.keySet()){
        		httpURLConnection.setRequestProperty(key, headers.get(key));
        	}
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
	
	public static String doPost(String url,String param) throws Exception{
        String parameterData = param;

        URL localUrl = new URL(url);
        URLConnection connection = localUrl.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        
        String headers = "x-umt=HCkIbFbPjzX9wgyWFCpR2qLMULsmXQE6, x-region-channel=CN, x-features=27, x-nettype=WIFI, x-utdid=W0R82MmFWGEDAChj9GRYNN8%2F, user-agent=MTOPSDK%2F3.0.2.1-AVMP+%28Android%3B4.4.2%3BHUAWEI+%3BHUAWEI+MLA-AL10%29, x-nq=WIFI, x-pv=5.1, x-mini-wua=HHnB_YLiAEu19YRXAnz%2FLnhLixMslMVREXQVMBmUYbWj0ywzcbtgIMPjr1i7kv7TyiFPVF3c3f05rHpdjNKz8cKqi7yBMBcw5BmUVk7b%2FII78toU%3D, x-location=108.605285%2C34.632517, cache-control=no-cache, x-devid=ArzvAPnzn9TN4pTmbILTYdGLru0ayfDS3paMYTf3cLBR, x-c-traceid=W0R82MmFWGEDAChj9GRYNN8%2F15474557538820017128662, x-appkey=21646297, x-t=1547455753, x-unitinfo=unsz, x-app-ver=6.8.0, x-ttid=700407%40taobao_android_6.8.0, x-page-url=http%3A%2F%2Fs.m.taobao.com%2Fsearch.htm, x-sign=ab2038004055330f0b6e04ad615691036a0172d3d1ac9937b0, x-page-name=com.taobao.search.mmd.SearchResultActivity, f-refer=mtop";
		String[] headersarray = headers.split(", ");
		for (String string : headersarray) {
			httpURLConnection.setRequestProperty(string.split("=")[0], string.split("=")[1]);
		}
//        httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
//        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(parameterData.length()));
//        httpURLConnection.setRequestProperty("Host", "acs.m.taobao.com");

        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;

        try{
            outputStream = httpURLConnection.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);

            outputStreamWriter.write(parameterData.toString());
            outputStreamWriter.flush();

            if(httpURLConnection.getResponseCode() >=300){
                throw  new Exception("HTTP Response is not sucess, Response code is " + httpURLConnection.getResponseCode());
            }

            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);

            while((tempLine = reader.readLine()) != null){
                resultBuffer.append(tempLine);
            }

        }finally{
            if(outputStreamWriter != null){
                outputStreamWriter.close();
            }
            if(outputStream != null){
                outputStream.close();
            }
            if(reader != null){
                reader .close();
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
	
	/**
	 * /5分&nbsp;&nbsp; 96%用户推荐
	 * @param s
	 * @param t %用户推荐
	 * @return 96
	 */
	public static String parseNumberBefore(String s,String t){
		int index = s.indexOf(t)-1;
		if(index == -1){
			return "";
		}
		String cc = "0123456789.";
		String c;
		String ss="";
		for(int i=index;i>=0;i--){
			c = s.charAt(i)+"";
			if(cc.contains(c)){
				ss=c+ss;
			}else{
				break;
			}
		}
		return ss;
	}
	
	
	/**
	 * 本 >> \u672c
	 * 
	 * @param s
	 * @return
	 */
	public static String toUnicode(String s) {
		if (s == null) {
			return null;
		}
		final StringBuffer buffer = new StringBuffer();
		for (char ch : s.toCharArray()) {
			if (ch > 128) {
				buffer.append("\\u" + Integer.toHexString(ch));
			} else {
				buffer.append(ch);
			}
		}
		return buffer.toString();
	}

	/**
	 * \u672c >> 本
	 * 
	 * @param dataStr
	 * @return
	 */
	public static String decodeUnicode(String dataStr) {
		int start = 0;
		int end = 0;
		final StringBuffer buffer = new StringBuffer();
		while (start > -1) {
			start = dataStr.indexOf(File.separator + "u");
			end = start + 6;
			String charStr = "";
			if (start != -1) {
				buffer.append(dataStr.substring(0, start));
				charStr = dataStr.substring(start + 2, end);
				char letter = (char) Integer.parseInt(charStr, 16);
				buffer.append(new Character(letter).toString());
				dataStr = dataStr.substring(end, dataStr.length());
			} else {
				buffer.append(dataStr);
			}
		}
		return buffer.toString();
	}
	
	public static String stringFilter(String str) {
		// 只允许字母和数字
		// String regEx = "[^a-zA-Z0-9]";
		// 清除掉所有特殊字符
		try {
			String regEx = "[ `~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(str);
			return m.replaceAll("").trim();
		} catch (Exception e) {
			return str;
		}
	}
	
	public static String getMd5(String source) {
		return DigestUtils.md5Hex(source);
	}
	
	/**
	 * 优先抓取2018年10月1号后的数据
	 * @param commDate
	 * @return
	 * @throws ParseException
	 */
	public static boolean isEffectiveDate(Date commDate) throws ParseException {
		String d = "2018年10月01日";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		Date startTime = sdf.parse(d);
        if (commDate.getTime() == startTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(commDate);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

		return date.after(begin);
    }
	
}
