package leecode;

import leecode.Algorithms_94.TreeNode;

public class Algorithm_108 {

	public static void main2(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * 平衡二叉树
	 * @param nums
	 * @return
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		
		return build(nums, 0, nums.length - 1);
    }
	
	
	public static TreeNode build(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}else {
			int middle = (start + end)/2;
			TreeNode root = new TreeNode(nums[middle]);
			root.left = build(nums, start, middle - 1);
			root.right = build(nums, middle + 1, end);
			return root;
		}
	}
	
	
	
	
	

	public static void main(String[] args) {
	        String str = new String("World");
	        char[] ch = {'H', 'e', 'l', 'l', 'o'};
	        change(str, ch);
	        System.out.print(str + " and " + ch);
	        System.out.println(ch);
	}
	public static void change(String str, char[] ch) {
	        str = "Changed";
	        ch[0] = 'C'; 
	} 

}
