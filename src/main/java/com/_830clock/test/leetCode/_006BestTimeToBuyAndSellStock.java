package com._830clock.test.leetCode;

/**
 * url:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @author wangshuaiyu
 *
 */
public class _006BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		int[] arr = {7,1,5,3,6,4};//7,6,4,3,1
		int j = 0;
		int max = 0;
		while(j<arr.length - 1) {
			for (int i = j+1; i < arr.length; i++) {
				int sellStock = arr[i];
				if((sellStock - arr[j]) > 0 && (sellStock - arr[j]) > max) {
					max = sellStock - arr[j];
				}
			}
			j++;
		}
		System.out.println(max);
		
		//方法二：一次遍历
		int minprice = Integer.MAX_VALUE;
		int maxprice = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] < minprice) {
				minprice = arr[i];
			}else if((arr[i] - minprice) > maxprice) {
				maxprice = arr[i] - minprice;
			}
		}
		System.out.println(maxprice);
	}
}
