/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2017
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package leetcode.titi.solution.prob23;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
	val = x;
    }
}

public class MergeKListsSolution {
    public ListNode mergeKLists(ListNode[] lists) {
	if (lists.length == 0) {
	    return null;
	}
	if (lists.length == 1) {
	    return lists[0];
	}
	if (lists.length == 2) {
	    return mergeTwoLists(lists[0], lists[1]);
	}
	List<ListNode> subList1 = new ArrayList<ListNode>(), subList2 = new ArrayList<ListNode>();
	int m = lists.length / 2;
	for (int i = 0; i < m; i++) {
	    subList1.add(lists[i]);
	}
	for (int j = m; j < lists.length; j++) {
	    subList2.add(lists[j]);
	}
	ListNode l1 = mergeKLists(subList1.toArray(new ListNode[1]));
	ListNode l2 = mergeKLists(subList2.toArray(new ListNode[1]));
	return mergeTwoLists(l1, l2);

    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	ListNode nHead = new ListNode(0);
	ListNode cursor = nHead;
	while ((l1 != null) && (l2 != null)) {
	    if (l1.val < l2.val) {
		cursor.next = l1;
		l1 = l1.next;
	    } else {
		cursor.next = l2;
		l2 = l2.next;
	    }
	    cursor = cursor.next;
	}
	if (l1 != null) {
	    cursor.next = l1;
	}
	if (l2 != null) {
	    cursor.next = l2;
	}
	return nHead.next;
    }
}
