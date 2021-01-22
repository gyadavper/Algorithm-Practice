package com.gyadav.practice.educative_rev3.twopointers;

public class PairWithTargetSum {
    public static int[] search(int[] arr, int targetSum) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == targetSum)
                return new int[]{start, end};
            if (sum < targetSum)
                start++;
            else
                end--;
        }
        return new int[] { -1, -1 };
    }
}
