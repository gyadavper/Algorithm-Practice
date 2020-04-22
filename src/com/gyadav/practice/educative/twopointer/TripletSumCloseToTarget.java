package com.gyadav.practice.educative.twopointer;

import java.util.Arrays;

public class TripletSumCloseToTarget {
    public static int searchTriplet(int[] arr, int targetSum) {
        if (arr == null || arr.length < 2){
            throw new IllegalArgumentException();
        }

        Arrays.sort(arr);
        int smallestDifference = Integer.MAX_VALUE;
        for(int i = 0;i < arr.length - 2;i++){
            int left = i + 1; int right = arr.length - 1;
            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                if(currentSum == targetSum) {
                    return currentSum;
                }
                int closeToTarget = targetSum - currentSum;
                if (Math.abs(closeToTarget) < Math.abs(smallestDifference)
                        || (Math.abs(closeToTarget) == Math.abs(smallestDifference) && closeToTarget > smallestDifference))
                    smallestDifference = Math.min(Math.abs(closeToTarget), smallestDifference);
                if(currentSum > targetSum) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return targetSum - smallestDifference;
    }
}
