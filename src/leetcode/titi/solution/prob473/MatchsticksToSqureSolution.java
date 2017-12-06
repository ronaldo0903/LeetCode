/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2017
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package leetcode.titi.solution.prob473;

import java.util.Arrays;
import java.util.Vector;

/*
 * Problem Description: https://leetcode.com/problems/matchsticks-to-square/description/
 */
public class MatchsticksToSqureSolution {
    public boolean makeSquare(int[] nums) {
	if (nums.length < 4) {
	    return false;
	}
	int totalLength = 0;
	for (int i : nums) {
	    totalLength += i;
	}
	if ((totalLength % 4) != 0) {
	    return false;
	}
	int[] buckets = { 0, 0, 0, 0 };
	Arrays.sort(nums);
	return placeMatchsticks(0, nums, buckets, totalLength / 4);
    }

    private boolean placeMatchsticks(int i, int[] nums, int[] buckets, int target) {
	int numOfSticks = nums.length;
	if (i >= numOfSticks) {
	    return ((buckets[0] == target) && (buckets[1] == target) && (buckets[2] == target) && (buckets[3] == target));
	}
	for (int j = 0; j < 4; j++) {
	    if ((buckets[j] + nums[numOfSticks - i - 1]) > target) {
		continue;
	    }
	    buckets[j] += nums[numOfSticks - i - 1];
	    if (placeMatchsticks(i + 1, nums, buckets, target)) {
		return true;
	    }
	    buckets[j] -= nums[numOfSticks - i - 1];
	}
	return false;
    }

    public boolean makeSquareUsingBitoperations(int[] nums) {
	if (nums.length < 4) {
	    return false;
	}
	int totalLength = 0;
	for (int i : nums) {
	    totalLength += i;
	}
	if ((totalLength % 4) != 0) {
	    return false;
	}
	Vector<Integer> ok_quarters = new Vector<Integer>();
	Vector<Integer> ok_halfs = new Vector<Integer>();
	int ALL = 1 << nums.length;
	for (int i = 0; i < ALL; i++) {
	    int sum = 0;
	    for (int j = 0; j < nums.length; j++) {
		if ((i & (1 << j)) != 0) {
		    sum += nums[j];
		}
	    }
	    if (sum == (totalLength / 4)) {
		ok_quarters.add(i);
	    }
	}
	for (int k = 0; k < ok_quarters.size(); k++) {
	    for (int l = k + 1; l < ok_quarters.size(); l++) {
		if ((ok_quarters.get(k) & ok_quarters.get(l)) == 0) {
		    ok_halfs.add(ok_quarters.get(k) | ok_quarters.get(l));
		}
	    }
	}
	for (int m = 0; m < ok_halfs.size(); m++) {
	    for (int n = m + 1; n < ok_halfs.size(); n++) {
		if ((ok_halfs.get(m) & ok_halfs.get(n)) == 0) {
		    return true;
		}
	    }
	}
	return false;
    }
}
