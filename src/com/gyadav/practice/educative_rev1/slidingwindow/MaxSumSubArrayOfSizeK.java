package com.gyadav.practice.educative_rev1.slidingwindow;

public class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0, sum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            sum = sum + arr[windowEnd];
            if (windowEnd - windowStart + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum = sum - arr[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }
}
