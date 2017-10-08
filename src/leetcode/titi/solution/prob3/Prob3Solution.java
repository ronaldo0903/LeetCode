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

import java.util.AbstractMap.SimpleEntry;

/**
 * Given a string, find the length of the longest substring without
 * repeating characters. Examples: Given "abcabcbb", the answer is
 * "abc", which the length is 3. Given "bbbbb", the answer is "b",
 * with the length of 1. Given "pwwkew", the answer is "wke", with the
 * length of 3. Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 */
public class Prob3Solution {
    public static SimpleEntry<Integer, String> lengthOfLongestSubstring(String s) {
        int[] nextIdenticalPos = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int j;
            for (j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    nextIdenticalPos[i] = j;
                    break;
                }
            }
            if (j == s.length()) {
                nextIdenticalPos[i] = s.length();
            }
        }
        //Update the nextIdenticalPos array if the tailing substrings contains repeated characters
        for (int i = 0; i < nextIdenticalPos.length; i++) {
            int newPos = nextIdenticalPos[i];
            for (int j = i + 1; j < nextIdenticalPos[i]; j++) {
                if ((nextIdenticalPos[j] < nextIdenticalPos[i]) && (newPos > nextIdenticalPos[j])) {
                    newPos = nextIdenticalPos[j];
                }
            }
            nextIdenticalPos[i] = newPos;
        }

        //Calculate max lengths
        int maxLength = 0;
        String maxSubString = "";
        for (int i = 0; i < nextIdenticalPos.length; i++) {
            if (maxLength < (nextIdenticalPos[i] - i)) {
                maxLength = nextIdenticalPos[i] - i;
                maxSubString = s.substring(i, nextIdenticalPos[i]);
            }
        }
        return new SimpleEntry(maxLength, maxSubString);
    }
}
