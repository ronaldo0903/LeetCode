package leetcode.titi.solution.prob2;

import java.util.ArrayList;

public class Prob2Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<ListNode> nodeList = new ArrayList<ListNode>();
        int carry = 0;
        int curVal = 0;
        while ((l1 != null) || (l2 != null)) {
            if (l1 != null) {
                curVal += l1.val;
            }
            if (l2 != null) {
                curVal += l2.val;
            }
            curVal += carry;
            nodeList.add(new ListNode(curVal % 10));
            carry = curVal / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            curVal = 0;
        }
        if (carry > 0) {
            nodeList.add(new ListNode(carry));
        }
        for (int i = 0; i < (nodeList.size() - 1); i++) {
            nodeList.get(i).setNext(nodeList.get(i + 1));
        }
        return nodeList.get(0);
    }
}
