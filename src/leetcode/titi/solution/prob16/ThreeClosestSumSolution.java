package leetcode.titi.solution.prob16;

import java.util.Arrays;

public class ThreeClosestSumSolution {

	public static void main(String[] args) {
		int[] testNums = {1, 1, 1, 0};
		int closestSum = threeSumClosest(testNums, -100);
		System.out.println("The closest sum with target: -100 is:" + closestSum);

	}
	
	public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = target, minBias = Integer.MAX_VALUE;
        for(int i=0; i<nums.length-2;i++) {
            int tempSum, curBias = 0, preBias = 0; 
            for(int lo=i+1, hi = nums.length - 1; lo<hi; ) {
                preBias = curBias;
                curBias = nums[i]+nums[lo]+nums[hi]-target;
                if(curBias == 0) return target;
                if(preBias * curBias < 0) {
                    if(Math.abs(preBias) >= Math.abs(curBias)) {
                        tempSum = target + curBias;
                        if(Math.abs(minBias) > Math.abs(curBias)) {
                            minBias = curBias;
                            closestSum = tempSum;
                        } 
                    }
                    else {
                        tempSum = target + preBias;
                        if(Math.abs(minBias) > Math.abs(preBias)) {
                            minBias = preBias;
                            closestSum = tempSum;
                        }
                    }
                }
                if(lo + 1 == hi) {
                    tempSum = target + curBias;
                    if(Math.abs(minBias) > Math.abs(curBias)) {
                        minBias = curBias;
                        closestSum = tempSum;
                    }
                    
                }
                if(curBias > 0){
                    hi--;
                }
                else if(curBias < 0) {
                    lo++;
                }
                
            }
        }
        return closestSum;
        
    }

}
