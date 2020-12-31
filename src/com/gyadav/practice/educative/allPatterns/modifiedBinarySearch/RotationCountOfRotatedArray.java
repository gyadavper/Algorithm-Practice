package com.gyadav.practice.educative.allPatterns.modifiedBinarySearch;

public class RotationCountOfRotatedArray {
    public static int countRotations(int[] arr) {
        int start = 0, end =arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1])
                return mid + 1;
            if (start < mid && arr[mid -1] > arr[mid])
                return mid;
            if (arr[start] < arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return 0;
    }
}
