package com.gyadav.practice.educative.allPatterns.slidingwindow;
/*Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.*/
public class MinSizeSubArraySum {
    public static void main(String[] args) {
        System.out.println(findMinSubArray(7, new int[] {2, 1, 5, 2, 8}));
    }
    public static int findMinSubArray(int S, int[] arr) {
        int sum = 0;
        int startPointer = 0;
        int subArraySize = Integer.MAX_VALUE;
        for (int endPointer = 0; endPointer < arr.length; endPointer++){
            sum = sum + arr[endPointer];
                while (startPointer <= endPointer && sum >= S) {
                    subArraySize = Math.min(subArraySize, (endPointer - startPointer) + 1);
                    sum = sum - arr[startPointer];
                    startPointer++;
                }
            }
        return subArraySize;
    }
}
