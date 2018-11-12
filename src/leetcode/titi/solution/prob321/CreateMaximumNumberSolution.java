package leetcode.titi.solution.prob321;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.sun.corba.se.impl.naming.cosnaming.InternalBindingValue;

public class CreateMaximumNumberSolution {

	public static void main(String[] args) {
		int[] nums1 = {6,7};
		int []nums2 = {6,0,4};
		int k = 5;
		int[] maxNum = maxNumber(nums1,nums2,k);
		System.out.print("Result Array is: [");
		for(int i=0; i<maxNum.length; i++) {
			System.out.print(maxNum[i]);
			if(i!= maxNum.length -1) System.out.print(",");
		}
		System.out.print("]");

	}
	
	public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int L = m<k?m:k;
        int R = n<k?n:k;
        int[] curMaxNum = new int[k];
        
        for(int l=0; l<=L;l++) {
        	int r = k-l;
        	if(r<=R) {
        		List<Integer> leftMaxNum = getMaxNumOfFixedCount(nums1,l);
        		List<Integer> rightMaxNum = getMaxNumOfFixedCount(nums2,r);
        		int curTempMaxNum[] = mergeLeftAndRight(leftMaxNum, rightMaxNum, l, r);
        		if(isGreaterThan(curTempMaxNum,curMaxNum)) curMaxNum = curTempMaxNum;
        	}
        }
        return curMaxNum;
        
    }

	private static boolean isGreaterThan(int[] firstArray, int[] secondArray) {
		int i=0, j=0;
		while(i<firstArray.length && j<secondArray.length) {
			if(firstArray[i] != secondArray[j]) return firstArray[i] > secondArray[j];
			i++;
			j++;
		}
		return false;
		
	}

	private static int[] mergeLeftAndRight(List<Integer> leftMaxNum, List<Integer> rightMaxNum, int L, int R) {
		// TODO Auto-generated method stub
		int []result = new int[L+R];
		int i=0,j=0,k=0;
		while(k<L+R && i<L && j<R) {
			if(selectFromFirst(leftMaxNum, rightMaxNum, i, j)) {
				result[k++] = leftMaxNum.get(i++);
			}
			else {
				result[k++] = rightMaxNum.get(j++);
			}
		}
		while(i<L) result[k++] = leftMaxNum.get(i++);
		while(j<R) result[k++] = rightMaxNum.get(j++);
		
		return result;
	}

	private static boolean selectFromFirst(List<Integer> leftMaxNum, List<Integer> rightMaxNum, int curLindex,
			int curRindex) {
		
		while(curLindex < leftMaxNum.size() && curRindex < rightMaxNum.size()) {
			if(leftMaxNum.get(curLindex) != rightMaxNum.get(curRindex)) return leftMaxNum.get(curLindex) > rightMaxNum.get(curRindex);
			curLindex++;
			curRindex++;
		}
		return curRindex == rightMaxNum.size();
	}

	private static List<Integer> getMaxNumOfFixedCount(int[] num, int c) {
		Stack<Integer> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();
		if(c<1) return result;
		for(int i=0; i<num.length; i++) {
			while(!stack.isEmpty() && num[i] > stack.peek() && stack.size() + num.length-i-1 >= c) {
				stack.pop();
			}
			if(stack.size() < c) stack.push(num[i]);			
		}
		while(!stack.isEmpty()) {
			result.add(0, stack.pop());
		}
		return result ;
	}

}
