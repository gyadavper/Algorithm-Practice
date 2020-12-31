package com.gyadav.practice.educative.allPatterns.slidingwindow;
/*Problem Statement #
        Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
        find the length of the longest contiguous subarray having all 1s.

        Example 1:

        Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
        Output: 6
        Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.*/
public class ReplacingOnes {
    public static void main(String[] args) {
        System.out.println(findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
    }

    public static int findLength(int[] arr, int k) {
        int max = 0;
        int startPointer = 0;
        int zeroCount = 0;
        for (int endPointer = 0; endPointer < arr.length; endPointer++) {
            if (arr[endPointer] == 0) {
                zeroCount++;
            }
            if (zeroCount > k) {
                if (arr[startPointer] != 0) {
                    while (arr[startPointer] != 0) {
                        startPointer++;
                    }
                    startPointer++;
                } else {
                    startPointer++;
                }

                    zeroCount--;
            }
            max = Math.max(max, (endPointer - startPointer) + 1);
        }
        return max;


    }
}
