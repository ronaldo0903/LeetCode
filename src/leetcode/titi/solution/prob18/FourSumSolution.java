package leetcode.titi.solution.prob18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import leetcode.titi.solution.prob18.FourSumSolution.IndexPair;

public class FourSumSolution {

	public static void main(String[] args) {
		int[] numsArray = {-3,-2,-1,0,0,1,2,3};
		List<List<Integer>> foundElements = fourSum(numsArray, 0);
		System.out.println(foundElements);

	}
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		Set<Set<Integer>> resultSet = new HashSet<Set<Integer>>();
		Map<Integer, Set<IndexPair>> twoSumsMap = new HashMap<>();
		for(int i=0; i<nums.length-1; i++) {
			for(int j=i+1; j<nums.length; j++) {
				int curSum = nums[i] + nums[j];
				IndexPair curPair = new IndexPair(i,j);
				if(!twoSumsMap.containsKey(curSum)) {
					Set<IndexPair> tempList = new HashSet<IndexPair>();
					tempList.add(curPair);
					twoSumsMap.put(curSum, tempList);
				}
				else {
					twoSumsMap.get(curSum).add(curPair);
				}
			}
		}
		
		for(Integer key : twoSumsMap.keySet()) {
			int targetKey = target - key;
			if(twoSumsMap.containsKey(targetKey)) {
				Set<IndexPair> l1 = twoSumsMap.get(key);
				Set<IndexPair> l2 = twoSumsMap.get(targetKey);				
				for(IndexPair p1: l1) {
					for(IndexPair p2: l2) {
						if(!p1.conflictsWith(p2)) {
							Set<Integer> indexSet = new HashSet<Integer>();
							indexSet.addAll(Arrays.asList(p1.first, p1.second, p2.first, p2.second));
							if(!resultSet.contains(indexSet)) {
								resultSet.add(indexSet);
							}
						}
					}
				}
			}
		}
		Iterator<Set<Integer>> it = resultSet.iterator();
		Set<List<Integer>> helpSet = new HashSet();
		while(it.hasNext()) {
			List<Integer> tmpList = new ArrayList<Integer>();
			it.next().forEach(e -> tmpList.add(nums[e]));
			tmpList.sort(Comparator.naturalOrder());
			if(!helpSet.contains(tmpList)) {
				helpSet.add(tmpList);
				resultList.add(tmpList);
			}
		}
        return resultList;
    }
	
	static class IndexPair {
		public int first;
		public int second;
		public IndexPair(int i, int j) {
			first =i;
			second =j;
		}
		@Override
		public boolean equals(Object o) {
			if(o == null) return false;
			if(!(o instanceof IndexPair)) return false;
			IndexPair target = (IndexPair) o;
			return (first == target.first && second == target.second) || (first == target.second && second == target.first);
		}
		
		public boolean conflictsWith(IndexPair p) {
			return (first == p.first || first == p.second || second == p.first || second == p.second);
		}
	}

}
