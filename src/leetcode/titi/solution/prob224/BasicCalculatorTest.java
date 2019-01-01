/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2017
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package leetcode.titi.solution.prob224;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BasicCalculatorTest {

    @Test
    public void test() {
        String simpleExpression = "15 2+8 -1 0";
        String complexExpression = "(1+(4+5+2)-3)+(6+8)";
        Assertions.assertTrue(BasicCalculator.calculate(simpleExpression) == 150);
        Assertions.assertEquals(23, BasicCalculator.calculate(complexExpression));
    }

}
