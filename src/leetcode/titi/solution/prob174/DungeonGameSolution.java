/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2017
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package leetcode.titi.solution.prob174;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class DungeonGameSolution {
    public int calculateMinimumHP(int[][] dungeon) {
	int row = dungeon.length;
	if (row < 1) {
	    return 1;
	}
	int col = dungeon[0].length;
	if (col < 1) {
	    return 1;
	}
	int[][] dps = new int[row][col];
	dps[row - 1][col - 1] = max(1, 1 - dungeon[row - 1][col - 1]);
	for (int c = col - 2; c >= 0; c--) {
	    dps[row - 1][c] = max(1, dps[row - 1][c + 1] - dungeon[row - 1][c]);
	}
	for (int r = row - 2; r >= 0; r--) {
	    dps[r][col - 1] = max(1, dps[r + 1][col - 1] - dungeon[r][col - 1]);
	}
	for (int i = row - 2; i >= 0; i--) {
	    for (int j = col - 2; j >= 0; j--) {
		dps[i][j] = max(1, min(dps[i][j + 1], dps[i + 1][j]) - dungeon[i][j]);
	    }
	}
	return dps[0][0];
    }
}
