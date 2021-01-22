package com.gyadav.practice.educative_rev3.twopointers;

public class DutchFlag {
    public static void sort(int[] arr) {
        int left = 0, right = arr.length - 1, i = 0;
        while (i <= right) {
            if (arr[i] == 0) {
                swap(arr, i, left);
                i++;
                left++;
            } else if (arr[i] == 2) {
                swap(arr, i, right);
                right--;
            } else {
                i++;
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] a) {
        DutchFlag.sort(new int[]{2,0,1});
    }
}
