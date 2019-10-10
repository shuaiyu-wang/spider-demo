package com.bds.tokenTest.test.httpclient;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;

import com.bds.base.http.Response;

public class Http {
	public static String doGet(String url,Map<String, String> headers) throws Exception{
		// 创建Httpclient对象
        HttpClient client = new HttpClient();
        GetMethod getMethod = new GetMethod(url);
        
        if (headers != null) {
			Set<String> keys = headers.keySet();
			for (String k : keys) {
				getMethod.setRequestHeader(k, headers.get(k));
			}
		}

        Header[] _map = getMethod.getResponseHeaders();
		Map<String, String> map = new HashMap<String, String>();
		for (Header h : _map) {
			map.put(h.getName(), h.getValue());
		}
		
		int statusCode = client.executeMethod(getMethod);// 回车——出拳！
		
		if (statusCode == 200) {
			String body = getMethod.getResponseBodyAsString();
			getMethod.releaseConnection();
			Response r = new Response();
			r.setResult(body);
			r.setHeader(map);
			r.setStatus(statusCode);
			getMethod.abort();
			getMethod.releaseConnection();// 释放，记得收拳哦
			return r.getResult();
		}
		if (statusCode == 500) {
			String body = getMethod.getResponseBodyAsString();
			getMethod.releaseConnection();
			if (StringUtils.isNotEmpty(body)) {
				Response r = new Response();
				r.setResult(body);
				r.setHeader(map);
				r.setStatus(statusCode);
				getMethod.abort();
				getMethod.releaseConnection();// 释放，记得收拳哦
				return r.getResult();
			}
			getMethod.abort();
			getMethod.releaseConnection();// 释放，记得收拳哦
			throw new java.net.ConnectException("请求错误,status code is[" + statusCode + "]");
		}
		String body = getMethod.getResponseBodyAsString();
		Response r = new Response();
		r.setResult(body);
		r.setHeader(map);
		r.setStatus(statusCode);
		getMethod.abort();
		getMethod.releaseConnection();// 释放，记得收拳哦
		return r.getResult();
	}
}
