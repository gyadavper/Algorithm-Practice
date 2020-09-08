package com.gyadav.practice.educative.modifiedBinarySearch;

public class FindRange {
    public static int[] findRange(int[] arr, int key) {
        int[] result = new int[] { -1, -1 };
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (key == arr[mid]) {
                for (int j = mid; j >=0; j--) {
                    if (key == arr[j])
                        result[0] = j;
                    else
                        break;
                }
                for (int i = mid; i < arr.length; i++) {
                    if (key == arr[i])
                        result[1] = i;
                    else
                        break;
                }
                return result;
            }
            if (key < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}
