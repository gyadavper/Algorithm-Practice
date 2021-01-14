package com.gyadav.practice.ctci.ch10;

public class MergeSort {
    public static void sort(int[] arr) {
        int[] auxArr = new int[arr.length];
        mergeRecursive(arr, 0, arr.length - 1, auxArr);
    }

    public static void mergeRecursive(int[] arr, int start, int end, int[] auxArr) {
        if (start >= end)
            return;
        int mid = (end + start) / 2;
        mergeRecursive(arr, start, mid, auxArr);
        mergeRecursive(arr, mid + 1, end, auxArr);
        merge(arr, start, mid, end, auxArr);
    }

    public static void merge(int[] arr, int start, int mid, int end, int[] auxArr) {
        for (int i = start; i <= end; i++)
            auxArr[i] = arr[i];

        int auxStart = start;
        int auxMid = mid + 1;
        int current = start;

        while (auxStart <= mid && auxMid <= end) {

            if (auxArr[auxStart] <= auxArr[auxMid]) {
                arr[current] = auxArr[auxStart];
                auxStart++;
            } else {
                arr[current] = auxArr[auxMid];
                auxMid++;
            }
            current++;
        }

        for (int i = auxStart; i <= mid; i++)
            arr[current++] = auxArr[i];
        for (int i = auxMid; i <= end; i++)
            arr[current++] = auxArr[i];
    }

    public static void main(String[] a) {
        int[] arr = {5, 8, 1, 3, 4, 6, 0, 2};
        MergeSort.sort(arr);
        System.out.println(arr);
    }
}
