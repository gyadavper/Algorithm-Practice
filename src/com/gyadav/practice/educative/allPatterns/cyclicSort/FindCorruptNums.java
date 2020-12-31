package com.gyadav.practice.educative.allPatterns.cyclicSort;

public class FindCorruptNums {
    public static int[] findNumbers(int[] nums) {
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
            if (nums[i] != i+1) {
                return new int[] {nums[i], i + 1};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] a) {
        findNumbers(new int[]{3, 1, 2, 3, 6, 4});
    }
}
