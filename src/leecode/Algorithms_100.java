package leecode;

import leecode.Algorithms_94.TreeNode;

/**
 * 判断两个树是否相同
 * @author renqi
 *
 */
public class Algorithms_100 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		
		if (p != null && q != null) {
			return isSameTree(p.left, q.left) 
            && (p.val == q.val) 
            && isSameTree(p.right, q.right);
		}else if (p == q) {
			return true;
		}else {
			return false;
		}
		
    }

}
