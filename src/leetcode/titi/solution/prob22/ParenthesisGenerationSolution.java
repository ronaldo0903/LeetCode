package leetcode.titi.solution.prob22;

import java.util.ArrayList;
import java.util.List;
/*
 * ʹ�õݹ�ͼ�֦�����ⲻ��Ҫ�ĳ��ԣ���������㷨��Ч��
 * ��֦����:ֻ�е�ǰʣ��������ŵ�����С��������ʱ���㷨���ڵ�ǰ״̬��������")"��֧ǰ��һ��������ֻ��"("����ǰ��
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
