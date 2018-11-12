package leetcode.titi.solution.prob316;

import java.util.Arrays;

public class RemoveDuplicateLettersSolution {

	public static void main(String[] args) {
		String string = "cbacdcbc";
		String result = removeDuplicateLetters(string);
		System.out.println(result);

	}
	public static String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] count = new int[26];
        boolean[] letterAlreadyInResult = new boolean[26];
        Arrays.fill(count,0);
        Arrays.fill(letterAlreadyInResult,false);
        StringBuilder result = new StringBuilder();
        for(int i=0; i<n; i++) ++count[s.charAt(i)-'a'];
        for(int i=0;i<n;i++) {
        	--count[s.charAt(i)-'a'];
        	if(letterAlreadyInResult[s.charAt(i)-'a']) continue;
            while(result.length() > 0 && s.charAt(i) < result.charAt(result.length()-1) && count[result.charAt(result.length()-1)-'a'] > 0) {
            	letterAlreadyInResult[result.charAt(result.length()-1)-'a'] = false;
            	result.deleteCharAt(result.length()-1);            	
            }
            result.append(s.charAt(i));
            letterAlreadyInResult[s.charAt(i)-'a'] = true;
        }
        return result.toString();
        
    }

}
