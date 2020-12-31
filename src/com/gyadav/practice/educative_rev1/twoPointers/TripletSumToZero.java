package com.gyadav.practice.educative_rev1.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++){
            if (i > 0 && arr[i] == arr[i-1])
                continue;
            searchSum(arr, -arr[i], i +1, triplets);
        }
        return triplets;
    }
    public static void searchSum(int[] arr, int target, int left, List<List<Integer>> triplets){

    }
}
