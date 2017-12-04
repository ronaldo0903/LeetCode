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

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

    Example 1:
    
    11110
    11010
    11000
    00000
    Answer: 1
    
    Example 2:
    
    11000
    11000
    00100
    00011
    Answer: 3
 *  
 */
public class NumOfIslandsSolution {
    public int numIslands(char[][] grid) {
	int[][] mark = new int[grid.length][];
	int numOfIslands = 0;
	for (int row = 0; row < grid.length; row++) {
	    mark[row] = new int[grid[row].length];
	    for (int col = 0; col < grid[row].length; col++) {
		mark[row][col] = 0;
	    }
	}
	for (int i = 0; i < grid.length; i++) {
	    for (int j = 0; j < grid[i].length; j++) {
		if ((grid[i][j] == '1') && (mark[i][j] == 0)) {
		    DFS(mark, grid, i, j);
		    //Can also use BFS as below
		    //BFS(mark, grid, i, j);
		    numOfIslands++;
		}
	    }
	}
	return numOfIslands;
    }

    //从(x,y)位置执行深度优先搜索，更新mark数组中相应位置的元素的值
    private void DFS(int[][] mark, char[][] grid, int x, int y) {
	int[] dx = { -1, 1, 0, 0 };
	int[] dy = { 0, 0, -1, 1 };
	mark[x][y] = 1;
	for (int i = 0; i < 4; i++) {
	    int newX = x + dx[i];
	    int newY = y + dy[i];
	    if ((newX < 0) || (newY < 0) || (newX > (mark.length - 1)) || (newY > (mark[newX].length - 1))) {
		continue;
	    }
	    if ((grid[newX][newY] == '1') && (mark[newX][newY] == 0)) {
		mark[newX][newY] = 1;
		DFS(mark, grid, newX, newY);
	    }
	}
    }

    //宽度优先搜索
    private void BFS(int[][] mark, char[][] grid, int x, int y) {
	int[] dx = { -1, 1, 0, 0 };
	int[] dy = { 0, 0, -1, 1 };
	Deque<Position> posDeque = new ArrayDeque<Position>();
	posDeque.addLast(new Position(x, y));
	mark[x][y] = 1;
	while (!posDeque.isEmpty()) {
	    x = posDeque.peekFirst().posX;
	    y = posDeque.peekFirst().posY;
	    posDeque.removeFirst();
	    for (int i = 0; i < 4; i++) {
		int newX = x + dx[i];
		int newY = y + dy[i];
		if ((newX < 0) || (newY < 0) || (newX > (mark.length - 1)) || (newY > (mark[0].length - 1))) {
		    continue;
		} else {
		    if ((grid[newX][newY] == '1') && (mark[newX][newY] == 0)) {
			posDeque.addLast(new Position(newX, newY));
			mark[newX][newY] = 1;
		    }
		}
	    }
	}
    }

    class Position {
	public int posX = -1;
	public int posY = -1;

	public Position(int x, int y) {
	    posX = x;
	    posY = y;
	}
    }
}
