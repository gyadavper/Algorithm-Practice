package com.gyadav.practice.educative.cyclicSort;

public class FirstMissingPositive {
    public static int findNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return i + 1;
    }
    public static void main(String [] a) {
        System.out.println(findNumber(new int[]{3, -2, 0, 1, 2}));
    }
}
