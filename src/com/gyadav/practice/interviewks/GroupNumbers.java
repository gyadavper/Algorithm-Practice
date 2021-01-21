package com.gyadav.practice.interviewks;

public class GroupNumbers {
    static int[] solve(int[] arr) {
        int smaller = 0;
        for (int bigger = 0; bigger < arr.length; bigger++) {
            if (arr[bigger] % 2 == 0) {
                swap(arr, smaller, bigger);
                smaller++;
            }
        }
        return arr;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 public static void main(String[] a) {
        solve(new int[] {5,5,7,10,2,2});
 }
}
