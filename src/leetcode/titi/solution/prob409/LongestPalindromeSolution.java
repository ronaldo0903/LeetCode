/*
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.
 */
package leetcode.titi.solution.prob409;

public class LongestPalindromeSolution {
	public int longestPalindrome(String s) {
		int[] charMap = new int[128];
		int flag = 0;
		int longestLength = 0;
		for(int i=0; i<s.length(); i++) {
			charMap[s.charAt(i)] ++;
		}
		for(int j=0; j<charMap.length; j++) {
			if(charMap[j] % 2 == 0) {
				longestLength += charMap[j];
			}
			else {
				longestLength += charMap[j] - 1;
				flag = 1;
			}
		}
		return longestLength + flag;
	        
	}

}
