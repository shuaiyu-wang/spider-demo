package com._830clock.test.leetCode;
/**
 * url:https://leetcode-cn.com/problems/maximum-subarray/
 * @author wangshuaiyu
 *
 */
public class _003Maximum_subarray {

	public static void main(String[] args) {
		int[] arr = new int[] {-2,1,-3,4,-1,2,1,-5,4};
//		int max = 0;
//		for(int i = 0; i<arr.length;i++) {
//			int count = arr[i];
//			for(int j = i+1; j<arr.length;j++) {
//				count += arr[j];
//				if (count >= max) {
//					max = count;
//				}
//			}
//		}
//		System.out.println(max);
		
		
		int ans = arr[0];
        int sum = 0;
        for(int num: arr) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
//作者：guanpengchn
//链接：https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/
	}
}
