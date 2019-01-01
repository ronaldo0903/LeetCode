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

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TrapRainwaterSolutionTest {
    private int[][] heightMap = { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };
    private TrapRainwaterSolution solution = new TrapRainwaterSolution();

    @Test
    public void test() {
	int waterVolume = solution.trapRainWater(heightMap);
	Assertions.assertEquals(4, waterVolume);
    }

    /*@Test
    public void testPriorityQueue() {
    PriorityQueue<QItem> testQueue = new PriorityQueue<QItem>();
    testQueue.add(new QItem(0, 0, 5));
    testQueue.add(new QItem(1, 3, 2));
    testQueue.add(new QItem(5, 2, 4));
    testQueue.add(new QItem(0, 1, 8));
    testQueue.add(new QItem(6, 7, 1));
    while (!testQueue.isEmpty()) {
        QItem item = testQueue.poll();
        System.out.println("QItem: x = " + item.x + ", y =" + item.y + ", h = " + item.h);
    }
    }*/

}
