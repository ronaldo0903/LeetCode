package leetcode.titi.solution.prob40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumSolution {
	List<List<Integer>> resultList = new ArrayList();
	Set<List<Integer>> resultSet = new HashSet();
	List<Integer> items = new ArrayList();
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {		
		Arrays.sort(candidates);
		process(0,candidates,0,target);
		return resultList;		
    }
	private void process(int i, int[] nums, int sum, int target) {
		if(i>=nums.length || sum >target) return;
		sum += nums[i];
		items.add(nums[i]);
		if(sum == target && !resultSet.contains(items)) {		
			resultList.add(new ArrayList(items));
			resultSet.add(new ArrayList(items));
		}
		process(i+1,nums,sum,target);
		sum -= nums[i];
		items.remove(items.size()-1);
		process(i+1,nums,sum,target);
		
	}
}
