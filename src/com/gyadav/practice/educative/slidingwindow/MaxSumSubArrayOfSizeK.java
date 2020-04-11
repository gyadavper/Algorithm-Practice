package com.gyadav.practice.educative.slidingwindow;

public class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int windowsStart = 0;
        int max = -1;
        int sum = 0;
        for (int windowsEnd = 0; windowsEnd < arr.length; windowsEnd++){
            sum = sum + arr[windowsEnd];
            if (windowsEnd >= k - 1) {
                max = Math.max(max, sum);
                sum = sum - arr[windowsStart];
                windowsStart++;
            }
        }
        return max;
    }

    public static void main (String[] args) {
        findMaxSumSubArray(3, new int[] {2, 1, 5, 1, 3, 2});
    }
}
