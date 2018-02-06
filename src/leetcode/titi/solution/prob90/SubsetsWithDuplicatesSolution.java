/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2018
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package leetcode.titi.solution.prob90;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsWithDuplicatesSolution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
	List<List<Integer>> result = new ArrayList();
	Set<List<Integer>> helpSet = new HashSet<List<Integer>>();
	int numOfElements = nums.length;
	int setSize = 1 << numOfElements;
	for (int i = 0; i < setSize; i++) {
	    List<Integer> itemList = new ArrayList();
	    for (int j = 0; j < numOfElements; j++) {
		if ((i & (1 << j)) > 0) {
		    itemList.add(nums[j]);
		}
	    }
	    itemList.sort(null);
	    helpSet.add(itemList);
	    if (!helpSet.contains(itemList)) {
		result.add(itemList);
	    }
	}
	return result;
    }
}
