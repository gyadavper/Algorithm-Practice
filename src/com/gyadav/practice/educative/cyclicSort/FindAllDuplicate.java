package com.gyadav.practice.educative.cyclicSort;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicate {
    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
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
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                duplicateNumbers.add(nums[i]);
        }
        return duplicateNumbers;
    }

    public static void main(String[] ar) {
        System.out.println(findNumbers(new int[]{3, 4, 4, 5, 5}));
    }
}
