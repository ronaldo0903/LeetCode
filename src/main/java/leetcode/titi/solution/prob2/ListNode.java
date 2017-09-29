/**
 * Definition for singly-linked list.
 * */
package leetcode.titi.solution.prob2;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public void setNext(ListNode nextNode) {
        next = nextNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        ListNode tempNode = next;
        while (tempNode != null) {
            sb.append(tempNode.val);
            tempNode = tempNode.next;
        }
        return sb.toString();
    }

    public ListNode getNext() {
        // TODO Auto-generated method stub
        return next;
    }
}
