package com._830clock.test.leetCode;

/**
 * url: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/
 * @author wangshuaiyu
 *
 */
public class _002Remove_duplicates_from_sorted_array {

	public static void main(String[] args) {
		int[] array = new int[] {1,1,2,2,2,3,5,5,7,8,99,99};
		System.out.println(remove(array));
	}
	
	public static int remove(int[] array) {
		int i = 0;
		for (int j = 1; j<array.length; j++) {
			if(array[i]!=array[j]) {
				i ++;
				array[i] = array[j];
			}
		}
		return i + 1;
	}
}
