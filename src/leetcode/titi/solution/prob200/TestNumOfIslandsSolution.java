/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2017
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package leetcode.titi.solution.prob200;

import junit.framework.Assert;

import org.junit.Test;

public class TestNumOfIslandsSolution {
    private char[][] islandA = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
	    { '0', '0', '0', '1', '1' } };
    private char[][] islandB = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
	    { '0', '0', '0', '0', '0' } };
    private NumOfIslandsSolution solution = new NumOfIslandsSolution();

    @Test
    public void test() {
	Assert.assertEquals(3, solution.numIslands(islandA));
	Assert.assertEquals(1, solution.numIslands(islandB));
    }

}
