package prob2.code.leet.titi;

import java.util.ArrayList;

public class Prob2Solution {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {        
        int intSum = getIntValue(l1) + getIntValue(l2);
        ArrayList<ListNode> nodeList = new ArrayList<ListNode>();
        nodeList.add(new ListNode(intSum % 10));
        while(intSum / 10 > 0) {
        	nodeList.add(new ListNode(intSum % 10));
            intSum /= 10;            
        }
        for(int i=0; i<nodeList.size() - 1; i++) {
        	nodeList.get(i).setNext(nodeList.get(i+1));
        }
        return nodeList.get(0);
    }
    
    public static ListNode reverseList(ListNode l) {
        ListNode newNode = null;
        while(l != null) {
            ListNode next = l.next;
            l.next = newNode;
            newNode = l;
            l = next;
        }
        return newNode;
    }
    public static int getIntValue(ListNode l) {
        ListNode rl = reverseList(l);
        int val=0;
        while(rl!=null) {
            val = 10 * val + rl.val;
            rl=rl.next;
        }
        return val;
    }
}
