package com._830clock.test.leetCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * url：https://leetcode-cn.com/problems/single-number
 * @author wangshuaiyu
 *
 */
public class _009Single_number {

	public static void main(String[] args) {
		int[] arr = {4,1,2,1,2,4,7,7};
		System.out.println(getParam(arr));//-1表示不存在
		System.out.println(getParamByHash(arr));//-1表示不存在
		System.out.println(getParamByXor(arr));//0表示不存在
	}
	
	//方法一：暴力查找
	public static int getParam(int[] arr) {
		Arrays.parallelSort(arr);
		int param = -1;
		for(int i = 0;i < arr.length - 1;i++) {
			boolean flag = false;
			for(int j = 0;j<arr.length;j++) {//从0开始，否则相同的两个，后面的无法和前面的验证
				if(arr[i] == arr[j] && j!=i) {//j!=i，相同位置的不比较
					flag = true;
					break;
				}
			}
			if(!flag) {
				param = arr[i];
			}
		}
		return param;
	}
	//方法二：hash表
	public static int getParamByHash(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			Integer count = map.get(arr[i]);
			count = count == null ? 1 : ++count;
			map.put(arr[i], count);
		}
		for (Integer key : map.keySet()) {//遍历map的键
			if(map.get(key) == 1) {
				return key;
			}
		}
		return -1;
	}
	/**
	 * 方法三：异或
	 * a^0=a
	 * a^a=0
	 * a^b^a=(a^a)^b=0^b=b
	 * @param arr
	 * @return
	 */
	public static int getParamByXor(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int param = arr[0];
		for (int i = 1; i < arr.length; i++) {
			param = param^arr[i];
		}
		return param;
	}
}
