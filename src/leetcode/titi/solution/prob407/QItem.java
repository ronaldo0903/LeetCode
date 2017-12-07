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

public class QItem implements Comparable<QItem> {
    int x;
    int y;
    int h;

    QItem(int _x, int _y, int _h) {
	x = _x;
	y = _y;
	h = _h;
    }

    public int compareTo(QItem o) {
	if (this.h < o.h) {
	    return -1;
	}
	if (this.h == o.h) {
	    return 0;
	} else {
	    return 1;
	}
    }
}