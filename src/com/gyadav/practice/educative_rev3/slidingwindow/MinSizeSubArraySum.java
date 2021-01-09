package com.gyadav.practice.educative_rev3.slidingwindow;

public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        int minWindowSize = Integer.MAX_VALUE, startWindow = 0, sum = 0;
        for (int endWindow = 0; endWindow < arr.length; endWindow++) {
            sum += arr[endWindow];
            while (sum >= S) {
                minWindowSize = Math.min(minWindowSize, endWindow - startWindow + 1);
                sum -= arr[startWindow];
                startWindow++;
            }
        }
        return minWindowSize;
    }
}
