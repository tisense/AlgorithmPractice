package leecode;


import leecode.Algorithms_94.TreeNode;

public class Algorithms_101 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static void test(String string) {
		String tempString = string;
		tempString = "AAA";
		System.out.println(string + "," + tempString);
	}
	/**
	 * 对称树
	 * symmetric  tree
	 * @param root
	 * @return
	 */
	public static boolean isSymmetric(TreeNode root) {
		
		//TreeNode left = root.left;
		//TreeNode right = root.right;
		//Stack<TreeNode> stackLeft = new Stack<TreeNode>();
		//Stack<TreeNode> stackRight = new Stack<TreeNode>();
		return mirro(root.left, root.right);

    }
	
	/**
	 * 递归
	 * @param left
	 * @param right
	 * @return
	 */
	public static boolean mirro(TreeNode left, TreeNode right) {
		if (left != null && right != null) {
			return left.val == right.val 
					&& mirro(left.left, right.right) 
					&& mirro(left.right, right.left);
		} else {
			return left == right;
		}
	}

}
