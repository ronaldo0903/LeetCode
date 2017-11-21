package leetcode.titi.solution.prob290;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class TestWordPatternSolution {

	@Test
	public void test() {
		String pattern = "abba";
		String text= "dog cat cat dog";
		Assert.assertTrue(WordPatternSolution.wordPattern(pattern, text));
	}

}
