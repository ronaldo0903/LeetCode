/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2017
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package leetcode.titi.solution.prob120;

import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TriangleSolution {
    public int minimumTotal(List<List<Integer>> triangle) {
	int row = triangle.size();
	if (row == 1) {
	    return Collections.min(triangle.get(0));
	}
	List<List<Integer>> dps = new ArrayList<List<Integer>>();
	dps.add(0, new ArrayList<Integer>());
	for (int col = 0; col < triangle.get(0).size(); col++) {
	    dps.get(0).add(col, triangle.get(0).get(col));
	}
	for (int r = 1; r < row; r++) {
	    dps.add(r, new ArrayList<Integer>());
	    dps.get(r).add(0, dps.get(r - 1).get(0) + triangle.get(r).get(0));
	    for (int c = 1; c < triangle.get(r).size(); c++) {
		dps.get(r).add(
			c,
			min(dps.get(r - 1).get(c - 1), dps.get(r - 1).size() > c ? dps.get(r - 1).get(c)
				: Integer.MAX_VALUE)
				+ triangle.get(r).get(c));
	    }
	}
	return Collections.min(dps.get(row - 1));
    }
}
