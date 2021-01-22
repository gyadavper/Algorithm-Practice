package com.gyadav.practice.educative_rev3.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (i != 0 && arr[i] == arr[i-1])
                continue;
            find2Sum(arr, -arr[i], i + 1, arr.length - 1, triplets);
        }
        return triplets;
    }
    public static void find2Sum(int[] arr, int target, int start, int end, List<List<Integer>> triplets) {
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == target) {
                triplets.add(Arrays.asList(-target, arr[start], arr[end]));
                start++;
                end--;
                while (start < end && arr[start - 1] == arr[start])
                    start++;
                while (start < end && arr[end + 1] == arr[end])
                    end--;
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
    }
}
