package com.gyadav.practice.educative.twopointer;

import java.util.ArrayList;
import java.util.List;

public class SubarrayProductLessThanK {
    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int multiple = 1;
        int left = 0;
        for(int right = 0; right < arr.length; right++){
            multiple = multiple * arr[right];
            while(multiple >= target && left < arr.length) {
                multiple = multiple / arr[left];
                left++;
            }
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = right; i >= left; i--){
                list.add(0, arr[i]);
                result.add(new ArrayList<>(list));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[]{2, 5, 3, 10}, 30));
    }
}
