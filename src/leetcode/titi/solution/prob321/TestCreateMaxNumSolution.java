package leetcode.titi.solution.prob321;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCreateMaxNumSolution {
	
	@Test
	public void testNormal() {
		int[] nums1 = {3,4,6,5};
		int []nums2 = {9,1,2,5,8,3};
		int k = 5;
		int[] result = CreateMaximumNumberSolution.maxNumber(nums1, nums2, k);
		int[] expected = {9,8,6,5,3};
		assertArrayEquals(expected, result);
	}

	@Test
	public void testWithDuplicatedNums() {
		int[] nums1 = {6,7};
		int []nums2 = {6,0,4};
		int k = 5;
		int[] result = CreateMaximumNumberSolution.maxNumber(nums1, nums2, k);
		int[] expected = {6,7,6,0,4};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testWithSimpleInputs() {
		int[] nums1 = {3,9};
		int []nums2 = {8,9};
		int k = 3;
		int[] result = CreateMaximumNumberSolution.maxNumber(nums1, nums2, k);
		int[] expected = {9,8,9};
		assertArrayEquals(expected, result);
	}
	@Test
	public void testWithMultipleDuplicatedNums() {
		int[] nums1 = {6,7,8,3};
		int[] nums2 = {6,7,4,5,2};
		int k = 5;
		int[] result = CreateMaximumNumberSolution.maxNumber(nums1, nums2, k);
		int[] expected = {8,7,5,3,2};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testWithALargeK() {
		int[] nums1 = {6,3,8};
		int []nums2 = {6,4,5,2};
		int k = 6;
		int[] result = CreateMaximumNumberSolution.maxNumber(nums1, nums2, k);
		int[] expected = {6,8,6,4,5,2};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testWithComplicatedInputs() {
		int[] nums1 = {2,5,6,4,4,0};
		int []nums2 = {7,3,8,0,6,5,7,6,2};
		int k = 15;
		int[] result = CreateMaximumNumberSolution.maxNumber(nums1, nums2, k);
		int[] expected = {7,3,8,2,5,6,4,4,0,6,5,7,6,2,0};
		assertArrayEquals(expected, result);
	}

}
