package com.gyadav.practice.educative_rev3.twopointers;

import java.util.Arrays;

public class TripletSumCloseToTarget {
    public static int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
        int minSum = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            if (i != 0 && arr[i] == arr[i - 1])
                continue;
            int start = i + 1, end = arr.length - 1;
            while (start < end) {
                int sum = arr[i] + arr[start] + arr[end];
                if (sum == targetSum)
                    return sum;
                int currentDiff = Math.abs(sum - targetSum);
                if (currentDiff < diff) {
                    diff = currentDiff;
                    minSum = sum;
                }
                if (sum > targetSum)
                    end--;
                else
                    start++;
            }
        }
        return minSum;
    }

    public static void main(String[] a) {
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] {-3, -1, 1, 2}, 2));
    }
}
