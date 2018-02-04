package leetcode.titi.solution.prob315;

import java.util.ArrayList;
import java.util.List;

public class SmallerNumsAfterSelfSolution {
	private List<Integer> count = new ArrayList();
	private List<Pair<Integer,Integer>> helpList = new ArrayList();
	public List<Integer> countSmaller(int[] nums) {
        for(int i=0; i<nums.length; i++) {
        	helpList.add(new Pair(nums[i], i));
        	count.add(0);
        }
        merge_sort(helpList);
        return count;
    }
	private void merge_sort(List<Pair<Integer,Integer>> pairList) {
		if(pairList.size() < 2) return;
		int mid = pairList.size()/2;
		List<Pair<Integer,Integer>> leftList = new ArrayList();
		List<Pair<Integer,Integer>> rightList = new ArrayList();
		for(int i=0; i<mid; i++) {
			leftList.add(pairList.get(i).clone());
		}
		for(int j=mid; j<pairList.size(); j++) {
			rightList.add(pairList.get(j).clone());
		}
		merge_sort(leftList);
		merge_sort(rightList);
		pairList.clear();
		combine(leftList,rightList,pairList);
		
	}
	private void combine(List<Pair<Integer, Integer>> leftList, List<Pair<Integer, Integer>> rightList, List<Pair<Integer,Integer>> list) {
		int i=0,j=0;
		while(i<leftList.size() && j<rightList.size()) {
			if(leftList.get(i).first <= rightList.get(j).first) {
				count.set(leftList.get(i).second, count.get(leftList.get(i).second) + j);
				list.add(new Pair(leftList.get(i).first, leftList.get(i).second));
				i++;
			}
			else {
				list.add(new Pair(rightList.get(j).first, rightList.get(j).second));
				j++;
			}
		}
		for(;i<leftList.size();i++) {
			count.set(leftList.get(i).second, count.get(leftList.get(i).second) + j);
			list.add(new Pair(leftList.get(i).first, leftList.get(i).second));
		}
		for(;j<rightList.size();j++) {
			list.add(new Pair(rightList.get(j).first, rightList.get(j).second));
		}
		
	}
	class Pair<T1,T2>  {
		public T1 first;
		public T2 second;
		Pair(T1 v1, T2 v2) {
			first = v1;
			second = v2;
		}
		public Pair<T1, T2> clone() {
			Pair clone = new Pair<T1, T2>(this.first, this.second);
			return clone;
		}
	}
}
