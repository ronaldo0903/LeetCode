package leetcode.titi.solution.prob92;

/*
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

	For example:
	Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	
	return 1->4->3->2->5->NULL.
	
	Note:
	Given m, n satisfy the following condition:
	1 ≤ m ≤ n ≤ length of list.
 */
public class Prob92Solution {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode origHead = head, preHead = null, targetHead = null, tail = null, postTail;
        for(int i=1; i<m; i++) {
            preHead = head;
            head = head.next;
        }
        targetHead = head;
        for(int j=m; j<=n; j++) {
            tail = head;
            head= head.next;
        }
        postTail = head;
        ListNode temp = targetHead;
        head = targetHead.next;
        for(int k=m; k<n; k++) {
            ListNode next = head.next;
            head.next = temp;
            temp = head;
            head = next;
        }
        if(preHead != null) preHead.next = temp;
        targetHead.next = postTail;
        if(m>1) return origHead;
        else return tail;
    }
}
