package com.gyadav.practice.educative.allPatterns.modifiedBinarySearch;

public class MinimumDifference {
    public static int searchMinDiffElement(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (key == arr[mid])
                return mid;
            if (key < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return arr[end];
    }

    public static void main(String[] args) {
        //System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
        //System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
        //System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
    }
}
