package leetcode.titi.solution.prob40;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestCombinationSum {
	private CombinationSumSolution solution = new CombinationSumSolution();

	@Test
	public void test() {
		int[] candidates = {10, 1, 2, 7, 6, 1, 5};
		//int[] candidates = {2, 1, 3};
		int target = 8;
		List<List<Integer>> result = solution.combinationSum2(candidates, target);
		System.out.println(result);
	}

}
