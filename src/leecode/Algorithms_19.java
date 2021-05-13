package leecode;

/**
 * 
 * @author renqi
 * 
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 * 进阶：你能尝试使用一趟扫描实现吗？
 * 
 * 双指针：快慢指针
 */
public class Algorithms_19 {

	public static void main(String[] args) {
		
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode da = new ListNode(0, head);
		ListNode first = head;
		ListNode seconed = da;
		for (int i = 0; i < n; i++) {
			first = first.next;
		}
		while (first != null) {
			first = first.next;
			seconed = seconed.next;
		}
		seconed.next = seconed.next.next;
		return da.next;
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) {this.val = val;}
		ListNode(int val, ListNode next) {this.val = val;this.next = next;}
	}
}

/**
 * Definition for singly-linked list.
 */
