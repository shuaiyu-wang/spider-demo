package com.zmf.hotels;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class RedisTest {
	static Jedis jedis = new Jedis("127.0.0.1", 6379);

	//将评论div存入redis
	public static void setRedisDiv(String hotleId, String div) {
		Map<String, String> map = null;
		String now = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		map = jedis.hgetAll(hotleId);
		map.put(now, div);
		System.out.println(map);
		jedis.hmset(hotleId, map);
		//五小时后过期
		jedis.expire(hotleId, 60*60*5);
	}
	
	public static void main(String[] args) {
		setRedisDiv("1234", "222");
	}
}
