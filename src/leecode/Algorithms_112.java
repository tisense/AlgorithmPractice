package leecode;

import leecode.Algorithms_94.TreeNode;

public class Algorithms_112 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean hasPathSum(TreeNode root, int targetSum) {
		if (root != null) {
			if (root.left == null && root.right == null && root.val == targetSum) {
				return true;
			}else {
				return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
			}
		} 
		return false;
	}

}
