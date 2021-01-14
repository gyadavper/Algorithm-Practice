package com.gyadav.practice.ctci.ch10;

public class QuickSort {
    public static void sort (int[] arr) {
        quickSortRecursive(arr, 0, arr.length - 1);
    }
    public static void quickSortRecursive (int[] arr, int start, int end) {
        if (start >= end)
            return;
        int pivot = (int) Math.random() * (end - start) + start;
        swap(arr, start, pivot);
        int smaller = start;
        for (int bigger = start; bigger <= end; bigger++) {
            if (arr[bigger] < arr[pivot]) {
                smaller++;
                swap(arr, smaller, bigger);
            }
        }
        swap(arr, start, smaller);
        quickSortRecursive(arr, start, smaller - 1);
        quickSortRecursive(arr, smaller + 1, end);
    }

    public static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] a) {
        int[] arr = {5, 8, 1, 3, 4, 6, 0, 2};
        QuickSort.sort(arr);
        System.out.println(arr);
    }
}
