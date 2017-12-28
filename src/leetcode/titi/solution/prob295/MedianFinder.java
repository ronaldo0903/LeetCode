/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2017
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package leetcode.titi.solution.prob295;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
	maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
	    public int compare(Integer o1, Integer o2) {
		return o1 > o2 ? -1 : ((o1 != o2) ? 1 : 0);
	    }
	});
	minHeap = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
	if (maxHeap.isEmpty()) {
	    maxHeap.add(num);
	    return;
	}
	if (maxHeap.size() == minHeap.size()) {
	    if (num < maxHeap.peek()) {
		maxHeap.add(num);
	    } else {
		minHeap.add(num);
	    }
	} else if (maxHeap.size() > minHeap.size()) {
	    if (num > maxHeap.peek()) {
		minHeap.add(num);
	    } else {
		minHeap.add(maxHeap.poll());
		maxHeap.add(num);
	    }
	} else {
	    if (num < minHeap.peek()) {
		maxHeap.add(num);
	    } else {
		maxHeap.add(minHeap.poll());
		minHeap.add(num);
	    }
	}
    }

    public double findMedian() {
	if (maxHeap.size() > minHeap.size()) {
	    return maxHeap.peek().doubleValue();
	}
	if (maxHeap.size() < minHeap.size()) {
	    return minHeap.peek().doubleValue();
	} else {
	    return (double) (maxHeap.peek() + minHeap.peek()) / 2;
	}
    }
}
