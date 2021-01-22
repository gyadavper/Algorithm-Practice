package com.gyadav.practice.educative_rev3.twopointers;

import java.util.Arrays;

public class TripletWithSmallerSum {
    public static int searchTriplets(int[] arr, int target) {
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int subCount = searchDoubles (arr, target - arr[i], i + 1, arr.length - 1);
            count += subCount;
        }
        return count;
    }
    public static int searchDoubles(int[] arr, int target, int start, int end) {
        int count = 0;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum < target) {
                count += end - start;
                start++;
            } else if (sum >= target) {
                end--;
            }
        }
        return count;
    }
}
