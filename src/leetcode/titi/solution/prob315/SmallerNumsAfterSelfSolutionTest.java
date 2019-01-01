package leetcode.titi.solution.prob315;

import org.junit.jupiter.api.Test;

import java.util.List;

public class SmallerNumsAfterSelfSolutionTest {
	private SmallerNumsAfterSelfSolution solution = new SmallerNumsAfterSelfSolution();
	@Test
	public void test() {
		int[] nums = {5, -7, 9, 1, 3, 5, -2, 1};
		List<Integer> result = solution.countSmaller(nums);
		System.out.println(result);
	}

}
