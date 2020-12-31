package com.gyadav.practice.educative.allPatterns.cyclicSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstKMissingPositive {
    public static List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> missingNumbers = new ArrayList<>();
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
        Set<Integer> extraNumbers = new HashSet<>();
        for (i = 0; i < nums.length && missingNumbers.size() < k; i++) {
            if (nums[i] != i + 1) {
                missingNumbers.add(i+1);
                extraNumbers.add(nums[i]);
            }
        }
        for (i = 1; missingNumbers.size() < k; i++) {
            int checkNumber = i + nums.length;
            if(!extraNumbers.contains(checkNumber)) {
                missingNumbers.add(checkNumber);
            }
        }
        return missingNumbers;
    }
    public static void main(String [] a) {
        System.out.println(findNumbers(new int[] {2, 3, 4},3));
    }
}
