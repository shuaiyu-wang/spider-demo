package com.bds.tokenTest.test.meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Set;

public class MeituanPost {
	public synchronized static String post(String url, Map<String, String> header, Map<String, String> params)
			throws ConnectException {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			if (header != null && !header.isEmpty()) {
				Set<String> headers = header.keySet();
				for (String key : headers) {
					conn.setRequestProperty(key, header.get(key));
				}
			}

			/**
			 * 参数
			 */
			StringBuffer p = new StringBuffer();
			if (params != null && !params.isEmpty()) {
				Set<String> param = params.keySet();
				for (String k : param) {
					p.append(k + "=" + params.get(k) + "&");
				}
			}

			if (p.length() > 0) {
				p = p.deleteCharAt(p.length() - 1);
			}

			// 发送POST请求必须设置如下两行
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(30000);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(p.toString());
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			throw new java.net.ConnectException("请求错误,status code is[" + result + "]");
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			
		}
		try {
			long time =(long) Math.random()*1000 ;
			Thread.sleep(2500 + time);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}
