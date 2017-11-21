/*
 * Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 * 
 */
package leetcode.titi.solution.prob290;

import java.util.HashMap;
import java.util.Map;

public class WordPatternSolution {
	public static boolean wordPattern(String pattern, String str) {
		Map<String,Integer> wordMap = new HashMap<String,Integer>();
		Boolean[] usedMap = new Boolean[26];
		for(int i=0; i<usedMap.length; i++) {
			usedMap[i] = false;
		}
        String[] strArr = str.split(" ");
        if(pattern.length() != strArr.length) return false;
        for(int i=0; i<pattern.length(); i++) {        	
        	if(!wordMap.containsKey(strArr[i]) && !usedMap[pattern.charAt(i)-'a']) {
        		wordMap.put(strArr[i], pattern.charAt(i)-'a');
        		usedMap[pattern.charAt(i)-'a'] = true;
        	}
        	else if(wordMap.containsKey(strArr[i]) && wordMap.get(strArr[i]) != pattern.charAt(i)-'a')  {
        		return false;
        	}
        	else if(usedMap[pattern.charAt(i)-'a'] && !wordMap.containsKey(strArr[i])) {
        		return false;
        	}
        }
        return true;
    }

}
