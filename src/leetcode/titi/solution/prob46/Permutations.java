package leetcode.titi.solution.prob46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> temp = new ArrayList();
        handle(nums, temp, result);
        return result;
    }

    public static List<List<Integer>> permuteWithDuplicates(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> temp = new ArrayList();
        List<Boolean> visited = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            visited.add(false);
        }
        Arrays.sort(nums);
        handle2(nums, temp, result, visited);
        return result;
    }

    private static void handle(int[] nums, List<Integer> temp, List<List<Integer>> result) {
        if(temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(!temp.contains(nums[i])) {
                temp.add(nums[i]);
                handle(nums, temp, result);
                temp.remove(temp.size()-1);
            }
        }
    }

    private static void handle2(int[] nums, List<Integer> temp, List<List<Integer>> result, List<Boolean> visited) {
        if(temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(visited.get(i)) continue;
            if(i>0 && nums[i] == nums[i-1] && visited.get(i-1)) continue;
            visited.set(i, true);
            temp.add(nums[i]);
            handle2(nums, temp, result, visited);
            temp.remove(temp.size()-1);
            visited.set(i, false);
        }
    }

    public static void main(String[] args) {
        int testNums[] = {1, 2, 2, 1, 3};
        List<List<Integer>> result = permuteWithDuplicates(testNums);
        System.out.println(result);
    }
}
