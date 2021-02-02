package com.gyadav.practice.interviewks;

public class CheckSum {
    static boolean check_if_sum_possible(long[] arr, long k) {
        return checkSumPossibleHelper(arr, 0,  k);
    }
    static boolean checkSumPossibleHelper(long[] arr, int index, long k) {
        // Backtracking case
        if(k == 0)
            return true;

        // Base case: Leaf Node
        if(index == arr.length)
            return false;

        // Recursive case: Internal node worker
        // Skip
        boolean b1 = checkSumPossibleHelper(arr, index + 1, k - arr[index]);

        // Add the Number
        boolean b2 = checkSumPossibleHelper(arr, index + 1, k + arr[index]);

        return b1 || b2;
    }
    public static void main(String[] a) {
        CheckSum checkSum = new CheckSum();
        System.out.println(CheckSum.check_if_sum_possible(new long[]{1000000000000l, 1000000000000l, 1000000000000l},-1000000000000l));
    }
}
