package leecode;

import leecode.Algorithms_94.TreeNode;

public class Algorithms_104 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c = 0;
		System.out.println(++c);
	}
	
	
	/**
	 * 二叉树的最大深度
	 * @param root
	 * @return
	 */
	public static int maxDepth(TreeNode root) {
		return dep(root, 0);
    }
	
	
	public static int dep(TreeNode root, int deep) {
		if (root == null) {
			return deep;
		}
		++ deep;
		return Math.max(dep(root.left, deep),dep(root.right, deep));
	}
}
