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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MedianFinderTest {
    private MedianFinder medianFinder = new MedianFinder();

    @Test
    public void test() {
	medianFinder.addNum(12);
	Assertions.assertTrue(12.0 == medianFinder.findMedian());
	medianFinder.addNum(10);
	Assertions.assertTrue(11.0 == medianFinder.findMedian());
	medianFinder.addNum(13);
	Assertions.assertTrue(12.0 == medianFinder.findMedian());
	medianFinder.addNum(11);
	Assertions.assertTrue(11.5 == medianFinder.findMedian());
	medianFinder.addNum(5);
	Assertions.assertTrue(11.0 == medianFinder.findMedian());
	medianFinder.addNum(15);
	Assertions.assertTrue(11.5 == medianFinder.findMedian());
	medianFinder.addNum(10);
	Assertions.assertTrue(11.0 == medianFinder.findMedian());
    }

}
