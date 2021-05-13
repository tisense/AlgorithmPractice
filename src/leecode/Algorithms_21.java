package leecode;

import leecode.Algorithms_02.ListNode;

/**
 *
 * leetcode 21 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * @author renqi
 *
 */
public class Algorithms_21 {
	
	public static void main(String[] args) {
		

	}
	
	/**
	 * 递归
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		if (l2.val <= l1.val ) {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}else {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}
	}
	/**
	 * 迭代
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		ListNode prehead = new ListNode(-1);
		ListNode pre = prehead;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				pre.next = l1;
				l1 = l1.next;
			}else {
				pre.next =l1;
				l2 = l2.next;
			}
			pre = pre.next;
		}
		// 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        pre.next = l1 == null ? l2 : l1;
		return prehead;
    }
}
