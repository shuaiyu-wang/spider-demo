package com._830clock.test.leetCode;

import java.math.BigDecimal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * url:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode/
 * @author wangshuaiyu
 *
 */
public class _007BestTimeToBuyAndSellStock_II {

	public static void main(String[] args) {
		int[] arr = {7,1,5,7,3,6,4};//7,6,4,3,1
		
		//方法三：简单的一次遍历
		int minprice = Integer.MAX_VALUE;
		int maxprice = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] < minprice) {
				minprice = arr[i];
			}else{
				maxprice += arr[i] - minprice;
				minprice = arr[i];
			}
		}
		System.out.println(maxprice);
		
	}
}
