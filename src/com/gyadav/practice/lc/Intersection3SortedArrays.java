package com.gyadav.practice.lc;

import java.util.ArrayList;
import java.util.List;

public class Intersection3SortedArrays {
    public static void main(String[] a) {
        Intersection3SortedArrays intersection3SortedArrays = new Intersection3SortedArrays();
        intersection3SortedArrays.arraysIntersection(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 5, 7, 9}, new int[]{1, 3, 4, 5, 8});
    }

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> output = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < arr1.length) {
            if (i > 0 && arr1[i] == arr1[i - 1])
                continue;
            while (j < arr2.length && arr2[j] < arr1[i])
                j++;
            while (k < arr3.length && arr3[k] < arr1[i])
                k++;
            if (j == arr2.length || k == arr3.length)
                break;
            if (arr2[j] == arr1[i] && arr3[k] == arr1[i]) {
                output.add(arr1[i]);
                j++;
                k++;
                while (j < arr2.length - 1 && arr2[j] == arr1[i] && arr2[j] == arr2[j - 1])
                    j++;
                while (k < arr3.length - 1 && arr3[k] == arr1[i] && arr3[k] == arr3[k - 1])
                    k++;
            }
            i++;
        }
        return output;
    }
}
