package com.gyadav.practice.educative_rev3.slidingwindow;

public class MaximumSumSubarraySizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0, sum = 0, startWindow = 0;
        for (int endWindow = 0; endWindow < arr.length; endWindow++) {
            sum = sum + arr[endWindow];
            if (endWindow >= k) {
                maxSum = Math.max(maxSum, sum);
                sum -= arr[startWindow];
                startWindow++;
            }
        }
        return maxSum;
    }
}
