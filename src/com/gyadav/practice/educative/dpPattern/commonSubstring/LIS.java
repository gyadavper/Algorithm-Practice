package com.gyadav.practice.educative.dpPattern.commonSubstring;

public class LIS {
    public static void main (String[] a) {
        LIS lis = new LIS();
        System.out.println(lis.calculateLIS(new int[] {4,2,3,6,10,1,12}));
        System.out.println(lis.calculateLIS(new int[] {-4,10,3,7,15}));
    }

    public int calculateLIS(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        return calculateLISRecursive(arr, dp, 0);
    }

    public int calculateLISRecursive(int[] arr, int[][] dp, int index) {
        if (index >= arr.length)
            return 0;
        if (index == arr.length - 1)
            return 1;

        int count1 = 0;

        if (arr[index] <= arr[index + 1]) {
            count1 = 1 + calculateLISRecursive(arr, dp,index + 1);
        }
        int count2 = calculateLISRecursive(arr, dp,index + 1);
        return Math.max(count1, count2);
    }
}
