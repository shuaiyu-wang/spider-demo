package com._830clock.test.leetCode;

import java.util.Arrays;
/**
 * url:https://leetcode-cn.com/problems/merge-sorted-array/
 * @author wangshuaiyu
 *
 */

public class _004Merge_sorted_array {

	
	public static void main(String[] args) {
		int[] nums1 = new int[] {1,2,3,0,0,0};
		int[] nums2 = new int[] {2,5,6};
		//合并之后再排序
		System.arraycopy(nums2, 0, nums1, 3, 3);//把nums2拷贝到nums1中去
		Arrays.sort(nums1);//正序排列
		for (int i : nums1) {
			System.out.println(i);
		}
	}
}
