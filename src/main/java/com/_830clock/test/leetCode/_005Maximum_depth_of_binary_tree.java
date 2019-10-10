package com._830clock.test.leetCode;

/**
 * url:https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode/
 * @author wangshuaiyu
 *
 */
public class _005Maximum_depth_of_binary_tree {

	//求二叉树最大深度-递归
	
	class Node {
		private Node left;
		private Node right;
	}
	
	public static void main(String[] args) {
	}
	public int maxDept(Node node) {
		if (node == null) {
			return 0;
		}else {
			int left = maxDept(node.left);
			int right = maxDept(node.right);
			return Math.max(left, right) + 1;
		}
	}
}


