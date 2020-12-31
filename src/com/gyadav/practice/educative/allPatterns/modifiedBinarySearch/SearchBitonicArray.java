package com.gyadav.practice.educative.allPatterns.modifiedBinarySearch;

public class SearchBitonicArray {
    public static int search(int[] arr, int key) {
        int maxIndex = findMax(arr);
        int searchFirst = binarySearch(arr, 0, maxIndex, key);
        if (searchFirst != -1)
            return searchFirst;
        return binarySearch(arr, maxIndex + 1, arr.length - 1, key);
    }
    public static int findMax (int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start)/2;
            if (arr[mid] > arr[mid + 1])
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }
        public static int binarySearch (int[] arr, int start, int end, int key) {
            boolean isAscending = arr[start] < arr[end];
            while (start <= end) {
                int mid = start + (end - start)/2;
                if (key == arr[mid])
                    return mid;
                if (isAscending) {
                    if (key > arr[mid])
                        start = mid + 1;
                    else
                        end = mid - 1;
                } else {
                    if (key < arr[mid])
                        start = mid + 1;
                    else
                        end = mid - 1;
                }
            }
            return -1;
        }

    public static void main(String[] args) {
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
       // System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
      //  System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
       // System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
    }
}
