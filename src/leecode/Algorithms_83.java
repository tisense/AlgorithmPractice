package leecode;

import com.sun.xml.internal.messaging.saaj.packaging.mime.Header;

import leecode.Algorithms_19.ListNode;

/**
 * Remove duplicates from Sorted Lists
 * @author renqi
 *
 */
public class Algorithms_83 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode node5 = new ListNode(3, null);
		ListNode node4 = new ListNode(3, node5);
		ListNode node3 = new ListNode(2, node4);
		ListNode node2 = new ListNode(1, node3);
		ListNode node1 = new ListNode(1, node2);
		ListNode head = new ListNode(0, node1);
		
		ListNode temp = new ListNode(0, head.next);
		while (temp.next != null) {
			System.out.print(temp.next.val);
			temp.next = temp.next.next;
		}
		System.out.println();
		head = deleteDuplicates(head);
		while (head.next != null) {
			System.out.print(head.next.val);
			head.next = head.next.next;
		}
	}
	
	
	
	
	/**
	 * 这里的head节点就是链表的第一个元素
	 * @param head
	 * @return
	 */
    public static ListNode deleteDuplicates(ListNode head) {
    	
    	if (head == null) {
			return head;
		}
    	ListNode temp = head;
    	while (temp != null) {
    		if (temp.next != null && temp.val == temp.next.val) {
    			temp.next = temp.next.next;
			}else {
				temp = temp.next;
			}
		}
    	return head;
    }
}
