package leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Binary Tree inorder traversal
 * @author renqi
 *
 */
public class Algorithms_94 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		//Stack<String> stack = new Stack<String>();
		//stack.add(null);
		//stack.add(null);
		//System.out.println(stack.size());
		
		
		List<Integer> result = inorderTraversal02(root);
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
		}
	}
	
	
	
	
	/**
	 *  inorder traversal
	 *  
	 *  1、主要思想：先将p指向root节点，p不为空p入栈，p有左孩子，将p的左孩子入栈，也就是要将p的左孩子全部入栈
	 *  2、当p的左孩子全部入栈以后，p便指向了最后一个节点的左孩子null，这时出栈，访问该元素，并且如果
	 *  
	 *  注意P：
	 *  1、每次进栈以后 p 指向的是 进栈节点的左孩子 最终为空
	 *  2、每次出栈以后 p 指向的是 出栈节点的右孩子 
	 *  3、每次访问有两个孩子的父亲节点时，p 都是null 很巧妙
	 *  4、栈为空时 P 不一定为空 所以需要 p != null || !stack.isEmpty()  仿佛回到了初始状态
	 *  
	 * 参考： B栈-王卓老师讲解
	 * @param root
	 * @return
	 */
	public static List<Integer> inorderTraversal02(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.add(p);
				p = p.left;
			}else {
				p = stack.pop();
				result.add(p.val);
				p = p.right;
			}
		}
		return result;
	}
	
	
	
	
	
	
	/**
	 * 递归
	 * @param root
	 * @return
	 */
    public static List<Integer> inorderTraversal(TreeNode root) {
    	
    	List<Integer> result = new ArrayList<Integer>();
    	traversal(root, result);
    	
    	return result;
    }

    
    /*
     * 递归
     */
    public static void traversal(TreeNode node, List<Integer> result) {
    	
    	if (node == null) {
    		return;
		}
    	traversal(node.left, result);
    	result.add(node.val);
    	traversal(node.right, result);
    }
    
    
     //Definition for a binary tree node.
     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
   
}
