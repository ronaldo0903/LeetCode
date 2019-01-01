package leetcode.titi.solution.prob290;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestWordPatternSolution {

	@Test
	public void test() {
		String pattern = "abba";
		String text= "dog cat cat dog";
		Assertions.assertTrue(WordPatternSolution.wordPattern(pattern, text));
	}

}
