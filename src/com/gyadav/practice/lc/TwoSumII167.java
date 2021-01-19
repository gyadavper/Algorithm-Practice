package com.gyadav.practice.lc;

public class TwoSumII167 {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target)
                return new int[]{start, end};
            if (sum < target)
                start++;
            else
                end--;
        }
        return new int[]{-1, -1};
    }
}
