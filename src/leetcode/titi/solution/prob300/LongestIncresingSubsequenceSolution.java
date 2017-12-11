/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2017
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package leetcode.titi.solution.prob300;

import java.util.Stack;

public class LongestIncresingSubsequenceSolution {
    public int lengthOfLIS(int[] nums) {
	if (nums.length < 1) {
	    return 0;
	}
	int[] dp = new int[nums.length];
	dp[0] = 1;
	for (int i = 1; i < nums.length; i++) {
	    dp[i] = 1;
	    for (int j = 0; j < i; j++) {
		if ((nums[i] > nums[j]) && (dp[i] < (dp[j] + 1))) {
		    dp[i] = dp[j] + 1;
		}
	    }
	}
	int result = 1;
	for (int k = 1; k < dp.length; k++) {
	    if (dp[k] > result) {
		result = dp[k];
	    }
	}
	return result;
    }

    public int lengthOfLIS_NLogN(int[] nums) {
	if (nums.length < 1) {
	    return 0;
	}
	//Stack[i]记录长度为i+1的上升子序列的末尾元素的最小可能值
	Stack<Integer> minStack = new Stack<Integer>();
	minStack.push(nums[0]);
	for (int i = 1; i < nums.length; i++) {
	    if (nums[i] > minStack.peek()) {
		minStack.push(nums[i]);
	    } else {
		int pos = BinarySearch(minStack, nums[i]);
		minStack.set(pos, nums[i]);
	    }
	}
	return minStack.size();
    }

    private int BinarySearch(Stack<Integer> minStack, int i) {
	int low = 0, high = minStack.size() - 1;
	int pos = -1;
	int mid;
	while (pos == -1) {
	    mid = (low + high) / 2;
	    if (minStack.get(mid) == i) {
		pos = mid;
	    } else if (minStack.get(mid) > i) {
		if ((mid == 0) || (i > minStack.get(mid - 1))) {
		    pos = mid;
		}
		high = mid - 1;
	    } else if (minStack.get(mid) < i) {
		if ((mid == (minStack.size() - 1)) || (i < minStack.get(mid + 1))) {
		    pos = mid + 1;
		}
		low = mid + 1;
	    }
	}
	return pos;
    }
}
