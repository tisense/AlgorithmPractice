package leecode;

/**
 * @author renqi 第二题：两数之和
 * 
 * 
 *         给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 *         如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 *         您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 *         示例：
 * 
 *         输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 * 
 *         来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Algorithms_02 {

	// Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) {this.val = val;}
		ListNode(int val, ListNode next) {this.val = val;this.next = next;}
	}

	public static void main(String[] args) {
		//

		ListNode list01 = new ListNode(2);
		ListNode list01_note01 = new ListNode(4);
		ListNode list01_note02 = new ListNode(3);
		list01.next = list01_note01;
		list01_note01.next = list01_note02;

		ListNode list02 = new ListNode(5);
		ListNode list02_note1 = new ListNode(6);
		ListNode list02_note2 = new ListNode(4);
		list02.next = list02_note1;
		list02_note1.next = list02_note2;

	
		ListNode hadeListNode = addTwoNumbers(list01, list02);;
		while (hadeListNode.next !=  null) {
			hadeListNode = hadeListNode.next;
			System.out.print(hadeListNode.val);
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head1 = l1;
		ListNode head2 = l2;
		ListNode headR = new ListNode(0);
		ListNode result = headR;
		int count = 0;
		int temp = 0;
		int result1 = 0;
		int result2 = 0;
		// temp != 0 至关重要
		while (head1 != null || head2 != null || temp != 0) {
			
			if (head1 == null) {
				result1 = 0;
			}else {
				result1 = head1.val;
			}
			
			if (head2 == null) {
				result2 = 0;
			}else {
				result2 = head2.val;
			}
				
			count = (result1 + result2) + temp;
			temp = count / 10;
			int r = count % 10;
			headR.next = new ListNode(r);
			headR = headR.next;
			if (head1 == null) {
				head1 = null;
			}else {
				head1 = head1.next;
			}
			
			if (head2 == null) {
				head2 = null;
			}else {
				head2 = head2.next;
			}
		}
		return result;
	}
}
