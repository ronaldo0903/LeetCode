/*
 * Given an array of strings, group anagrams together.


For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:	

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
 */
package leetcode.titi.solution.prob49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsSolution {
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramsGroup = new ArrayList<List<String>>();
        Map<Integer[], List<String>> stringVectorHashMap = new HashMap<Integer[], List<String>>();
        for(int i=0; i<strs.length; i++) {
        	Integer[] vecKey = convertToVector(strs[i]);
        	if(!stringVectorHashMap.containsKey(vecKey)) {
        		stringVectorHashMap.put(vecKey, new ArrayList<String>());
        	}
        	stringVectorHashMap.get(vecKey).add(strs[i]);
        }
        for(Integer[] vecKey : stringVectorHashMap.keySet()) {
        	anagramsGroup.add(stringVectorHashMap.get(vecKey));
        }
        return anagramsGroup;
    }
	private Integer[] convertToVector(String str) {
		Integer[] vector = new Integer[26];
		for(int i=0; i<26; i++) {
			vector[i] = 0;
		}
		for(int i=0; i<str.length(); i++) {
			vector[str.charAt(i) - 'a'] ++;
		}
		return vector;
	}
	class StringVectorKey {
		private int[] internalArray;
		public StringVectorKey() {
			internalArray = new int[26];
		}
		public void incrementCount(int pos) {
			internalArray[pos] ++;
		}
		private int getCount(int pos) {
			return internalArray[pos];
		}
		public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof StringVectorKey) {
            	StringVectorKey key= (StringVectorKey)o;
                for(int i=0; i<key.internalArray.length; i++) {
                	if(key.getCount(i) == this.getCount(i)) continue;
                	return false;
                }
                return true;
            }
            return false;
        }
		public final int hashCode() {
			
		}
		
	}
}
