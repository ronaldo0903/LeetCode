package leetcode.titi.solution.prob22;

import java.util.ArrayList;
import java.util.List;
/*
 * 使用递归和剪枝来避免不必要的尝试，提高整体算法的效率
 * 剪枝策略:只有当前剩余的左括号的数量小于右括号时，算法才在当前状态基础上往")"分支前进一步；否则，只往"("方向前进
 */
public class ParenthesisGenerationSolution {
	List<String> resultList = new ArrayList();
	public List<String> generateParenthesis(int n) {
	   generate(n,n,""); 
	   return resultList;
	}
	private void generate(int left, int right, String curString) {
		if(left == 0 && right == 0) {
			resultList.add(curString);
			return;
		}
		if(left > 0) {
			generate(left-1, right, curString + "(");
		}
		if(left < right) {
			generate(left, right -1, curString + ")");
		}
	}
}
