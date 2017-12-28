/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2017
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package leetcode.titi.solution.prob215;

import java.util.PriorityQueue;

public class KthLargestArraySolution {
    public int findKthLargest(int[] nums, int k) {
	PriorityQueue<Integer> Q = new PriorityQueue<Integer>();
	for (int num : nums) {
	    if (Q.size() < k) {
		Q.add(num);
	    } else if (Q.peek() < num) {
		Q.poll();
		Q.add(num);
	    }
	}
	return Q.peek();
    }
}
