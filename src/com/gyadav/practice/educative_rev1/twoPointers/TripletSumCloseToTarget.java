package com.gyadav.practice.educative_rev1.twoPointers;

import java.util.Arrays;

public class TripletSumCloseToTarget {
    public static int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int right = arr.length, min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++){
            if (i > 0 && arr[i-1] == arr[i])
                continue;
            int left = i + 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                int absDiff = Math.abs(targetSum - sum);
                if (absDiff == 0)
                    return 0;
                min = Math.min(min, absDiff);
                int diff = targetSum - sum;
                if (diff > 0)
                    right --;
                else
                    left ++;
            }
        }
        return min;
    }
}
