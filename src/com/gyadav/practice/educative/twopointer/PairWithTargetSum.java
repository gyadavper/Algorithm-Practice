package com.gyadav.practice.educative.twopointer;

public class PairWithTargetSum {
    public static int[] search(int[] arr, int targetSum) {
        int startPointer = 0;
        int endPointer = arr.length - 1;
        int sum = 0;
        while (startPointer < endPointer){
            sum = arr[startPointer] + arr[endPointer];
            if (sum == targetSum){
                return new int[] {startPointer, endPointer};
            }
            if(sum < targetSum)
                startPointer++;
            else
                endPointer--;
        }
        return new int[] { -1, -1 };
    }
}
