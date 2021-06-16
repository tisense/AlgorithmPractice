package leecode;

import leecode.Algorithms_94.TreeNode;

/**
 * 二叉树的最小深度
 *
 * @author renqi
 *
 */
public class Algorithms_111 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftH = minDepth(root.left);
		int rightH = minDepth(root.right);
		if (leftH == 0 && rightH == 0) {
			return 1;
		} else if (leftH != 0 && rightH != 0) {
			return Math.min(leftH, rightH) + 1;
		} else {
			return Math.max(leftH, rightH) + 1;
		}
	}
}
