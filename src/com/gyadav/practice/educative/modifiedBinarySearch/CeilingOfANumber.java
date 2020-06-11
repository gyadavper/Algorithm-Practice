package com.gyadav.practice.educative.modifiedBinarySearch;

public class CeilingOfANumber {
    public static int searchCeilingOfANumber(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        if (key < arr[start])
            return 0;
        if (key > arr[end])
            return -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key == arr[mid])
                return mid;
            if (key < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }
}
