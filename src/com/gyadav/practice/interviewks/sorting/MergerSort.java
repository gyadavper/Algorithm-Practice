package com.gyadav.practice.interviewks.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergerSort {
    public static List<Integer> merge_sort(List<Integer> arr) {
        int[] auxArr = new int[arr.size()];
        merge_sort_recursive(arr, 0, arr.size() - 1, auxArr);
        return arr;
    }
    public static void merge_sort_recursive(List<Integer> arr, int start, int end, int[] auxArr) {
        if (start >= end)
            return;
        int mid = start + (end - start) / 2;
        merge_sort_recursive(arr, start, mid, auxArr);
        merge_sort_recursive(arr, mid + 1, end, auxArr);
        merge(arr, auxArr, start, mid, end);
    }

    public static void merge(List<Integer> arr, int[] auxArr, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            auxArr[i] = arr.get(i);
        }
        int arr1Start = start;
        int arr2Start = mid + 1;
        int current = start;

        while (arr1Start <= mid && arr2Start <= end) {

            if (auxArr[arr1Start] <= auxArr[arr2Start]) {
                arr.set(current, auxArr[arr1Start]);
                arr1Start++;
            } else {
                arr.set(current, auxArr[arr2Start]);
                arr2Start++;
            }
            current++;
        }

        for (int i = arr1Start; i <= mid; i++) {
            arr.set(current++, auxArr[i]);
        }
        for (int i = arr2Start; i <= end; i++) {
            arr.set(current++, auxArr[i]);
        }
    }

    public static void main(String[] a) {
        List<Integer> list = new ArrayList<>(Arrays.asList(7, 1, 3, 5, 7, -2, -4, -6));
        List<Integer> newList = MergerSort.merge_sort(list);
        System.out.println(newList);
    }

}
