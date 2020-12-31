package com.gyadav.practice.educative.allPatterns.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupleSumToTarget {
    public static void main(String[] a) {
        searchQuadruplets(new int[]{0, 0, 0, 0}, 0);
    }

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;
                search(quadruplets, arr, i, j, target);
            }
        }
        return quadruplets;
    }

    private static void search(List<List<Integer>> quadruplets, int[] arr, int i, int j, int target) {
        int first = j + 1, last = arr.length - 1;
        while (first < last) {
            int sum = arr[i] + arr[j] + arr[first] + arr[last];
            if (sum == target) {
                quadruplets.add(Arrays.asList(arr[i], arr[j], arr[first], arr[last]));
                first++;
                last--;
                while (first < last && arr[first] == arr[first - 1])
                    first++;
                while (first < last && arr[last] == arr[last + 1])
                    last--;
            } else if (sum < target)
                first++;
            else
                last--;
        }
    }
}
