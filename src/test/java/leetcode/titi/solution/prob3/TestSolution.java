/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2017
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package leetcode.titi.solution.prob3;

import junit.framework.Assert;

import org.junit.Test;

public class TestSolution {

    @Test
    public void test() {
        String s1 = "abcabcbb";
        String s2 = "pwwkew";
        String s3 = "bbbbbb";
        String s4 = "cbb";
        String s5 = "abcb";
        String s6 = "uqinntq";
        Assert.assertTrue(Prob3Solution.lengthOfLongestSubstring(s1).getKey() == 3);
        Assert.assertEquals(Prob3Solution.lengthOfLongestSubstring(s1).getValue(), "abc");

        Assert.assertTrue(Prob3Solution.lengthOfLongestSubstring(s2).getKey() == 3);
        Assert.assertEquals(Prob3Solution.lengthOfLongestSubstring(s2).getValue(), "wke");

        Assert.assertTrue(Prob3Solution.lengthOfLongestSubstring(s3).getKey() == 1);
        Assert.assertEquals(Prob3Solution.lengthOfLongestSubstring(s3).getValue(), "b");

        Assert.assertTrue(Prob3Solution.lengthOfLongestSubstring(s4).getKey() == 2);
        Assert.assertEquals(Prob3Solution.lengthOfLongestSubstring(s4).getValue(), "cb");

        Assert.assertTrue(Prob3Solution.lengthOfLongestSubstring(s5).getKey() == 3);
        Assert.assertEquals(Prob3Solution.lengthOfLongestSubstring(s5).getValue(), "abc");

        Assert.assertTrue(Prob3Solution.lengthOfLongestSubstring(s6).getKey() == 4);
        Assert.assertEquals(Prob3Solution.lengthOfLongestSubstring(s6).getValue(), "uqin");
    }

}
