package leecode;

import leecode.Algorithms_94.TreeNode;

public class Algorithms_110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	
    public static boolean isBalanced(TreeNode root) {
    	if (root == null) {
			return true;
		}
    	return Math.abs(height(root.left) - height(root.right)) <= 1 
    			&&  isBalanced(root.left) && isBalanced(root.right);
    }
    
    public static int height(TreeNode root) {
    	
    	if (root == null) {
			return 0;
		}else {
			return 1 + Math.max(height(root.left), height(root.right));
		}
    }
    
    
    /**
     * 自地向上遍历：
     * 1、如果左右子树是平衡二叉树返回树的高度，如果不是则返回-1；
     * 
     * @param root
     * @return
     */
    public static int height2(TreeNode root) {
    	
    	if (root == null) {
			return 0;
		}
    	int leftH = height2(root.left);
    	int rightH = height2(root.right);
    	if (leftH == -1 || rightH == -1 || Math.abs(rightH - leftH) > 1) {
			return -1;
		}else {
			return Math.max(leftH, rightH) + 1;
		}
    }
}
