package com._830clock.test.leetCode;

import java.util.Stack;

/**
 * url: https://leetcode-cn.com/problems/valid-parentheses/description/
 * @author wangshuaiyu
 *
 */
public class _001Valid_parentheses {
	public static void main(String[] args) {
		boolean bool = isValid("[{}]()");
		System.out.println(bool);
	}

public static boolean isValid(String s) {
	Stack<String> stack = new Stack<String>();
	for (int i = 0;i <s.length();i++) {
		String value = s.charAt(i)+"";
		if(stack.size() == 0) {
			stack.push(value);//入栈
		}else if(isEquals(stack.peek(), value)) {//peek 取栈顶值
			stack.pop();
		}else {
			stack.push(value);
		 }
	}
	return stack.size() == 0;
}

public static boolean isEquals(String s1, String s2) {
	return s1.equals("{")&&s2.equals("}") || s1.equals("[")&&s2.equals("]") || s1.equals("(")&&s2.equals(")");
}
}

