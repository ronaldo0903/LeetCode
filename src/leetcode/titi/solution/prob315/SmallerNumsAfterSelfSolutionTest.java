package leetcode.titi.solution.prob315;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SmallerNumsAfterSelfSolutionTest {
	private SmallerNumsAfterSelfSolution solution = new SmallerNumsAfterSelfSolution();
	@Test
	public void test() {
		int[] nums = {5, -7, 9, 1, 3, 5, -2, 1};
		List<Integer> result = solution.countSmaller(nums);
		System.out.println(result);
	}

}
