package leetcode.titi.solution.prob51;

import org.junit.jupiter.api.Test;

import java.util.List;

public class NQueenSolutionTest {
	private NQueenSolution solution = new NQueenSolution();
	@Test
	public void test() {
		int DIMENSION = 8;
		List<List<String>> result = solution.solveNQueens(DIMENSION);
		System.out.printf("There are %d solutions of %d-Queen problem\n", result.size(), DIMENSION);
		for(List<String> one : result) {
			System.out.println("=======START=========");
			for(String s : one) {
				System.out.printf("%s\n",s);
			}
			System.out.println("========END========");
		}
	}
}
