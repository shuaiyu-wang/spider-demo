package com._830clock.test.leetCode;

/**
 * url:https://leetcode-cn.com/problems/valid-palindrome/
 * @author wangshuaiyu
 *
 */
public class _008Valid_palindrome {
	public static void main(String[] args) {
		String s = "race a car";//A man, a plan, a canal: Panama
		char[] c = s.toLowerCase().toCharArray();
		int j = s.length() - 1;
		boolean flag = true;
		for (int i = 0; i < c.length; i++) {
			//A-Z 65-90
			//a-z 97-122
			if(c[i] >= 97 && c[i] <= 122) {
				char c2 = c[j];
				if(c2 >= 97 && c2 <= 122) {
					if(c2 != c[i]) {
						flag = false;
						break;
					}
				}else {
					i--;
				}
				j--;
			}
		}
		System.out.println(flag);
	}
	
}
