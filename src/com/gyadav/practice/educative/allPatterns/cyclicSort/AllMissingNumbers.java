package com.gyadav.practice.educative.allPatterns.cyclicSort;

import java.util.ArrayList;
import java.util.List;

public class AllMissingNumbers {
    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1)
                missingNumbers.add(j + 1);
        }

        return missingNumbers;
    }
    public static void main(String[] a) {
        System.out.println(findNumbers(new int[] {1, 4, 4, 3,2}));
    }
}
