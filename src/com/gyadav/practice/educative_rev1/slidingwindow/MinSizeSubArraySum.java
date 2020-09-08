package com.gyadav.practice.educative_rev1.slidingwindow;

public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        int windowStart = 0, windowSize = Integer.MAX_VALUE, windowSum = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum = windowSum + arr[windowEnd];
            while (windowSum >= S) {
                windowSize = Math.min(windowSize, windowEnd - windowStart + 1);
                windowSum = windowSum - arr[windowStart];
                windowStart++;
            }
        }
        return windowSize == Integer.MAX_VALUE ? 0 : windowSize;
    }
}
