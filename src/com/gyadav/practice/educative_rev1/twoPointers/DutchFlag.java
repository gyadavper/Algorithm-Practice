package com.gyadav.practice.educative_rev1.twoPointers;

public class DutchFlag {
    public static void sort(int[] arr) {
        int left = 0, right = arr.length -1;
        while (left < right) {
            if (arr[left] != 0 && arr[left] > arr[right])
                swap(arr, left, right);
            if (arr[left] == 0)
                left++;
            if (arr[right] == 2)
                right--;
            if (arr[left] == 1 && arr[right] == 1)
                break;
        }
    }
    public static void swap (int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] a) {
        sort(new int[]{1,0,2,1,0});
    }
}
