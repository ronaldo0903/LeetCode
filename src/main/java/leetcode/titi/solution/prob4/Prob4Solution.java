/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2017
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package leetcode.titi.solution.prob4;

/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 * 
 * */

public class Prob4Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = MergeSort(nums1, nums2);
        if ((mergedArray.length % 2) == 1) {
            return mergedArray[((mergedArray.length + 1) / 2) - 1];
        } else {
            return ((double) mergedArray[(mergedArray.length / 2) - 1] + (double) mergedArray[mergedArray.length / 2]) / 2;
        }
    }

    private int[] MergeSort(int[] nums1, int[] nums2) {
        int[] mergedNums = new int[nums1.length + nums2.length];
        int i1 = 0, i2 = 0;
        int k = 0;
        while ((i1 < nums1.length) && (i2 < nums2.length)) {
            if (nums1[i1] < nums2[i2]) {
                mergedNums[k++] = nums1[i1];
                i1++;
            } else {
                mergedNums[k++] = nums2[i2];
                i2++;
            }
        }
        if ((i1 == nums1.length) && (i2 < nums2.length)) {
            for (int r = i2; r < nums2.length; r++) {
                mergedNums[k++] = nums2[r];
            }
        }
        if ((i2 == nums2.length) && (i1 < nums1.length)) {
            for (int r = i1; r < nums1.length; r++) {
                mergedNums[k++] = nums1[r];
            }
        }
        return mergedNums;
    }

}
