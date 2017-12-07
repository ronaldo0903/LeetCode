/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2017
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package leetcode.titi.solution.prob407;

import java.util.PriorityQueue;

/*
 * Problem description: https://leetcode.com/problems/trapping-rain-water-ii/description/
 */
public class TrapRainwaterSolution {
    public int trapRainWater(int[][] heightMap) {
	PriorityQueue<QItem> pQueue = new PriorityQueue<QItem>();
	int row = heightMap.length;
	if (row < 1) {
	    return 0;
	}
	int col = heightMap[0].length;
	if ((row < 3) || (col < 3)) {
	    return 0;
	}
	int[][] mark = new int[row][];
	for (int r = 0; r < heightMap.length; r++) {
	    mark[r] = new int[heightMap[r].length];
	    for (int c = 0; c < heightMap[r].length; c++) {
		mark[r][c] = 0;
	    }
	}
	for (int i = 0; i < row; i++) {
	    pQueue.add(new QItem(i, 0, heightMap[i][0]));
	    pQueue.add(new QItem(i, col - 1, heightMap[i][col - 1]));
	    mark[i][0] = 1;
	    mark[i][col - 1] = 1;
	}
	for (int j = 1; j < (col - 1); j++) {
	    pQueue.add(new QItem(0, j, heightMap[0][j]));
	    mark[0][j] = 1;
	    pQueue.add(new QItem(row - 1, j, heightMap[row - 1][j]));
	    mark[row - 1][j] = 1;
	}
	final int[] dx = { 0, 0, -1, 1 };
	final int[] dy = { -1, 1, 0, 0 };
	int waterVolume = 0;
	while (!pQueue.isEmpty()) {
	    int x = pQueue.peek().x;
	    int y = pQueue.peek().y;
	    int h = pQueue.peek().h;
	    pQueue.poll();
	    for (int d = 0; d < 4; d++) {
		int newX = x + dx[d];
		int newY = y + dy[d];
		if ((newX < 0) || (newY < 0) || (newX >= row) || (newY >= col) || (mark[newX][newY] == 1)) {
		    continue;
		}
		if (h > heightMap[newX][newY]) {
		    waterVolume += h - heightMap[newX][newY];
		    heightMap[newX][newY] = h;
		}
		pQueue.add(new QItem(newX, newY, heightMap[newX][newY]));
		mark[newX][newY] = 1;
	    }
	}
	return waterVolume;
    }
}
