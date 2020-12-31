package com.gyadav.practice.educative.allPatterns.cyclicSort;

public class CyclicSort {
    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
    }
}
