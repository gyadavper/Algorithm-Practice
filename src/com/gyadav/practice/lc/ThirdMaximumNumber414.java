package com.gyadav.practice.lc;

public class ThirdMaximumNumber414 {
    public static void main(String[] a) {
        ThirdMaximumNumber414 thirdMaximumNumber414 = new ThirdMaximumNumber414();
        System.out.println(thirdMaximumNumber414.thirdMax(new int[]{1,2,-2147483648}));
    }

    public int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, thirdMax = Integer.MIN_VALUE;
        boolean found = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == 0) {
                    max = Math.max(max, nums[j]);
                }
                if (i == 1 && nums[j] != max)
                    secondMax = Math.max(secondMax, nums[j]);
                if (i == 2 && nums[j] != max && nums[j] != secondMax) {
                    thirdMax = Math.max(thirdMax, nums[j]);
                    found = true;
                }
            }
        }
        return found ? thirdMax : max;
    }
}
